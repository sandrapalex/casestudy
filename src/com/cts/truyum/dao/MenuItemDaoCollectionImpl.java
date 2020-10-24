package com.cts.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.cts.truyum.model.*;
import com.cts.truyum.util.DateUtil;

import MenuItemDao;

import java.text.ParseException;

public class MenuItemDaoCollectionImpl implements MenuItemDao{
	static List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() throws ParseException {
		super();
		if(menuItemList==null) {
			menuItemList=new ArrayList<MenuItem>();
			menuItemList.add(new MenuItem(000001,"Sandwich",99.00f, true, DateUtil.convertToDate("15/03/2017"), "Main Course", true));
			menuItemList.add(new MenuItem(000002,"Burger",129.00f, true, DateUtil.convertToDate("23/12/2017"), "Main Course", false));
			menuItemList.add(new MenuItem(000003,"Pizza",149.00f, true, DateUtil.convertToDate("21/08/2018"), "Main Course", false));
			menuItemList.add(new MenuItem(000004,"French Fries",57.00f, true, DateUtil.convertToDate("02/07/2017"), "Starters", true));
			menuItemList.add(new MenuItem(000005,"Chocolate Brownie",32.00f, true, DateUtil.convertToDate("02/11/2022"), "Dessert", true));
		}
	}
	
	public  List<MenuItem> getMenuItemListAdmin(){
		
		return menuItemList;
	}
	@Override
	public  List<MenuItem> getMenuItemListCustomer(){
		List<MenuItem> menuItemListCus=new ArrayList<MenuItem>();
		Date date=new Date();
		for(MenuItem menuItem:menuItemList) {
			if(menuItem.getDateOfLaunch().getTime()<=date.getTime() && menuItem.isActive()) {
				menuItemListCus.add(menuItem);
			}
		}
		return menuItemListCus;
	}
	
	public void modifyMenuItem(MenuItem menuItem) {
		for(MenuItem item: menuItemList) {
			if(menuItem.getId()==item.getId()) {
				item.setName(menuItem.getName());
				item.setCategory(menuItem.getCategory());
				item.setDateOfLaunch(menuItem.getDateOfLaunch());
				item.setFreeDelivery(menuItem.isFreeDelivery());
				item.setPrice(menuItem.getPrice());
				item.setActive(menuItem.isActive());
			}
		}
	}
	
	@Override
	public MenuItem getMenuItem(long menuItemId) {
		for(MenuItem menuItem: menuItemList) {
			if(menuItemId==menuItem.getId()) {
				return menuItem;
			}
		}
		return null;
	}
}







