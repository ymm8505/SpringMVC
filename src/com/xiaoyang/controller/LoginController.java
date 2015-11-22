package com.xiaoyang.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	//�û���¼Action
	@RequestMapping("/login")
	public String login(HttpSession session, String userName,String password) throws Exception {

		// ��session�б����û������Ϣ
		session.setAttribute("userName", userName);
		// �ض�����Ʒ�б�ҳ��
		return "redirect:/items/queryItems.action";
	}
	
	//�û��˳�Action
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		// ��session ʧЧ
		session.invalidate();
		// �ض�����Ʒ�б�ҳ��
		return "redirect:/items/queryItems.action";
	}

}
