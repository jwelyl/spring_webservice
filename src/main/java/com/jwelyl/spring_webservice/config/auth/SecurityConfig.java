package com.jwelyl.spring_webservice.config.auth;

import com.jwelyl.spring_webservice.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity  //  Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable().headers().frameOptions().disable()    //  h2-console 화면 사용
                .and()
                .authorizeRequests()    //  URL별 권한 관리 설정 옵션 시작, antMatchers 옵션 사용
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()  //  전체 열람 권한
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())    //  USER 권한을 가진 사람만 가능
                .anyRequest().authenticated()   //  나머지 URL은 인증된, 로그인된 사용자만 가능
                .and()
                .logout()
                .logoutSuccessUrl("/")  //  로그아웃 성공시 / 주소로 이동
                .and()
                .oauth2Login()      //  OAuth2 로그인 기능 설정 진입
                .userInfoEndpoint()     //  로그인 성공 이후 사용자 정보 가져올 때 설정 담당
                .userService(customOAuth2UserService);  //  로그인 성공 시 후속 조치 진행할 UserService 인터페이스 구현체 등록
    }
}
