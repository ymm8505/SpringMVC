/*package com.xiaoyang.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.xiaoyang.po.Items;

	org.springframework.web.servlet.mvc.Controller��ҳ�������/����������ʵ��Controller�ӿڣ�ע���ѡ���ˣ�
 * 	������� ��ѧϰ�����Ĵ�����ʵ�ַ�ʽ��
  	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) ��
	���ܴ�������ʵ����Ӧ�Ĺ��ܴ��������ռ���������֤�������󶨲�����������󡢽����������ҵ��������ҵ������󷵻�ModelAndView����
	ModelAndView����������ͼҪʵ�ֵ�ģ�����ݺ��߼���ͼ������mv.addObject("message", "Hello World!");
	��ʾ���ģ�����ݣ��˴�����������POJO����
	
	��mv.setViewName("hello");����ʾ�����߼���ͼ��Ϊ��hello������ͼ�������Ὣ�����Ϊ�������ͼ��
	��ǰ�ߵ���ͼ������InternalResourceVi��wResolver�Ὣ�����Ϊ��WEB-INF/jsp/hello.jsp����


public class IndexController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		//1���ռ���������֤����  
		//2���󶨲������������  
		//3�������������ҵ��������ҵ����  
		//4��ѡ����һ��ҳ�� 
		ModelAndView mv = new ModelAndView();
		ArrayList<Items>  itemsList = new ArrayList<Items>();
		
		Items item1 = new Items();
		item1.setName("ֽƤ����(����)");	
		item1.setPrice("13");
		item1.setCreatetime(new Date());
		item1.setDetail("2015����������ֽƤ����ң�ȫ�ֹ���Ƥ");
		
		itemsList.add(item1);
		
		Items item2 = new Items();
		item2.setName("ֽƤ����(��)");	
		item2.setPrice("20");
		item2.setCreatetime(new Date());
		item2.setDetail("2015����������ֽƤ����ң�ȫ�ֹ���Ƥ,��ɹ20������");
		
		itemsList.add(item2);
		
		 //���ģ������ �����������POJO����  
	     mv.addObject("itemsList", itemsList);  
	     //�����߼���ͼ������ͼ����������ݸ����ֽ������������ͼҳ��  
	     mv.setViewName("index");  
		return mv;
	}

	public ModelAndView queryItems() throws Exception {
		ModelAndView mv = new ModelAndView();
		
		ArrayList<Items>  itemsList = new ArrayList<Items>();
		
		Items item1 = new Items();
		item1.setName("ֽƤ����(����)");	
		item1.setPrice("13");
		item1.setCreatetime(new Date());
		item1.setDetail("2015����������ֽƤ����ң�ȫ�ֹ���Ƥ");
		
		itemsList.add(item1);
		
		Items item2 = new Items();
		item2.setName("ֽƤ����(��)");	
		item2.setPrice("20");
		item2.setCreatetime(new Date());
		item2.setDetail("2015����������ֽƤ����ң�ȫ�ֹ���Ƥ,��ɹ20������");
		
		itemsList.add(item2);
		
		 //���ģ������ �����������POJO����  
	     mv.addObject("itemsList", itemsList);  
	     //�����߼���ͼ������ͼ����������ݸ����ֽ������������ͼҳ��  
	     mv.setViewName("index");  
		return mv;
	}



}
*/