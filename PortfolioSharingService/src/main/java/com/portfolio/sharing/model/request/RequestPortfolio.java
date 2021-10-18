package com.portfolio.sharing.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestPortfolio {
	
	private String username;
    private String ticker;
    private double avgprice;
    private int stockEA;
}
