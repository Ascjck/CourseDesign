package com.software.pack.service;

import com.software.pack.domain.UserInfo;
import com.software.pack.repository.UserInfoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackService {
    @Autowired
    private UserInfoJpaRepository userInfoJpaRepository;

    public UserInfo pack(String number,String pack){
        UserInfo info = userInfoJpaRepository.findByUser_Number(number);
        info.setPack(pack);

        return userInfoJpaRepository.save(info);
    }
}
