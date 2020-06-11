package com.app.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/**").hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin()
                .loginPage("/my_login_page")
                .defaultSuccessUrl("/home", true)
                .failureUrl("/my_login_page?error=true")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/my_logout_page")
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}admin").roles("ADMIN")
                .and()
                .withUser("user").password("{noop}user").roles("USER");
    }

}