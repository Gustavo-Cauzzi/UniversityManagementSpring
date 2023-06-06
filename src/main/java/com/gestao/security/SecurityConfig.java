package com.gestao.security;

import com.gestao.security.jwt.JWTFilter;
import com.gestao.security.jwt.JwtAuthenticationEntryPoint;
import com.gestao.security.jwt.JwtUserDetailsService;
import com.gestao.security.jwt.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final TokenProvider tokenProvider;
    private final JwtUserDetailsService jwtUserDetailsService;
    private final JWTFilter jwtFilter;


    public SecurityConfig(TokenProvider tokenProvider, JwtUserDetailsService jwtUserDetailsService, JWTFilter jwtFilter) {
        this.tokenProvider = tokenProvider;
        this.jwtUserDetailsService = jwtUserDetailsService;
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
//                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.NEVER)
            .and()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/**").permitAll()
                .requestMatchers("/actuator/health").permitAll()
                .requestMatchers("/api/v1/**").authenticated()
            .and()
                .exceptionHandling().authenticationEntryPoint(new JwtAuthenticationEntryPoint())
            .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .httpBasic();
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}