package com.portfolio.security.service;

public interface EmailService {

    void sendMail(String to, String sub, String text);
}