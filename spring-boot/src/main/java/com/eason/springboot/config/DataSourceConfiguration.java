package com.eason.springboot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

// @Configuration // 启动之后可以配置自己的连接池
public class DataSourceConfiguration {

	// c3p0 连接池
	@Bean(name = "dataSource")
	@Qualifier(value = "dataSource")
	@Primary
	@ConfigurationProperties(prefix = "c3p0")
	public DataSource dataSource() {

		return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
	}

	// Hikari 连接池
	@Bean(name = "dataSource") // 这个连接池 Spring boot 已经提供了，这部分代码只是为了演示，如何创建 DataSource， 没有价值
	public DataSource dataSource(@Autowired Environment environment) {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl(environment.getProperty("spring.datasource.url"));
		ds.setUsername(environment.getProperty("spring.datasource.username"));
		ds.setPassword(environment.getProperty("spring.datasource.password"));
		ds.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
		return ds;
	}
}