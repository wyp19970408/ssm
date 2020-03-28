package com.bb.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bb.ssm.mapper.UserMapper;
import com.bb.ssm.pojo.User;
import com.bb.ssm.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int insert(User user) {
		return userMapper.insert(user);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(User user) {
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public User selectByPrimaryKey(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> selectList() {
		return userMapper.selectList();
	}

	@Override
	public User login(String name, String password) {
		return userMapper.login(name, password);
	}

}
