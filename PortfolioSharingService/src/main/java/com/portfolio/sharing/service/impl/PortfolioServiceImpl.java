package com.portfolio.sharing.service.impl;

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
	public PortfolioData findByUsername(String username) throws NotFoundException {
		PortfolioData portfolioData = portfolioRepository.findByUsername(username);
		if(portfolioData == null) throw new NotFoundException("포트폴리오가 없습니다.");
		return null;
	}

	@Override
	public void MyPortfolioList(String username) throws NotFoundException {
		
		
	}

	@Override
	public List<PortfolioData> list() throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
