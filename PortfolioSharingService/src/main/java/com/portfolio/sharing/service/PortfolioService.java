package com.portfolio.sharing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.sharing.model.PortfolioData;
import com.portfolio.sharing.model.request.RequestPortfolio;

import javassist.NotFoundException;

@Service
public interface PortfolioService {

	void constructPortfolio(RequestPortfolio portfolio);
	
	PortfolioData findByUsername(String username) throws NotFoundException;

	void MyPortfolioList(String username) throws NotFoundException;
	
	public List<PortfolioData> list() throws NotFoundException;
}
