package com.portfolio.sharing.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.sharing.model.PortfolioData;
import com.portfolio.sharing.model.SubscribeList;
import com.portfolio.sharing.model.request.RequestPortfolio;
import com.portfolio.sharing.model.request.RequestPublisher;
import com.portfolio.sharing.service.PortfolioService;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {
	@Autowired
    private PortfolioService portfolioService;
	
	@PostMapping("/construction")
    public ResponseEntity<PortfolioData> constructPortfolio(@Valid @RequestBody RequestPortfolio portfolio) {
		try {
			return ResponseEntity.ok().body(
					portfolioService.constructPortfolio(portfolio)
					);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
	
	
	@GetMapping("/mylist")
	public ResponseEntity<List<RequestPortfolio>> findPortfolioListByUsername(@RequestParam("username") String username) {
		try {
			return ResponseEntity.ok()
					.body(
							portfolioService.getPortfoliolist(username)
							);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/mylist/{ticker}")
	public ResponseEntity<RequestPortfolio> mylistDetail(@RequestParam("username") String username, @PathVariable String ticker) {
		try {
			return ResponseEntity.ok()
					.body(
							portfolioService.mylistDetail(username, ticker)
							);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/mylist/{ticker}/edit")
	public ResponseEntity<RequestPortfolio> editPortfolio(@RequestParam("username") String username, @PathVariable String ticker) {
		try {
			return ResponseEntity.ok()
					.body(
							portfolioService.mylistDetail(username, ticker)
							);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@PutMapping("/mylist/{ticker}/edit")
    public ResponseEntity<RequestPortfolio> changePortfolio(@PathVariable String ticker, @RequestBody RequestPortfolio portfolio) {
		try {
			PortfolioData portfolioData = portfolioService.findByUsernameAndTicker(portfolio.getUsername(), ticker);
			return ResponseEntity.ok()
					.body(
							portfolioService.changePortfolio(portfolioData, portfolio)
							);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
    }
	
	@DeleteMapping("/mylist/{ticker}")
	public ResponseEntity<RequestPortfolio> deletePortfolio(@RequestParam("username") String username, @PathVariable String ticker) {
		try {
			return ResponseEntity.ok()
					.body(
							portfolioService.deletePortfolio(username, ticker)
							);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
    }
	
	@GetMapping("/subscribelist")
	public ResponseEntity<List<RequestPublisher>> mySubscribeList(@RequestParam("username") String subscriber){
		try {
			return ResponseEntity.ok()
					.body(
							portfolioService.getPublisherList(subscriber)
							);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@PostMapping("/subscribelist")
	public ResponseEntity<SubscribeList> addPublisher(@Valid @RequestBody RequestPublisher subscribeData){
		try {
			return ResponseEntity.ok().body(
					portfolioService.addPublisher(subscribeData)
					);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/subscribelist/{publisher}")
	public ResponseEntity<List<RequestPortfolio>> findPortfolioListByPublisher(@RequestParam("publisher") String publisher) {
		try {
			return ResponseEntity.ok()
					.body(
							portfolioService.getPortfoliolist(publisher)
							);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@DeleteMapping("/subscribelist/{publisher}")
	public ResponseEntity<RequestPublisher> deletePublisher(@RequestParam("username") String subscriber, @PathVariable String publisher) {
		try {
			return ResponseEntity.ok()
					.body(
							portfolioService.deletePublisher(subscriber, publisher)
							);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
    }
	
	@GetMapping("/subscribelist/{publisher}/{ticker}")
	public ResponseEntity<RequestPortfolio> publisherPortfolioDetail(@RequestParam("publisher") String publisher, @PathVariable String ticker) {
		try {
			return ResponseEntity.ok()
					.body(
							portfolioService.mylistDetail(publisher, ticker)
							);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
