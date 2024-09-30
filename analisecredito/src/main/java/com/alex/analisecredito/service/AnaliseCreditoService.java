package com.alex.analisecredito.service;

import com.alex.analisecredito.domain.Proposta;
import com.alex.analisecredito.service.strategy.CalculoPontuacao;
import com.alex.analisecredito.service.strategy.impl.PontuacaoScoreImpl;
import com.alex.analisecredito.service.strategy.impl.PrazoPagMenorDezAnos;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AnaliseCreditoService {
    private List<CalculoPontuacao> listaPontuacao;


    public int analisar(Proposta proposta){
        int sum = listaPontuacao.stream().mapToInt(imp -> imp.calcular(proposta)).sum();
    }


}
