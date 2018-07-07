package com.software.ribbon.service;

import com.software.ribbon.domain.Result;
import com.software.ribbon.domain.User;
import com.software.ribbon.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.ParameterizedType;
import java.util.Enumeration;
import java.util.Map;

@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;

    public Result<User> registerService(HttpServletRequest request){
        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            headers.add(key, value);
        }
        MultiValueMap<String,Object> params = new LinkedMultiValueMap<>();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()){
            String key = paramNames.nextElement();
            String value = request.getParameter(key);
            params.add(key,value);
        }
        HttpEntity<MultiValueMap<String , Object>> requestEntity = new HttpEntity<>(params, headers);
        return restTemplate.exchange("http://REGISTERSERVICE/register", HttpMethod.POST, requestEntity, new ParameterizedTypeReference<Result<User>>() {
        }).getBody();
    }

    public ResponseEntity loginService(HttpServletRequest request){
        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            headers.add(key, value);
        }

        MultiValueMap<String,Object> params = new LinkedMultiValueMap<>();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()){
            String key = paramNames.nextElement();
            String value = request.getParameter(key);
            params.add(key,value);
        }
        HttpEntity<MultiValueMap<String , Object>> requestEntity = new HttpEntity<>(params, headers);
        return restTemplate.exchange("http://LOGINSERVICE/login", HttpMethod.POST, requestEntity, new ParameterizedTypeReference<Result<Boolean>>() {
        });
    }

    public Result<UserInfo> queryService(HttpServletRequest request){
        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            headers.add(key, value);
        }
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
        return restTemplate.exchange("http://QUERYSERVICE/query", HttpMethod.GET, requestEntity, new ParameterizedTypeReference<Result<UserInfo>>() {
        }).getBody();
    }

    public Result<UserInfo> rechargeService(HttpServletRequest request){
        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            headers.add(key, value);
        }
        MultiValueMap<String,Object> params = new LinkedMultiValueMap<>();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()){
            String key = paramNames.nextElement();
            String value = request.getParameter(key);
            params.add(key,value);
        }
        HttpEntity<MultiValueMap<String , Object>> requestEntity = new HttpEntity<>(params, headers);
        return restTemplate.exchange("http://RECHARGESERVICE/recharge", HttpMethod.POST, requestEntity, new ParameterizedTypeReference<Result<UserInfo>>() {
        }).getBody();
    }

    public Result<UserInfo> packService(HttpServletRequest request){

        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            headers.add(key, value);
        }
        MultiValueMap<String,Object> params = new LinkedMultiValueMap<>();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()){
            String key = paramNames.nextElement();
            String value = request.getParameter(key);
            params.add(key,value);
        }
        HttpEntity<MultiValueMap<String , Object>> requestEntity = new HttpEntity<>(params, headers);
        return restTemplate.exchange("http://PACKSERVICE/pack", HttpMethod.POST, requestEntity, new ParameterizedTypeReference<Result<UserInfo>>() {
        }).getBody();
    }

    public Result<Boolean> logoutService(HttpServletRequest request){
        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            headers.add(key, value);
        }
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
        return restTemplate.exchange("http://LOGOUTSERVICE/logout", HttpMethod.GET, requestEntity, new ParameterizedTypeReference<Result<Boolean>>() {
        }).getBody();
    }
}
