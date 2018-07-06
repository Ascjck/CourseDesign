package com.software.query.controller;


import com.software.query.domain.Result;
import com.software.query.domain.UserInfo;
import com.software.query.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class QueryController {
    @Autowired
    private QueryService queryService;

    @GetMapping("/query")
    public Result<UserInfo> query(HttpServletRequest request){
        String number = (String) request.getSession().getAttribute("validUser");
        if (number ==null) {
            return new Result<>(1, "not login", null);
        }else {
            return new Result<>(0, "ok", queryService.query(number));
        }
    }
}
