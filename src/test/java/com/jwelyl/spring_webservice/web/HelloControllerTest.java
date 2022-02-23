package com.jwelyl.spring_webservice.web;

import com.jwelyl.spring_webservice.config.auth.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)  //  Springboot와 JUnit 사이를 연결
@WebMvcTest(controllers = HelloController.class,    //  Web(Spring MVC)에 집중, @Controller 사옹 가능
        excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        })
public class HelloControllerTest {
    @Autowired  //  Spring이 관리하는 Bean 주입받음
    private MockMvc mvc;    //  web API test에 사용. HTTP GET, POST 등의 API test

    @WithMockUser(roles = "USER")
    @Test
    public void hello_returned() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))              //  MockMvc로 /hello로 HTTP GET 요청
                .andExpect(status().isOk())                //  mvc.perform 결과를 검증(HTTP header status 검증)
                .andExpect(content().string(hello));       //  mvc.perform 결과를 검증(본문 내용 검증, Controller가 "hello"를 리턴)
    }

    @WithMockUser(roles = "USER")
    @Test
    public void helloDto_returned() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
