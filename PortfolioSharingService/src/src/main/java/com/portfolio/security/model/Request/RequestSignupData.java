package com.portfolio.security.model.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestSignupData {
	private String username;
	private String password;
	private String name;
	private String email;
	private String address;
	
	public RequestSignupData(String username, String password, String name, String email, String address) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
    }

}
