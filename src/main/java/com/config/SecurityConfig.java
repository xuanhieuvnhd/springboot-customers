package com.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("htc").password("{noop}htc").roles(Roles.USER)
                .and().withUser("adm").password("{noop}adm").roles(Roles.STAFF);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/customers/{id}/**").hasRole(Roles.STAFF)
                .and().authorizeRequests().antMatchers("/customers/**").authenticated()
                .and().authorizeRequests().antMatchers("/**").permitAll()
                .and().formLogin()
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    private interface Roles {
        String USER = "1";
        String STAFF = "2";
    }
}
