package com.software.ribbon.service;

import com.software.ribbon.domain.Result;
import com.software.ribbon.domain.User;
import com.software.ribbon.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;

    public Result<User> registerService(HttpServletRequest request){
        return restTemplate.postForObject("http://REGISTERSERVICE/register", request, Result.class);
    }

    public Result<Boolean> loginService(HttpServletRequest request){
        return restTemplate.postForObject("http://LOGINSERVICE/login",request,Result.class);
    }

    public Result<UserInfo> queryService(){
        
        return restTemplate.getForObject("http://QUERYSERVICE/query",Result.class);
    }

    public Result<UserInfo> rechargeService(HttpServletRequest request){
        return restTemplate.postForObject("http://RECHARGESERVICE/recharge", request, Result.class);
    }

    public Result<UserInfo> packService(HttpServletRequest request){
        return restTemplate.postForObject("http://PACKSERVICE/pack",request,Result.class);
    }

    public Result<Boolean> logoutService(){
        System.out.println("logout");
        return restTemplate.getForObject("http://LOGOUTSERVICE/logout", Result.class);
    }
}
