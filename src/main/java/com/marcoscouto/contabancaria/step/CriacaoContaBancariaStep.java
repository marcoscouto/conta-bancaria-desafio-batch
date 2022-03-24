package com.marcoscouto.contabancaria.step;

import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.stereotype.Component;

@Component
public class CriacaoContaBancariaStep {

    private final StepBuilderFactory stepBuilderFactory;

    public CriacaoContaBancariaStep(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }
    
}
