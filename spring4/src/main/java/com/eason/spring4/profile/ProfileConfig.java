package com.eason.spring4.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan("com.eason.spring4.profile")
public class ProfileConfig {

	@Bean
	@Profile("dev")
	public MyBean devMyBean() {
		return new MyBean("from development profile!!!");
	}
	
	@Bean
	@Profile("prod")
	public MyBean prodMyBean() {
		return new MyBean("from production profile!!!");
	}
}
