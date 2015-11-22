/*package com.xiaoyang.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.xiaoyang.po.Items;

	org.springframework.web.servlet.mvc.Controller：页面控制器/处理器必须实现Controller接口，注意别选错了；
 * 	后边我们 会学习其他的处理器实现方式；
  	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) ：
	功能处理方法，实现相应的功能处理，比如收集参数、验证参数、绑定参数到命令对象、将命令对象传入业务对象进行业务处理、最后返回ModelAndView对象；
	ModelAndView：包含了视图要实现的模型数据和逻辑视图名；“mv.addObject("message", "Hello World!");
	表示添加模型数据，此处可以是任意POJO对象；
	
	“mv.setViewName("hello");”表示设置逻辑视图名为“hello”，视图解析器会将其解析为具体的视图，
	如前边的视图解析器InternalResourceVi。wResolver会将其解析为“WEB-INF/jsp/hello.jsp”。


public class IndexController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		//1、收集参数、验证参数  
		//2、绑定参数到命令对象  
		//3、将命令对象传入业务对象进行业务处理  
		//4、选择下一个页面 
		ModelAndView mv = new ModelAndView();
		ArrayList<Items>  itemsList = new ArrayList<Items>();
		
		Items item1 = new Items();
		item1.setName("纸皮核桃(新鲜)");	
		item1.setPrice("13");
		item1.setCreatetime(new Date());
		item1.setDetail("2015年新下树的纸皮大核桃，全手工脱皮");
		
		itemsList.add(item1);
		
		Items item2 = new Items();
		item2.setName("纸皮核桃(干)");	
		item2.setPrice("20");
		item2.setCreatetime(new Date());
		item2.setDetail("2015年新下树的纸皮大核桃，全手工脱皮,晾晒20天以上");
		
		itemsList.add(item2);
		
		 //添加模型数据 可以是任意的POJO对象  
	     mv.addObject("itemsList", itemsList);  
	     //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面  
	     mv.setViewName("index");  
		return mv;
	}

	public ModelAndView queryItems() throws Exception {
		ModelAndView mv = new ModelAndView();
		
		ArrayList<Items>  itemsList = new ArrayList<Items>();
		
		Items item1 = new Items();
		item1.setName("纸皮核桃(新鲜)");	
		item1.setPrice("13");
		item1.setCreatetime(new Date());
		item1.setDetail("2015年新下树的纸皮大核桃，全手工脱皮");
		
		itemsList.add(item1);
		
		Items item2 = new Items();
		item2.setName("纸皮核桃(干)");	
		item2.setPrice("20");
		item2.setCreatetime(new Date());
		item2.setDetail("2015年新下树的纸皮大核桃，全手工脱皮,晾晒20天以上");
		
		itemsList.add(item2);
		
		 //添加模型数据 可以是任意的POJO对象  
	     mv.addObject("itemsList", itemsList);  
	     //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面  
	     mv.setViewName("index");  
		return mv;
	}



}
*/