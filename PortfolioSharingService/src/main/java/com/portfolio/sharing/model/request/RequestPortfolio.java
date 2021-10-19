package com.portfolio.sharing.model.request;

import javax.validation.constraints.NotBlank;

import com.portfolio.sharing.model.PortfolioData;
import com.portfolio.sharing.model.PortfolioData.PortfolioDataBuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RequestPortfolio {
	
	private String username;
    private String ticker;
    private double avgprice;
    private int stockEA;
    
    public PortfolioDataBuilder toEntity() {
    	PortfolioDataBuilder build = PortfolioData.builder()
    			.username(username)
    			.ticker(ticker)
    			.avgprice(avgprice)
    			.stockEA(stockEA);
    	return build;
    }
    
    @Builder
    public RequestPortfolio(@NotBlank String username, @NotBlank String ticker, @NotBlank double avgprice, @NotBlank int stockEA) {
        this.username = username;
        this.ticker = ticker;
        this.avgprice = avgprice;
        this.stockEA = stockEA;
    }
}
