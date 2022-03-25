package com.marcoscouto.contabancaria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;

@SpringBootApplication
@EnableBatchProcessing
public class ContabancariaApplication {

    private static final StopWatch stopWatch = new StopWatch();
    private static final Logger logger = LoggerFactory.getLogger(ContabancariaApplication.class);

	public static void main(String[] args) {
		stopWatch.start();
		SpringApplication.run(ContabancariaApplication.class, args);
		stopWatch.stop();
        logger.info("Tempo de execução: {}", stopWatch.getTotalTimeSeconds());
    }

}
