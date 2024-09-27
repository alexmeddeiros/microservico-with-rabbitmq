package com.alex.propostaapp.agendador;

import com.alex.propostaapp.entity.Proposta;
import com.alex.propostaapp.repository.PropostaRepository;
import com.alex.propostaapp.service.NotificacaoRabbitMQService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class PropostaSemIntegracao {

    private PropostaRepository repository;
    private NotificacaoRabbitMQService notificacaoRabbitMQService;
    private String exchange;
    private final Logger logger = LoggerFactory.getLogger(PropostaSemIntegracao.class);

    public PropostaSemIntegracao(PropostaRepository repository,
                                 @Value("${rabbitmq-propostapendente-exchange}") String exchange,
                                 NotificacaoRabbitMQService notificacaoRabbitMQService) {
        this.repository = repository;
        this.exchange = exchange;
        this.notificacaoRabbitMQService = notificacaoRabbitMQService;
    }
    @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
    public void buscaPropostaSemIntegracao() {
        repository.findAllByIntegradaIsFalse().forEach(proposta -> {
            try {
                notificacaoRabbitMQService.notificar(proposta, exchange);
                atualizarProposta(proposta);
            } catch (RuntimeException e) {
                logger.error(e.getMessage());
            }
        });
    }

    private void atualizarProposta(Proposta proposta){
        proposta.setIntegrada(true);
        repository.save(proposta);
    }
}
