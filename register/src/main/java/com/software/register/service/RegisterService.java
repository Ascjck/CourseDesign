package com.software.register.service;

import com.software.register.domain.User;
import com.software.register.domain.UserInfo;
import com.software.register.repository.UserInfoJpaRepository;
import com.software.register.repository.UserJpaRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class RegisterService {
    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private UserInfoJpaRepository userInfoJpaRepository;

    public List<User> findAll(){
        return userJpaRepository.findAll();
    }

    public User register(String number,String username,String passwd){
        User user = new User();
        user.setNumber(number);
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwd.getBytes());
            passwd = Base64.encodeBase64String(md.digest());
        }catch (NoSuchAlgorithmException e){
            return null;
        }
        user.setPasswd(passwd);
        user.setUsername(username);
        if (userJpaRepository.findByNumber(number) != null)
            return null;
        User res =  userJpaRepository.save(user);
        UserInfo info = new UserInfo();
        info.setBalance(0.0);
        info.setPack("A");
        info.setUser(res);
        userInfoJpaRepository.save(info);
        return res;
    }

}
