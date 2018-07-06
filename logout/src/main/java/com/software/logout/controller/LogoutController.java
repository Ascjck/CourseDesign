package com.software.logout.controller;

import com.software.logout.domain.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LogoutController {

    @GetMapping("/logout")
    public Result<Boolean> logout(HttpServletRequest request){
        if (request.getSession().getAttribute("validUser") == null)
            return new Result<>(1,"not login", false);
        else {
            request.getSession().removeAttribute("validUser");
            return new Result<>(0,"ok", true);
        }
    }
}
