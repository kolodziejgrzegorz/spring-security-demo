package com.luv2code.springsecurity.demo.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.luv2code.springsecurity.demo.dao.UserDAO;
import com.luv2code.springsecurity.demo.entity.UserLoginInfo;

@Service
public class MyUserDetailService implements UserDetailsService  {

	@Autowired
	private UserDAO userDAO;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		UserLoginInfo userLoginInfo = userDAO.getUserLoginInfo(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority(userLoginInfo.getRole());
		UserDetails userDetails = (UserDetails)new User(userLoginInfo.getUserName(),
														 userLoginInfo.getPassword(),Arrays.asList(authority));
		return userDetails;
	}

}
