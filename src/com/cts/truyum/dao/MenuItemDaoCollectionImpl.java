package com.cts.truyum.dao;

public class MenuItemDaoCollectionImpl implements MenuItemDao{
	private List<MenuItem> menuItemList;
	
	public MenuItemDaoCollectionImpl() {
		super();
		
	}
	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}
	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}
	public  List<MenuItem> getMenuItemListAdmin(){
		
	}
	public  List<MenuItem> getMenuItemListCustomer(){
		
	}
	public void modifyMenuItem(MenuItem menuItem) {
		
	}
	public MenuItem getMenuItem(long menuItemId) {
		
	}
}
