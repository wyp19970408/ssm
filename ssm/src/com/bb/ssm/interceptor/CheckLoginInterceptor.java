package com.bb.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bb.ssm.pojo.User;

public class CheckLoginInterceptor implements HandlerInterceptor {

	/**
	 * 在控制器执行前执行拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取登录信息
		User user = (User) request.getSession().getAttribute("USER_SESSION");
		if (user != null) {
			return true;
		}
		// 如果没有登录跳转到登录页面
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		return false;
	}

	/**
	 * 在控制器执行之后执行 
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		User user  = (User) request.getSession().getAttribute("USER_SESSION");
		System.out.println(user);
		System.out.println(handler);
		System.out.println(modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
