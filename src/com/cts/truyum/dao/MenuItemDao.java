package com.cts.truyum.dao;

public interface MenuItemDao {
	public List<MenuItem> getMenuItemListAdmin();
	public List<MenuItem> getMenuItemListCustomer();
	public void modifyMenuItem(MenuItem menuItem);
	public MenuItem getMenuItem(long menuItemId);
}
