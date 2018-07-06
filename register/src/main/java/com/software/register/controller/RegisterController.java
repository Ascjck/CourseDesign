package com.software.register.controller;

import com.software.register.domain.Result;
import com.software.register.domain.User;
import com.software.register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public Result<User> register(@Validated User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new Result<>(1, bindingResult.getFieldError().getDefaultMessage(), null);
        }

        user = registerService.register(user.getNumber(),user.getUsername(),user.getPasswd());

        if (user == null)
            return new Result<>(1,"fail",user);
        else
            return new Result<>(0,"success",user);
    }

    @GetMapping("/getAll")
    public List<User> get(){
        return registerService.findAll();
    }
}
