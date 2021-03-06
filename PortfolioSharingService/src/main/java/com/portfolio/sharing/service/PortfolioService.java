package com.portfolio.sharing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.sharing.model.PortfolioData;
import com.portfolio.sharing.model.SubscribeList;
import com.portfolio.sharing.model.request.RequestPortfolio;
import com.portfolio.sharing.model.request.RequestPublisher;

import javassist.NotFoundException;

@Service
public interface PortfolioService {

	public PortfolioData constructPortfolio(RequestPortfolio portfolio);
	
	public List<RequestPortfolio> getPortfoliolist(String username) throws NotFoundException;

	RequestPortfolio changePortfolio(PortfolioData portfolioData, RequestPortfolio portfolio);

	RequestPortfolio mylistDetail(String username, String ticker);
	
	RequestPortfolio deletePortfolio(String username, String ticker);

	PortfolioData findByUsernameAndTicker(String username, String ticker);
	
	public SubscribeList addPublisher(RequestPublisher publisherData);
	
	public List<RequestPublisher> getPublisherList(String subscriber) throws NotFoundException;

	RequestPublisher deletePublisher(String subscriber, String publisher);
}