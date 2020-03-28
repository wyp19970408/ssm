package com.bb.ssm.service;

import java.util.List;

import com.bb.ssm.pojo.User;

public interface UserService {

	public int insert(User user);

	public int deleteByPrimaryKey(Integer id);

	public int updateByPrimaryKey(User user);

	public User selectByPrimaryKey(Integer id);

	public List<User> selectList();
	
	public User login(String name,String password);
}
