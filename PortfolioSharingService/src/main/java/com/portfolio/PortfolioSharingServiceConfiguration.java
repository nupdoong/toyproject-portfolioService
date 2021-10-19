package com.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.portfolio.security.service.AuthService;
import com.portfolio.security.service.impl.AuthServiceImpl;
import com.portfolio.sharing.service.PortfolioService;
import com.portfolio.sharing.service.impl.PortfolioServiceImpl;

@Configuration
@EnableJpaRepositories
@EnableJpaAuditing
public class PortfolioSharingServiceConfiguration {
	@Bean
	public AuthService authService() {
		return new AuthServiceImpl();
	}
	@Bean
	public PortfolioService portfolioService() {
		return new PortfolioServiceImpl();
	}

}
