package com.xiaoyang.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoyang.controller.validation.ValidationGroup1;
import com.xiaoyang.po.ItemsCustom;
import com.xiaoyang.po.ItemsQueryVo;
import com.xiaoyang.service.ItemsService;

@RequestMapping("/items")
@Controller
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;

	
	//��Ʒ��ѯ
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(ItemsQueryVo itemsQueryVo) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<ItemsCustom>  itemsList = itemsService.findeItemList(itemsQueryVo);
		 //���ģ������ �����������POJO����  
	     mv.addObject("itemsList", itemsList);  
	     //�����߼���ͼ������ͼ����������ݸ����ֽ������������ͼҳ��  
	     mv.setViewName("items/itemList");   
		return mv;
	}
	
	// ������Ʒ��Ϣ�޸�ҳ�� ��ѯ
	// ����http���󷽷�������post��get
	@RequestMapping(value = "/editItems", method = { RequestMethod.POST,RequestMethod.GET })
	public ModelAndView editItems(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// ����service������Ʒid��ѯ��Ʒ��Ϣ
		ItemsCustom itemsCustoms =  itemsService.findItemsById(id);
		// ����ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// ����Ʒ��Ϣ�ŵ�model
		modelAndView.addObject("items", itemsCustoms);
		// ��Ʒ�޸�ҳ��
		modelAndView.setViewName("items/editItems");
		return modelAndView;
	}
	
	// ������Ʒ��Ϣ�޸�ҳ��  �ύ
	//@ModelAttribute("items")  ָ�����Ե�ҳ��� ������	
	@RequestMapping("/editItemsSubmit")
	public String  editItemsSubmit(Model model, HttpServletRequest request,Integer id,
			@ModelAttribute("items") @Validated(value={ValidationGroup1.class}) ItemsCustom  itemsCustom ,BindingResult bindingResult,
			MultipartFile items_pic
			) throws Exception {
		
		//���У���д��� 
		if(bindingResult.hasErrors()){
			//��ȡ�����еĴ�����ʾ
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			//����Model��ش���ҳ��
			model.addAttribute("allErrors", allErrors);
			return "items/editItems";
		}
		
//		�õ�ҳ���ϴ�����ԭʼͼƬ�ļ���   ����          QQͼƬ20150930142618.jpg 
		String items_name =items_pic.getOriginalFilename() ;
		
		//ת��ΪMultipartHttpRequest(�ص������)  
        MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;  
        //  ��õ�1��ͼƬ������ǰ̨��name���Ƶõ��ϴ����ļ���   
        MultipartFile imgFile1  =  multipartRequest.getFile("items_pic"); 
        String  imgFile2 = request.getParameter("items_pic");
		
//		���ͼƬ������  ͼƬ���Ƴ��� > 0
		if(items_pic!=null && items_pic.getOriginalFilename()!=null && items_pic.getOriginalFilename().length()>0){
			String ok_items_name = items_name.substring(items_name.lastIndexOf("."));
			String pic_path = "D:\\pic_upload\\temp\\";
			String NewFileNmae = UUID.randomUUID()+ ok_items_name;
			File file = new File(pic_path+NewFileNmae);
			items_pic.transferTo(file);
			itemsCustom.setPic(NewFileNmae);
		}
		
		// id = Integer.parseInt(request.getParameter("items.id"));
		// ����service������Ʒ��Ϣ
		// ����ModelAndView
		// ModelAndView modelAndView = new ModelAndView();
		itemsService.updatItemsById(id, itemsCustom);
		// ��Ʒ�޸�ҳ��
		// modelAndView.setViewName("success");
		// return "redirect:queryItems.action"
		String returnStr = "items/editItems.action?id="+id;
		return returnStr;
	}
		
	// ����ɾ����Ʒ
	@RequestMapping("/BatDeleteItems")
	public ModelAndView  BatDeleteItems(Integer[] items_id) throws Exception {
		// ����serviceɾ����ѡ�����Ʒ��Ϣ
		//			..........
		// ����ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// ��Ʒ�޸�ҳ��
		modelAndView.setViewName("success");
		return modelAndView;
	}
		
		
	//������Ʒ�޸Ĳ�ѯ
	@RequestMapping("/editQueryItems")
		public ModelAndView editQueryItems(ItemsQueryVo itemsQueryVo) throws Exception {
			ModelAndView mv = new ModelAndView();
			List<ItemsCustom>  itemsList = itemsService.findeItemList(itemsQueryVo);
			 //���ģ������ �����������POJO����  
		     mv.addObject("itemsList", itemsList);  
		     //�����߼���ͼ������ͼ����������ݸ����ֽ������������ͼҳ��  
		     mv.setViewName("items/editQueryItems");   
			return mv;
	}
	
	//������Ʒ�޸��ύ 
	@RequestMapping("/editQueryItemsSubmit")
		public ModelAndView editQueryItemsSubmit(ItemsQueryVo itemsQueryVo) throws Exception {
			ModelAndView mv = new ModelAndView();
//			List<ItemsCustom>  itemsList = itemsService.findeItemList(itemsQueryVo);
			 //���ģ������ �����������POJO����  
//		     mv.addObject("itemsList", itemsList);  
		     //�����߼���ͼ������ͼ����������ݸ����ֽ������������ͼҳ��  
		     mv.setViewName("success");   
			return mv;
	}

	
	
	
	//������Ʒ�޸Ĳ�ѯ
	/**
	 * @param itemsQueryVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editMapItems")
		public ModelAndView editMapQueryItems(ItemsQueryVo itemsQueryVo ,HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// ����service������Ʒid��ѯ��Ʒ��Ϣ
		ItemsCustom itemsCustoms =  itemsService.findItemsById(id);
		// ����ModelAndView
		ModelAndView mv = new ModelAndView();
		// ����Ʒ��Ϣ�ŵ�model
		mv.addObject("items", itemsCustoms);
		// ��Ʒ�޸�ҳ��
		mv.setViewName("items/editMapItems");
		return mv;
	}
	
	//������Ʒ�޸��ύ 
	@RequestMapping("/editMapItemsSubmit")
		public ModelAndView editMapQueryItemsSubmit(ItemsQueryVo itemsQueryVo) throws Exception {
			ModelAndView mv = new ModelAndView();
//				List<ItemsCustom>  itemsList = itemsService.findeItemList(itemsQueryVo);
			 //���ģ������ �����������POJO����  
//			     mv.addObject("itemsList", itemsList);  
		     //�����߼���ͼ������ͼ����������ݸ����ֽ������������ͼҳ��  
		     mv.setViewName("success");   
			return mv;
	}

}
