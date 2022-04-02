package com.cothis.mybatisenum.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class HikariConfig {

	@Bean
	@ConfigurationProperties("spring.datasource.hikari")
	public DataSource hikariDatasource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
}
