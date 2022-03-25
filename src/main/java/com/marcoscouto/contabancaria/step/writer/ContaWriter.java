package com.marcoscouto.contabancaria.step.writer;

import com.marcoscouto.contabancaria.data.Conta;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class ContaWriter {

    @Bean
    public JdbcBatchItemWriter<Conta> gravarConta(DataSource dataSource) {
        JdbcBatchItemWriter<Conta> itemWriter = new JdbcBatchItemWriter<>();
        itemWriter.setDataSource(dataSource);
        itemWriter.setSql("INSERT INTO conta (tipo, limite, cliente_id) VALUES (:tipo, :limite, :cliente)");
        itemWriter.setItemSqlParameterSourceProvider(conta -> {
            final MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
            sqlParameterSource.addValue("tipo", conta.getTipoConta().toString());
            sqlParameterSource.addValue("limite", conta.getLimite());
            sqlParameterSource.addValue("cliente", conta.getCliente().getNome());
            return sqlParameterSource;
        });
        return itemWriter;
    }

}
