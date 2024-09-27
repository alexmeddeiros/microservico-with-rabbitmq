package com.alex.notifacao.listener;

import com.alex.notifacao.constante.MensagemConstante;
import com.alex.notifacao.domain.Proposta;
import com.alex.notifacao.service.NotificacaoSnsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropostaPendenteListener {

    @Autowired
    private NotificacaoSnsService notificacaoSnsService;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void propostaPendente(Proposta proposta){
        String mensagem = String.format(MensagemConstante.PROPOSTA_EM_ANALISE, proposta.getUsuario().getNome());

        notificacaoSnsService.notificar(proposta.getUsuario().getTelefone(), mensagem);
    }
}
