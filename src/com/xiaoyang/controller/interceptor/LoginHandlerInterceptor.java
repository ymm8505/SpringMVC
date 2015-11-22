package com.xiaoyang.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginHandlerInterceptor implements HandlerInterceptor {
	
	static Object dbSource;

	//���� Handler����֮ǰִ��
	//���������֤�������Ȩ
	//���������֤�������֤ͨ����ʾ��ǰ�û�û�е�½����Ҫ�˷������ز�������ִ��
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("LoginHandlerInterceptor...preHandle");
		
		//��ȡ�����url
		String url = request.getRequestURI();
		//�ж�url�Ƿ��ǹ��� ��ַ��ʵ��ʹ��ʱ������ ��ַ���������ļ��У�
		//���﹫����ַ�ǵ�½�ύ�ĵ�ַ
		if(url.indexOf("login.action")>=0){
			return true;
		}
		
		HttpSession session =  request.getSession();
		String loginName = (String) session.getAttribute("userName");
		
		//���session������userName���ʾ�û��Ѿ���¼   ����
		if(loginName !=null && loginName !=""){
			if(loginName.equals("area1")){
				dbSource = "area1";
			}else if(loginName.equals("area2")){
				dbSource = "area2";
			}
			System.out.println("dbSource  Set OK *******************"+ dbSource);
			return true; 
		}

		//ִ�е����������û�з��б�ʾ ���û���Ҫ��֤  ִ�������ʾ�û������Ҫ��֤����ת��½ҳ��
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		
		//return false��ʾ���أ�������ִ��
		//return true��ʾ����
		return false;
	}
	

	
	//����Handler����֮�󣬷���modelAndView֮ǰִ��
	//Ӧ�ó�����modelAndView�����������õ�ģ������(����˵�����)�����ﴫ����ͼ��Ҳ����������ͳһָ����ͼ

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("LoginHandlerInterceptor...postHandle");
	}

	
	//ִ��Handler���ִ�д˷���
	//Ӧ�ó�����ͳһ�쳣����ͳһ��־����

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("LoginHandlerInterceptor...afterCompletion");
	}


	//��̬�ı�����Դ ��Ҫ�Ѷ�̬�ı��ֵ  ��determineCurrentDataSource()  ��������Ҫ������Դ���ػ�ȥ��
	public static Object determineCurrentDataSource() {
		return getLookUpDateSource();
	}

	//��ȡ����̬������Դ
	private static Object getLookUpDateSource() {
		return dbSource;
	}
}
