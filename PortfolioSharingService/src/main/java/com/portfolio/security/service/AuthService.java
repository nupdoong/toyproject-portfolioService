package com.portfolio.security.service;

import com.portfolio.security.config.UserRole;
import com.portfolio.security.model.Member;
import com.portfolio.security.model.Request.RequestSignupData;
import com.portfolio.security.model.Request.RequestSocialData;
import javassist.NotFoundException;

public interface AuthService {

    final String REDIS_CHANGE_PASSWORD_PREFIX="CPW";

    void signUpUser(Member member);

    void signUpSocialUser(RequestSocialData member);

    Member loginSocialUser(String id, String type) throws NotFoundException;

    Member loginUser(String username, String password) throws Exception;

    Member findByUsername(String username) throws NotFoundException;

    void verifyEmail(String key) throws NotFoundException;

    void sendVerificationMail(Member member) throws NotFoundException;
    void modifyUserRole(Member member, UserRole userRole);

    boolean isPasswordUuidValidate(String key);

    void changePassword(Member member, String password) throws NotFoundException;

    void requestChangePassword(Member member) throws NotFoundException;
}