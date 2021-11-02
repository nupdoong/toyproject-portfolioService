package com.portfolio.sharing.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Subscription")
@Getter
@Setter
public class SubscribeList {

	@Id
    @GeneratedValue
    private int seq;

    @NotBlank
    private String subscriber;
    @NotBlank
    private String publisher;
    
    public SubscribeList() {
    	
    }
    
    @Builder
    public SubscribeList(@NotBlank String subscriber, @NotBlank String publisher) {
    	this.subscriber = subscriber;
    	this.publisher = publisher;
    }
    
    @Override
    public String toString() {
        return "Subscription[" +
                "seq=" + seq +
                ", subscriber='" + subscriber + 
                ", publisher='" + publisher + 
                "]";
    }
}
