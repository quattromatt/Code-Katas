package com.codekata.backtothecheckout;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public String foo() {
		return "FOO!";
	}
	
}
