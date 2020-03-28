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
			// 鎶妘ser瀛樺叆session涓�
			request.getSession().setAttribute("USER_SESSION", user);
			return "redirect:/user/list.do";
		}
		model.addAttribute("errorMsg", "鐢ㄦ埛鍚嶆垨鑰呭瘑鐮侀敊璇�");
		return "forward:/login.jsp";
	}
	
	
	@RequestMapping("/insert")
	public String insert() {
		return "redirect:/user/list.do";
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
