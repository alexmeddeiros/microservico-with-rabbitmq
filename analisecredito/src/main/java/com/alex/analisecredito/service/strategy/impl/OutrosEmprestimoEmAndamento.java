package com.alex.analisecredito.service.strategy.impl;

import com.alex.analisecredito.domain.Proposta;
import com.alex.analisecredito.service.strategy.CalculoPontuacao;
import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class OutrosEmprestimoEmAndamento implements CalculoPontuacao {
    @Override
    public int calcular(Proposta proposta) {
        return outrosEmprestimosEmAndamento() ? 0 : 80;
    }

    private boolean outrosEmprestimosEmAndamento(){
        return new Random().nextBoolean();
    }
}
