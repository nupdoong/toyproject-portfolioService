package com.portfolio.security.model.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestLoginUser {
    private String username;
    private String password;

    public RequestLoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
