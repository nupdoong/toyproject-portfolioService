package com.portfolio.security.model.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestChangePassword2 {
    String username;
    String password;
}