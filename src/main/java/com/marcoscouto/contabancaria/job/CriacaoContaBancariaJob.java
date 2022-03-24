package com.marcoscouto.contabancaria.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CriacaoContaBancariaJob {

    private final JobBuilderFactory jobBuilderFactory;
    private final Step step;

    public CriacaoContaBancariaJob(JobBuilderFactory jobBuilderFactory, Step step) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.step = step;
    }

    @Bean
    public Job executaJob() {
        return jobBuilderFactory
                .get("executaJob")
                .start(step)
                .incrementer(new RunIdIncrementer())
                .build();
    }

}
