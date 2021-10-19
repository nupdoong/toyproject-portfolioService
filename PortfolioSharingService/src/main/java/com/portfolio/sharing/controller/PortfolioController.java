package com.portfolio.sharing.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.sharing.model.PortfolioData;
import com.portfolio.sharing.model.Response;
import com.portfolio.sharing.model.request.RequestPortfolio;
import com.portfolio.sharing.service.PortfolioService;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {
	@Autowired
    private PortfolioService portfolioService;
	
	@PostMapping("/construct")
    public ResponseEntity constructPortfolio(@Valid @RequestBody RequestPortfolio portfolio) {
		try {
		portfolioService.constructPortfolio(portfolio);
        return ResponseEntity.ok(portfolio);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
