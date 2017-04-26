package com.test.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ssm.domain.User;
import com.test.ssm.mapper.UserMapper;



@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUserById(int id) {

		User user = userMapper.selectByPrimaryKey(id);
		return user;
		
	}

}
