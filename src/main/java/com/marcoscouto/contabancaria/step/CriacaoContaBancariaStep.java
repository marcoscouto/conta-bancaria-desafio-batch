package com.marcoscouto.contabancaria.step;

import com.marcoscouto.contabancaria.data.Cliente;
import com.marcoscouto.contabancaria.data.Conta;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CriacaoContaBancariaStep {

    private final StepBuilderFactory stepBuilderFactory;
    private final JdbcPagingItemReader<Cliente> reader;
    private final FunctionItemProcessor<Cliente, Conta> processor;
    private final JdbcBatchItemWriter<Conta> writer;

    public CriacaoContaBancariaStep(StepBuilderFactory stepBuilderFactory, JdbcPagingItemReader<Cliente> reader, FunctionItemProcessor<Cliente, Conta> processor, JdbcBatchItemWriter<Conta> writer) {
        this.stepBuilderFactory = stepBuilderFactory;
        this.reader = reader;
        this.processor = processor;
        this.writer = writer;
    }

    @Bean
    public Step executarStep() {
        return stepBuilderFactory.get("executarStep")
                .<Cliente, Conta>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}

