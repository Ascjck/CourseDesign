package com.software.recharge.service;


import com.software.recharge.domain.UserInfo;
import com.software.recharge.repository.UserInfoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RechargeService {
    @Autowired
    private UserInfoJpaRepository userInfoJpaRepository;

    public UserInfo recharge(String number, double money){
        UserInfo info = userInfoJpaRepository.findByUser_Number(number);

        info.setBalance(info.getBalance()+money);

        return userInfoJpaRepository.save(info);
    }
}
