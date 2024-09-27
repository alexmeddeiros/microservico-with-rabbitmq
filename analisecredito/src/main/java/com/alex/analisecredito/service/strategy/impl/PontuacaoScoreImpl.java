package com.alex.analisecredito.service.strategy.impl;

import com.alex.analisecredito.domain.Proposta;
import com.alex.analisecredito.service.strategy.CalculoPontuacao;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(2)
@Component
public class PontuacaoScoreImpl implements CalculoPontuacao {

    @Override
    public int calcular(Proposta proposta) {
        int score = score();
        if(score <= 200){
            throw new RuntimeException("Score baixo");
        } else if (score <= 400) {
            return 150;
        } else if (score <= 600) {
            return 180;
        }else{
            return 200;
        }
    }

    private int score(){
        return new Random().nextInt(0,1000);
    }
}
