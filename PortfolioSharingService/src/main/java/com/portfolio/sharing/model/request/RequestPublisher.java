package com.portfolio.sharing.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class RequestPublisher {

	private String subscriber;
	private String publisher;
	
	@Builder
	public RequestPublisher(String subscriber, String publisher){
		this.subscriber = subscriber;
		this.publisher = publisher;
	}
	
}
