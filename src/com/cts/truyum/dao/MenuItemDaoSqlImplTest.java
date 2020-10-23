package com.cts.truyum.dao;

import java.util.Date;
import java.util.List;
import  com.cts.truyum.model.*;
import com.cts.truyum.util.*;

public class MenuItemDaoSqlImplTest {
	public static MenuItemDaoSqlImpl menuItemDao=new MenuItemDaoSqlImpl();
	
	public static void testGetMenuItemListAdmin() {
		List<MenuItem> itemAdminList=menuItemDao.getMenuItemListAdmin();
		itemAdminList.forEach(System.out::println);
	}
	
	public static void testGetMenuItemListCustomer() {
		List<MenuItem> itemCusList=menuItemDao.getMenuItemListCustomer();
		itemCusList.forEach(System.out::println);
	}
	
	public static void testModifyMenuItem() {
		DateUtil d=new DateUtil();
		MenuItem menuItem=new MenuItem(5, "Chocolate", 30.0f, true, d.convertToDate("15/03/2017"), "Dessert", true);
		menuItemDao.modifyMenuItem(menuItem);
	}
	
	public static void testGetMenuItem() {
		MenuItem menuItem = menuItemDao.getMenuItem(2);
		if(menuItem == null) {
			System.out.println("The Item does not exist in our database");
			return;
		}
		System.out.println(menuItem);
			
	}
	
	public static void main(String[] args) {
		System.out.println("MenuItemDaoImplTest begins");
		System.out.println("Admin List of MenuItems");
		testGetMenuItemListAdmin();
		System.out.println("Customer List of MenuItems");
		testGetMenuItemListCustomer();
		System.out.println("Modified MenuItem");
		testModifyMenuItem();
		System.out.println("Get Menu Item");
		testGetMenuItem();
	}
}
