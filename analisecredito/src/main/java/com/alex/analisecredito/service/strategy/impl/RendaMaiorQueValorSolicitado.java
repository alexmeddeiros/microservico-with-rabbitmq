package com.alex.analisecredito.service.strategy.impl;

import com.alex.analisecredito.domain.Proposta;
import com.alex.analisecredito.service.strategy.CalculoPontuacao;
import org.springframework.stereotype.Component;

@Component
public class RendaMaiorQueValorSolicitado implements CalculoPontuacao {
    @Override
    public int calcular(Proposta proposta) {
        return rendaMaiorQueValorSolicitado(proposta) ? 100 : 0;

    }

    private boolean rendaMaiorQueValorSolicitado(Proposta proposta){
        return proposta.getUsuario().getRenda() > proposta.getValorSolicitado();
    }
}