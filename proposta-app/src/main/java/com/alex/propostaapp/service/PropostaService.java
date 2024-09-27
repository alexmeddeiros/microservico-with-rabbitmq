package com.alex.propostaapp.service;

import com.alex.propostaapp.dto.PropostaRequestDto;
import com.alex.propostaapp.dto.PropostaResponseDto;
import com.alex.propostaapp.entity.Proposta;
import com.alex.propostaapp.mapper.PropostaMapper;
import com.alex.propostaapp.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropostaService {

    private PropostaRepository repository;
    private NotificacaoRabbitMQService notificacaoService;
    private String exchange;

    // Obs:
    /*
        Como tenho o construtor dos dos serviços que preciso estanciar/carregar, nao preciso utilizar a anotação
        @Autowired
     */
    public PropostaService(PropostaRepository repository,
                           NotificacaoRabbitMQService notificacaoService,
                           @Value("${rabbitmq- propostapendente-exchange}") String exchange) {
        this.repository = repository;
        this.notificacaoService = notificacaoService;
        this.exchange = exchange;
    }

    public PropostaResponseDto criar(PropostaRequestDto requestDto){
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(requestDto);
        repository.save(proposta);
        notificarRabbitMQ(proposta);
        return PropostaMapper.INSTANCE.convertEntityToDto(proposta);
    }

    private void notificarRabbitMQ(Proposta proposta){
        try {
            notificacaoService.notificar(proposta, exchange);
        } catch (RuntimeException e) {
            proposta.setIntegrada(false);
            repository.save(proposta);
        }

    }

    public List<PropostaResponseDto> obterProposta() {
        return PropostaMapper.INSTANCE.convertListEntityToListDto(repository.findAll());
    }
}
