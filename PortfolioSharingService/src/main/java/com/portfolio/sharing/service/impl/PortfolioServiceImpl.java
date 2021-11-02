package com.portfolio.sharing.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.sharing.model.request.RequestPortfolio;
import com.portfolio.sharing.model.request.RequestPublisher;
import com.portfolio.sharing.repository.PortfolioRepository;
import com.portfolio.sharing.repository.SubscribeRepository;
import com.portfolio.sharing.service.PortfolioService;

import javassist.NotFoundException;

import com.portfolio.sharing.model.PortfolioData;
import com.portfolio.sharing.model.SubscribeList;

@Service
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
    private PortfolioRepository portfolioRepository;
	
	@Autowired
	private SubscribeRepository subscribeRepository;
	
	@Override
    @Transactional
    public PortfolioData constructPortfolio(RequestPortfolio portfolio) {
		
		PortfolioData portfolioData = new PortfolioData();
        portfolioData.setUsername(portfolio.getUsername());
        portfolioData.setTicker(portfolio.getTicker());
        portfolioData.setAvgprice(portfolio.getAvgprice());
        portfolioData.setStockEA(portfolio.getStockEA());
        portfolioRepository.save(portfolioData);
        return portfolioData;
    }
	
	@Override
    @Transactional
    public RequestPortfolio changePortfolio(PortfolioData portfolioData, RequestPortfolio portfolio) {
		
        portfolioData.setUsername(portfolio.getUsername());
        portfolioData.setTicker(portfolio.getTicker());
        portfolioData.setAvgprice(portfolio.getAvgprice());
        portfolioData.setStockEA(portfolio.getStockEA());
        portfolioRepository.save(portfolioData);
        return portfolio;
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

	@Override
	@Transactional
	public RequestPortfolio mylistDetail(String username, String ticker) {
		PortfolioData portfolio = portfolioRepository.findByUsernameAndTicker(username, ticker);
		RequestPortfolio requestPortfolio = RequestPortfolio.builder()
				.username(portfolio.getUsername())
				.ticker(portfolio.getTicker())
				.avgprice(portfolio.getAvgprice())
				.stockEA(portfolio.getStockEA())
				.build();
		return requestPortfolio;
	}

	@Override
	@Transactional
	public RequestPortfolio deletePortfolio(String username, String ticker) {
		portfolioRepository.deleteByUsernameAndTicker(username, ticker);
		return null;
	}

	@Override
	@Transactional
	public PortfolioData findByUsernameAndTicker(String username, String ticker) {
		PortfolioData portfolio = portfolioRepository.findByUsernameAndTicker(username, ticker);
		return portfolio;
	}

	@Override
	@Transactional
	public SubscribeList addPublisher(RequestPublisher publisherData) {
		SubscribeList subscribe = new SubscribeList();
		subscribe.setPublisher(publisherData.getSubscriber());
		subscribe.setSubscriber(publisherData.getSubscriber());
		subscribeRepository.save(subscribe);
		return subscribe;
	}

	@Override
	@Transactional
	public List<RequestPublisher> getPublisherList(String subscriber) throws NotFoundException {
		List<SubscribeList> publisherList = subscribeRepository.findBySubscriber(subscriber);
		if(publisherList == null) throw new NotFoundException("구독 중인 사용가 없습니다.");
		List<RequestPublisher> publishingList = new ArrayList<>();
		for(SubscribeList publisherData : publisherList) {
			RequestPublisher requestPublisher = RequestPublisher.builder()
					.subscriber(publisherData.getSubscriber())
					.publisher(publisherData.getPublisher())
					.build();
			publishingList.add(requestPublisher);
		}
		return publishingList;
	}

	@Override
	public RequestPublisher deletePublisher(String subscriber, String publisher) {
		subscribeRepository.deleteBySubscriberAndPublisher(subscriber, publisher);
		return null;
	}
	
}
