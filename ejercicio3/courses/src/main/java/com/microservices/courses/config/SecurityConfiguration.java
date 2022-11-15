package com.microservices.courses.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        auth
            .inMemoryAuthentication()
                .passwordEncoder(encoder)
                .withUser("user1")
                    .password(encoder.encode("user1"))
                    .roles("GUEST")
                    .and()
                .withUser("user2")
                    .password(encoder.encode("user2"))
                    .roles("OPERATOR")
                    .and()
                .withUser("user3")
                    .password(encoder.encode("user3"))
                    .roles("ADMIN")
                    .and()
                .withUser("user4")
                    .password(encoder.encode("user4"))
                    .roles("OPERATOR", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/course").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/course").hasAnyRole("ADMIN", "OPERATOR")
                .antMatchers(HttpMethod.PUT, "/course").hasAnyRole("ADMIN", "OPERATOR")
                .antMatchers(HttpMethod.GET).authenticated()
                .and()
                .httpBasic();
    }
}
