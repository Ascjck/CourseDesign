package com.software.query.service;


import com.software.query.domain.User;
import com.software.query.domain.UserInfo;
import com.software.query.repository.UserInfoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryService {
    @Autowired
    private UserInfoJpaRepository userInfoJpaRepository;

    public UserInfo query(String number){
        return userInfoJpaRepository.findByUser_Number(number);
    }

}
