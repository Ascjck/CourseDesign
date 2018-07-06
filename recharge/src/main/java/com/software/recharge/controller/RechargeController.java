package com.software.recharge.controller;


import com.software.recharge.domain.Result;
import com.software.recharge.domain.UserInfo;
import com.software.recharge.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RechargeController {
    @Autowired
    private RechargeService rechargeService;
    @PostMapping("/recharge")
    public Result<UserInfo> recharge(HttpServletRequest request, @RequestParam("money") double money){
        String number = (String) request.getSession().getAttribute("validUser");

        if (number == null){
            return new Result<>(1,"not login", null);
        }else{
            return new Result<>(0,"ok", rechargeService.recharge(number,money));
        }
    }
}
