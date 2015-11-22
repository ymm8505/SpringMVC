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

	
	//商品查询
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(ItemsQueryVo itemsQueryVo) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<ItemsCustom>  itemsList = itemsService.findeItemList(itemsQueryVo);
		 //添加模型数据 可以是任意的POJO对象  
	     mv.addObject("itemsList", itemsList);  
	     //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面  
	     mv.setViewName("items/itemList");   
		return mv;
	}
	
	// 单个商品信息修改页面 查询
	// 限制http请求方法，可以post和get
	@RequestMapping(value = "/editItems", method = { RequestMethod.POST,RequestMethod.GET })
	public ModelAndView editItems(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 调用service根据商品id查询商品信息
		ItemsCustom itemsCustoms =  itemsService.findItemsById(id);
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 将商品信息放到model
		modelAndView.addObject("items", itemsCustoms);
		// 商品修改页面
		modelAndView.setViewName("items/editItems");
		return modelAndView;
	}
	
	// 单个商品信息修改页面  提交
	//@ModelAttribute("items")  指定回显到页面的 变量名	
	@RequestMapping("/editItemsSubmit")
	public String  editItemsSubmit(Model model, HttpServletRequest request,Integer id,
			@ModelAttribute("items") @Validated(value={ValidationGroup1.class}) ItemsCustom  itemsCustom ,BindingResult bindingResult,
			MultipartFile items_pic
			) throws Exception {
		
		//如果校验有错误 
		if(bindingResult.hasErrors()){
			//获取到所有的错误提示
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			//放入Model里回传到页面
			model.addAttribute("allErrors", allErrors);
			return "items/editItems";
		}
		
//		得到页面上传来的原始图片文件名   比如          QQ图片20150930142618.jpg 
		String items_name =items_pic.getOriginalFilename() ;
		
		//转型为MultipartHttpRequest(重点的所在)  
        MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;  
        //  获得第1张图片（根据前台的name名称得到上传的文件）   
        MultipartFile imgFile1  =  multipartRequest.getFile("items_pic"); 
        String  imgFile2 = request.getParameter("items_pic");
		
//		如果图片有内容  图片名称长度 > 0
		if(items_pic!=null && items_pic.getOriginalFilename()!=null && items_pic.getOriginalFilename().length()>0){
			String ok_items_name = items_name.substring(items_name.lastIndexOf("."));
			String pic_path = "D:\\pic_upload\\temp\\";
			String NewFileNmae = UUID.randomUUID()+ ok_items_name;
			File file = new File(pic_path+NewFileNmae);
			items_pic.transferTo(file);
			itemsCustom.setPic(NewFileNmae);
		}
		
		// id = Integer.parseInt(request.getParameter("items.id"));
		// 调用service更新商品信息
		// 返回ModelAndView
		// ModelAndView modelAndView = new ModelAndView();
		itemsService.updatItemsById(id, itemsCustom);
		// 商品修改页面
		// modelAndView.setViewName("success");
		// return "redirect:queryItems.action"
		String returnStr = "items/editItems.action?id="+id;
		return returnStr;
	}
		
	// 批量删除商品
	@RequestMapping("/BatDeleteItems")
	public ModelAndView  BatDeleteItems(Integer[] items_id) throws Exception {
		// 调用service删除所选择的商品信息
		//			..........
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 商品修改页面
		modelAndView.setViewName("success");
		return modelAndView;
	}
		
		
	//批量商品修改查询
	@RequestMapping("/editQueryItems")
		public ModelAndView editQueryItems(ItemsQueryVo itemsQueryVo) throws Exception {
			ModelAndView mv = new ModelAndView();
			List<ItemsCustom>  itemsList = itemsService.findeItemList(itemsQueryVo);
			 //添加模型数据 可以是任意的POJO对象  
		     mv.addObject("itemsList", itemsList);  
		     //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面  
		     mv.setViewName("items/editQueryItems");   
			return mv;
	}
	
	//批量商品修改提交 
	@RequestMapping("/editQueryItemsSubmit")
		public ModelAndView editQueryItemsSubmit(ItemsQueryVo itemsQueryVo) throws Exception {
			ModelAndView mv = new ModelAndView();
//			List<ItemsCustom>  itemsList = itemsService.findeItemList(itemsQueryVo);
			 //添加模型数据 可以是任意的POJO对象  
//		     mv.addObject("itemsList", itemsList);  
		     //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面  
		     mv.setViewName("success");   
			return mv;
	}

	
	
	
	//批量商品修改查询
	/**
	 * @param itemsQueryVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editMapItems")
		public ModelAndView editMapQueryItems(ItemsQueryVo itemsQueryVo ,HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 调用service根据商品id查询商品信息
		ItemsCustom itemsCustoms =  itemsService.findItemsById(id);
		// 返回ModelAndView
		ModelAndView mv = new ModelAndView();
		// 将商品信息放到model
		mv.addObject("items", itemsCustoms);
		// 商品修改页面
		mv.setViewName("items/editMapItems");
		return mv;
	}
	
	//批量商品修改提交 
	@RequestMapping("/editMapItemsSubmit")
		public ModelAndView editMapQueryItemsSubmit(ItemsQueryVo itemsQueryVo) throws Exception {
			ModelAndView mv = new ModelAndView();
//				List<ItemsCustom>  itemsList = itemsService.findeItemList(itemsQueryVo);
			 //添加模型数据 可以是任意的POJO对象  
//			     mv.addObject("itemsList", itemsList);  
		     //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面  
		     mv.setViewName("success");   
			return mv;
	}

}
