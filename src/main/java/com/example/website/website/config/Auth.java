package com.example.website.website.config;

import com.example.website.website.service.CustomerUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Auth {

    @Autowired
    private CustomerUserDetailService customerUserDetailService;

    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider =
                new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customerUserDetailService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authProvider;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain
            (HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/bankprovider")
                .hasAnyAuthority("admin");
        httpSecurity.authorizeRequests().antMatchers("/transfer")
                .hasAnyAuthority("operator");
        httpSecurity.authorizeRequests().antMatchers("/tambahrekening")
                .hasAnyAuthority("customerservice");
        httpSecurity.csrf().disable();
        httpSecurity.authorizeRequests().antMatchers("/api")
                .authenticated().and().httpBasic();
        httpSecurity.authorizeRequests().and().formLogin();
        return httpSecurity.build();
    }

}
