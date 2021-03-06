package com.portfolio.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.security.config.UserRole;
import com.portfolio.security.model.Member;
import com.portfolio.security.repository.SocialDataRepository;
import com.portfolio.security.model.Salt;
import com.portfolio.security.model.SocialData;
import com.portfolio.security.model.Request.RequestSignupData;
import com.portfolio.security.model.Request.RequestSocialData;
import com.portfolio.security.repository.MemberRepository;
import com.portfolio.security.service.AuthService;
import com.portfolio.security.service.EmailService;
import com.portfolio.security.service.RedisUtil;
import com.portfolio.security.service.SaltUtil;

import javassist.NotFoundException;

import java.util.UUID;

import javax.transaction.Transactional;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
    private MemberRepository memberRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private SaltUtil saltUtil;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private SocialDataRepository socialDataRepository;

    @Override
    @Transactional
    public void signUpUser(RequestSignupData requestSignupData) {
    	Member newMember = new Member();
    	
        String password = requestSignupData.getPassword();
        String salt = saltUtil.genSalt();
        newMember.setUsername(requestSignupData.getUsername());
        newMember.setName(requestSignupData.getName());
        newMember.setAddress(requestSignupData.getAddress());
        newMember.setEmail(requestSignupData.getEmail());
        newMember.setSalt(new Salt(salt));
        newMember.setPassword(saltUtil.encodePassword(salt,password));
        memberRepository.save(newMember);
    }

    @Override
    @Transactional
    public void signUpSocialUser(RequestSocialData member){
        Member newMember = new Member();
        newMember.setUsername(member.getId());
        newMember.setPassword("");
        newMember.setEmail(member.getEmail());
        newMember.setName(member.getName());
        newMember.setAddress("");
        newMember.setSocial(new SocialData(member.getId(),member.getEmail(),member.getType()));
        memberRepository.save(newMember);
    }

    @Override
    public Member loginSocialUser(String id, String type) throws NotFoundException{
        SocialData socialData = socialDataRepository.findByIdAndType(id,type);
        if(socialData==null) throw new NotFoundException("????????? ???????????? ??????");
        return socialData.getMember();
    }

    @Override
    public Member loginUser(String username, String password) throws Exception{
        Member member = memberRepository.findByUsername(username);
        if(member==null) throw new Exception ("????????? ???????????? ??????");
        String salt = member.getSalt().getSalt();
        password = saltUtil.encodePassword(salt,password);
        if(!member.getPassword().equals(password))
            throw new Exception ("??????????????? ????????????.");
        if(member.getSocial()!=null)
            throw new Exception ("?????? ???????????? ????????? ????????????.");
        return member;
    }

    @Override
    public Member findByUsername(String username) throws NotFoundException {
        Member member = memberRepository.findByUsername(username);
        if(member == null) throw new NotFoundException("????????? ???????????? ??????");
        return member;
    }

    @Override
    public void verifyEmail(String key) throws NotFoundException {
        String memberId = redisUtil.getData(key);
        Member member = memberRepository.findByUsername(memberId);
        if(member==null) throw new NotFoundException("????????? ??????????????????");
        modifyUserRole(member,UserRole.ROLE_USER);
        redisUtil.deleteData(key);
    }

    @Override
    public void sendVerificationMail(Member member) throws NotFoundException {
        String VERIFICATION_LINK = "http://localhost:8080/user/verify/";
        if(member==null) throw new NotFoundException("????????? ???????????? ??????");
        UUID uuid = UUID.randomUUID();
        redisUtil.setDataExpire(uuid.toString(),member.getUsername(), 60 * 30L);
        emailService.sendMail(member.getEmail(), "[Portfolio] ???????????? ?????????????????????.",VERIFICATION_LINK+uuid.toString());
    }

    @Override
    public void modifyUserRole(Member member, UserRole userRole){
            member.setRole(userRole);
            memberRepository.save(member);
    }

    @Override
    public boolean isPasswordUuidValidate(String key){
        String memberId = redisUtil.getData(key);
        return !memberId.equals("");
    }

    @Override
    public void changePassword(Member member,String password) throws NotFoundException{
        if(member == null) throw new NotFoundException("changePassword(),????????? ???????????? ??????");
        String salt = saltUtil.genSalt();
        member.setSalt(new Salt(salt));
        member.setPassword(saltUtil.encodePassword(salt,password));
        memberRepository.save(member);
    }


    @Override
    public void requestChangePassword(Member member) throws NotFoundException{
        String CHANGE_PASSWORD_LINK = "http://localhost:8080/user/password/";
        if(member == null) throw new NotFoundException("????????? ???????????? ??????.");
        String key = REDIS_CHANGE_PASSWORD_PREFIX+UUID.randomUUID();
        redisUtil.setDataExpire(key,member.getUsername(),60 * 30L);
        emailService.sendMail(member.getEmail(),"[Portfolio] ????????? ???????????? ?????? ??????",CHANGE_PASSWORD_LINK+key);
    }
}
