package com.software.pack.controller;


import com.software.pack.domain.Result;
import com.software.pack.domain.UserInfo;
import com.software.pack.service.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PackController {
    @Autowired
    private PackService packService;
    @PostMapping("/pack")
    public Result<UserInfo> pack(HttpServletRequest request, @RequestParam("pack") String pack){
        String number = (String) request.getSession().getAttribute("validUser");

        if (number == null){
            return new Result<>(1,"not login", null);
        }else{
            return new Result<>(0,"ok", packService.pack(number,pack));
        }
    }
}
