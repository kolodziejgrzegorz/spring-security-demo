package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.entity.UserLoginInfo;

@Repository
@Transactional
public class UserDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public UserLoginInfo getUserLoginInfo(String userName) {
		UserLoginInfo userLoginInfo = new UserLoginInfo();
		short enabled = 1;
		List<?> list = hibernateTemplate.find("FROM UserLoginInfo WHERE username=? and enabled=?", userName, enabled);
		
		if(!list.isEmpty()) {
			userLoginInfo = (UserLoginInfo)list.get(0);
		}
		return userLoginInfo;
	}

}
