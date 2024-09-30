package com.alex.analisecredito.service.strategy;

import com.alex.analisecredito.domain.Proposta;

public interface CalculoPontuacao {
    int calcular(Proposta proposta);
}
