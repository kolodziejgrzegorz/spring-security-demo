package com.luv2code.springsecurity.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.luv2code.springsecurity.demo.services.MyUserDetailService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailService myUserDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	      http.authorizeRequests()
	        .antMatchers("/", "/home","/login").permitAll()
	        .antMatchers("/user/*").hasAnyRole("ADMIN","USER")
	        .antMatchers("/admin/*").hasRole("ADMIN")
	        .anyRequest().authenticated()
	        .and().formLogin().loginPage("/login")
	        .loginProcessingUrl("/appLogin")
	        .usernameParameter("username")
	        .passwordParameter("password")
	        .successForwardUrl("/user/userTest")
	        .and().logout()    
			.logoutUrl("/appLogout") 
			.logoutSuccessUrl("/home")
	        .and().exceptionHandling() 
			.accessDeniedPage("/user/error")
			.and().csrf().disable();
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	      .ignoring()
	         .antMatchers("/resources/**"); 
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}
}
