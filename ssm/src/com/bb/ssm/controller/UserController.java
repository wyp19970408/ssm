package com.bb.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bb.ssm.pojo.User;
import com.bb.ssm.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
		
	@RequestMapping("/login")
	public String login(String username,String password,Model model,HttpServletRequest request) {
		User user = userService.login(username, password);
		if(user!=null) {
			// 把user存入session中
			request.getSession().setAttribute("USER_SESSION", user);
			return "redirect:/user/list.do";
		}
		model.addAttribute("errorMsg", "用户名或者密码错误");
		return "forward:/login.jsp";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<User> users = userService.selectList();
		model.addAttribute("users", users);
		return "userList";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id) {
		userService.deleteByPrimaryKey(id);
		return "redirect:/user/list.do";
	}
}
