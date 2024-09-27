package com.alex.analisecredito.service.strategy.impl;

import com.alex.analisecredito.domain.Proposta;
import com.alex.analisecredito.service.strategy.CalculoPontuacao;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(1)
@Component
public class NomeNegativadoImpl implements CalculoPontuacao {
    @Override
    public int calcular(Proposta proposta) {
        if(nomeNegativado()){
            throw new RuntimeException("Nome negativado!");
        }
        return 100;
    }


    private boolean nomeNegativado(){
        return new Random().nextBoolean();
    }
}
