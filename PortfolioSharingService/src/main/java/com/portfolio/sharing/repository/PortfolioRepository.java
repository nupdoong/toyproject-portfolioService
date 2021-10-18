package com.portfolio.sharing.repository;

import com.portfolio.sharing.model.PortfolioData;
import org.springframework.data.repository.CrudRepository;

public interface PortfolioRepository extends CrudRepository<PortfolioData, Long> {

	PortfolioData findByUsername(String username);

}
