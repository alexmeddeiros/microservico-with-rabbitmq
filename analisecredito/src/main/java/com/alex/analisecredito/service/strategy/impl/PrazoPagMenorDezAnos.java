package com.alex.analisecredito.service.strategy.impl;

import com.alex.analisecredito.domain.Proposta;
import com.alex.analisecredito.service.strategy.CalculoPontuacao;
import org.springframework.stereotype.Component;

@Component
public class PrazoPagMenorDezAnos implements CalculoPontuacao {
    @Override
    public int calcular(Proposta proposta) {
        return proposta.getPrazoPagamento() < 120 ? 80 : 0;
    }
}
