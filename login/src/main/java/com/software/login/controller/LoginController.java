package com.software.login.controller;

import com.software.login.domain.User;
import com.software.login.domain.Result;
import com.software.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Result<Boolean> login(HttpServletRequest request, @Validated User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new Result<>(1,bindingResult.getFieldError().getDefaultMessage(),null);
        }

        if (loginService.login(user.getNumber(),user.getPasswd())) {
            request.getSession().setAttribute("validUser",user.getNumber());
            System.out.println(request.getSession().getAttribute("validUser"));
            return new Result<>(0, "ok", true);
        }
        else
            return new Result<>(0,"fail",false);
    }
}
