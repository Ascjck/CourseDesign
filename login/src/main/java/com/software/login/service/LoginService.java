package com.software.login.service;


import com.software.login.domain.User;
import com.software.login.repository.UserJpaRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class LoginService {
    @Autowired
    private UserJpaRepository userJpaRepository;

    public boolean login(String number, String passwd){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwd.getBytes());
            passwd = Base64.encodeBase64String(md.digest());
        }catch (NoSuchAlgorithmException e){
            return false;
        }
        User user = userJpaRepository.findByNumber(number);
        if (user.getPasswd().equals(passwd))
            return true;
        else return false;
    }
}
