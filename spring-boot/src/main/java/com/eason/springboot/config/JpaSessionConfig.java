package com.eason.springboot.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.eason.springboot.dao.jpa") // 不加会自动扫描
@EntityScan(basePackages = "com.eason.springboot.domain.jpa") // 不加会自动扫描
public class JpaSessionConfig {
//
//	@Bean
//    public EntityManagerFactory sessionFactory() {
//		
//		EntityManagerFactory sessionFactory=new EntityManagerFactory() {
//			
//		};
//        return sessionFactory;
//    }

}
