package com.cts.truyum.dao;


import java.util.List;
import com.cts.truyum.model.*;

public interface MenuItemDao {
	public List<MenuItem> getMenuItemListAdmin();
	public List<MenuItem> getMenuItemListCustomer();
	public MenuItem getMenuItem(long menuItemId);
	public static void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		
	}
}
