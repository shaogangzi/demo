package com.sg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.bean.User;
import com.sg.mapper.UserMapper;


@Service
public class SystemServiceImpl implements SystemService{
     
	@Autowired
	private UserMapper userMapper;
	
	
	
	
	public boolean register(User user) {
		System.out.println(user.toString());
		boolean registerFlag=false;
		try{
		registerFlag = userMapper.register(user);	
		} catch (Exception e) {
			return false;
		}
		
		
		return registerFlag;
	}

}
