package com.xiaoyang.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	//用户登录Action
	@RequestMapping("/login")
	public String login(HttpSession session, String userName,String password) throws Exception {

		// 在session中保存用户身份信息
		session.setAttribute("userName", userName);
		// 重定向到商品列表页面
		return "redirect:/items/queryItems.action";
	}
	
	//用户退出Action
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		// 在session 失效
		session.invalidate();
		// 重定向到商品列表页面
		return "redirect:/items/queryItems.action";
	}

}
