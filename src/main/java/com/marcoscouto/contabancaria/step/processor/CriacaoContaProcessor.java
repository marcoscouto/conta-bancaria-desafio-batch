package com.marcoscouto.contabancaria.step.processor;

import com.marcoscouto.contabancaria.data.Cliente;
import com.marcoscouto.contabancaria.data.Conta;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CriacaoContaProcessor {

    @Bean
    public FunctionItemProcessor<Cliente, Conta> processarConta(){
        return new FunctionItemProcessor<>(Conta::new);
    }

}
