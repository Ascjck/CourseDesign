package com.software.ribbon.controller;

import com.software.ribbon.domain.Result;
import com.software.ribbon.domain.User;
import com.software.ribbon.domain.UserInfo;
import com.software.ribbon.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RibbonController {
    @Autowired
    RibbonService ribbonService;

    @PostMapping("/register")
    public Result<User> register(HttpServletRequest request){
        return ribbonService.registerService(request);
    }

    @PostMapping("/login")
    public Result<Boolean> login(HttpServletRequest request){
        return ribbonService.loginService(request);
    }

    @GetMapping("/query")
    public Result<UserInfo> query(HttpServletRequest request){
        return ribbonService.queryService();
    }

    @PostMapping("/recharge")
    public Result<UserInfo> recharge(HttpServletRequest request){
        return ribbonService.rechargeService(request);
    }

    @PostMapping("/pack")
    public Result<UserInfo> pack(HttpServletRequest request){
        return ribbonService.packService(request);
    }

    @GetMapping("/logout")
    public Result<Boolean> logout(HttpServletRequest request){
        return ribbonService.logoutService();
    }
}
