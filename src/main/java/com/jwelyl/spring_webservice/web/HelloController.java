package com.jwelyl.spring_webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //  JSON 반환 Controller
public class HelloController {
    @GetMapping("/hello")   //  HTTP Method인 Get 요청을 받는 API 생성
    public String hello() {
        return "hello";
    }
}