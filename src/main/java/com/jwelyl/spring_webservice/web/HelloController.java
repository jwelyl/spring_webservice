package com.jwelyl.spring_webservice.web;

import com.jwelyl.spring_webservice.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //  JSON 반환 Controller
public class HelloController {
    @GetMapping("/hello")   //  HTTP Method인 Get 요청을 받는 API 생성
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,     //  외부에서 API로 넘긴 parameter를 가져옴
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}