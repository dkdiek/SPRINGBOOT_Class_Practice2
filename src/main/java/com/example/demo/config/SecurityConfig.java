package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorizeRequest) -> authorizeRequest
                        .requestMatchers("/auth/**").permitAll().anyRequest().authenticated()) // url이 auth로 시작하면 허용 그외
                                                                                               // 다른 요청은 인증을 받아야되
                .authenticationProvider(authenticationProvider) // 그 인증 방식으로는 authenticationProvider를 이용
                .httpBasic(); // httpBasic쓰면 로그인창이 팝업 형태로 출력된다

        return http.build();
    }

}
