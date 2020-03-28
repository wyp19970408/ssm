package com.bb.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bb.ssm.pojo.User;

public interface UserMapper {
	
	@Insert("insert into user(name,password,age) values(#{name},#{password},#{age})")
	int insert(User user);
	
	@Delete("delete from user where id = #{id}")
	int deleteByPrimaryKey(Integer id);
	
	@Update("update user set name = #{name},password = #{password},age = #{age} where id = #{id}")
	int updateByPrimaryKey(User user);
	
	@Select("select * from user where id = #{id}")
	User selectByPrimaryKey(Integer id);
	
	@Select("select * from user")
	List<User> selectList();
	
	@Select("select * from user where name = #{name} and password = #{password}")
	User login(@Param("name")String username,@Param("password")String password);
}
