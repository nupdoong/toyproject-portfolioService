package com.portfolio.sharing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Portfolios")
@Getter
@Setter
public class PortfolioData {
	
	@Id
    @GeneratedValue
    private int seq;

    @NotBlank
    private String username;
    @NotBlank
    private String ticker;
    @NotNull
    private double avgprice;
    @NotNull
    private int stockEA;
    
    public PortfolioData() {
    }

    @Builder
    public PortfolioData(@NotBlank String username, @NotBlank String ticker, @NotNull double avgprice, @NotNull int stockEA) {
        this.username = username;
        this.ticker = ticker;
        this.avgprice = avgprice;
        this.stockEA = stockEA;
    }

    @Override
    public String toString() {
        return "Portfolio[" +
                "seq=" + seq +
                ", username='" + username + 
                ", ticker='" + ticker + 
                ", avgprice='" + avgprice + 
                ", stockEA='" + stockEA + 
                "]";
    }

}
