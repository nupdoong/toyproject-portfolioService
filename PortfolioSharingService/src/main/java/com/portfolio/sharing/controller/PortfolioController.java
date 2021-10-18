package com.portfolio.sharing.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.sharing.model.Response;
import com.portfolio.sharing.model.request.RequestPortfolio;
import com.portfolio.sharing.service.PortfolioService;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {
	@Autowired
    private PortfolioService portfolioService;
	
	@PostMapping("/construct")
    public Response constructPortfolio(@RequestBody RequestPortfolio portfolio) {
        try {
        	portfolioService.constructPortfolio(portfolio);
            return new Response("success", "포트폴리오가 성공적으로 추가되었습니다.", null);
        } catch (Exception e) {
            return new Response("error", "포트폴리오를 추가하는 도중 오류가 발생했습니다.", null);
        }
    }

}
