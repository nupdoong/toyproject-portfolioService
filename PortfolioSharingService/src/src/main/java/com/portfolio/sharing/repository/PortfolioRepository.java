package com.portfolio.sharing.repository;

import com.portfolio.sharing.model.PortfolioData;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PortfolioRepository extends CrudRepository<PortfolioData, Long> {

	
	List<PortfolioData> findByUsername(String username);

	PortfolioData findByUsernameAndTicker(String username, String ticker);

	void deleteByUsernameAndTicker(String username, String ticker);

}