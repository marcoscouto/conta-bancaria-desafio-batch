package com.marcoscouto.contabancaria.step.reader;

import com.marcoscouto.contabancaria.data.Cliente;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
public class ClientesReader {

    // consulta com cursor - é mais performático pois não precisa fazer mais consultas na base, porém utiliza mais memória
    @Bean
    public JdbcCursorItemReader<Cliente> jdbcCursorItemReader(DataSource dataSource) {
        JdbcCursorItemReader<Cliente> reader = new JdbcCursorItemReader<>();
        reader.setDataSource(dataSource);
        reader.setSql("SELECT * FROM clientes");
        reader.setRowMapper(new BeanPropertyRowMapper<Cliente>(Cliente.class));
        return reader;
    }


    // consultas com paginação - é menos performático pois precisa fazer mais consultas na base, porém utiliza menos memória
    @Bean
    public JdbcPagingItemReader jdbcPagingItemReader(DataSource dataSource, PagingQueryProvider queryProvider) {
        JdbcPagingItemReader<Cliente> reader = new JdbcPagingItemReader<>();
        reader.setDataSource(dataSource);
        reader.setPageSize(5);
        reader.setRowMapper(new BeanPropertyRowMapper<Cliente>(Cliente.class));
        reader.setQueryProvider(queryProvider);
        return reader;
    }

    @Bean
    public SqlPagingQueryProviderFactoryBean queryProvider(DataSource dataSource) {
        SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
        queryProvider.setDataSource(dataSource);
        queryProvider.setSelectClause("SELECT *");
        queryProvider.setFromClause("FROM clientes");
        return queryProvider;
    }

}
