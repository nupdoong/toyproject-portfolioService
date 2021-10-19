package com.portfolio.sharing.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;


import com.portfolio.sharing.model.request.RequestPortfolio;
import com.portfolio.sharing.repository.PortfolioRepository;
import com.portfolio.sharing.service.PortfolioService;

import javassist.NotFoundException;

import com.portfolio.sharing.model.PortfolioData;

public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
    private PortfolioRepository portfolioRepository;
	
	@Override
    @Transactional
    public void constructPortfolio(RequestPortfolio portfolio) {
		
		PortfolioData portfolioData = new PortfolioData();
        portfolioData.setUsername(portfolio.getUsername());
        portfolioData.setTicker(portfolio.getTicker());
        portfolioData.setAvgprice(portfolio.getAvgprice());
        portfolioData.setStockEA(portfolio.getStockEA());
        portfolioRepository.save(portfolioData);
    }


	@Override
	@Transactional
	public List<RequestPortfolio> getPortfoliolist(String username) throws NotFoundException {
		List<PortfolioData> portfolios = portfolioRepository.findByUsername(username);
		if(portfolios == null) throw new NotFoundException("포트폴리오가 없습니다.");
		List<RequestPortfolio> portfolioList = new ArrayList<>();
		for(PortfolioData portfolio : portfolios) {
			RequestPortfolio requestPortfolio = RequestPortfolio.builder()
					.username(portfolio.getUsername())
					.ticker(portfolio.getTicker())
					.avgprice(portfolio.getAvgprice())
					.stockEA(portfolio.getStockEA())
					.build();
			portfolioList.add(requestPortfolio);
		}
		return portfolioList;
	}
	
	
}
