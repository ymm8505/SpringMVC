package com.xiaoyang.po;

import java.util.List;
import java.util.Map;

/*
 * 商品信息查询条件的包装对象
 * 
 * */
public class ItemsQueryVo  {
	//商品信息	
	private Items items;
	//为了系统扩展 对原始生产的po进行扩展
	private ItemsCustom  itemsCustom;
	
	private List<ItemsCustom>  itemsList;
	
	private Map<String ,Object> itemsMap;
	
	public Map<String, Object> getItemsMap() {
		return itemsMap;
	}
	public void setItemsMap(Map<String, Object> itemsMap) {
		this.itemsMap = itemsMap;
	}
	public List<ItemsCustom> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}
	
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}
	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
	
	
}
