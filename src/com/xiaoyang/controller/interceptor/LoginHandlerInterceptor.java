package com.xiaoyang.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginHandlerInterceptor implements HandlerInterceptor {
	
	static Object dbSource;

	//进入 Handler方法之前执行
	//用于身份认证、身份授权
	//比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("LoginHandlerInterceptor...preHandle");
		
		//获取请求的url
		String url = request.getRequestURI();
		//判断url是否是公开 地址（实际使用时将公开 地址配置配置文件中）
		//这里公开地址是登陆提交的地址
		if(url.indexOf("login.action")>=0){
			return true;
		}
		
		HttpSession session =  request.getSession();
		String loginName = (String) session.getAttribute("userName");
		
		//如果session里面有userName则表示用户已经登录   放行
		if(loginName !=null && loginName !=""){
			if(loginName.equals("area1")){
				dbSource = "area1";
			}else if(loginName.equals("area2")){
				dbSource = "area2";
			}
			System.out.println("dbSource  Set OK *******************"+ dbSource);
			return true; 
		}

		//执行到这里如果还没有放行表示 该用户需要验证  执行这里表示用户身份需要认证，跳转登陆页面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		
		//return false表示拦截，不向下执行
		//return true表示放行
		return false;
	}
	

	
	//进入Handler方法之后，返回modelAndView之前执行
	//应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里传到视图，也可以在这里统一指定视图

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("LoginHandlerInterceptor...postHandle");
	}

	
	//执行Handler完成执行此方法
	//应用场景：统一异常处理，统一日志处理

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("LoginHandlerInterceptor...afterCompletion");
	}


	//动态改变数据源 需要把动态改变的值  用determineCurrentDataSource()  把真正需要的数据源返回回去。
	public static Object determineCurrentDataSource() {
		return getLookUpDateSource();
	}

	//获取到动态的数据源
	private static Object getLookUpDateSource() {
		return dbSource;
	}
}
