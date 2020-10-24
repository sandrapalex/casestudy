package com.cts.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.cts.truyum.model.*;

public class MenuItemDaoSqlImpl implements MenuItemDao{
	
	public static PreparedStatement ps=null;
	
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		List<MenuItem> menuItemList = new ArrayList<>();
		try {
			Connection con=ConnectionHandler.getConnection();
			String query="SELECT * FROM MENU_ITEMS";
			ps=con.prepareStatement(query);
			ResultSet rslt=ps.executeQuery();
			
			while(rslt.next()) {
				long id=rslt.getLong(1);
				String name=rslt.getString(2);
				float price=rslt.getFloat(3);
				boolean active=rslt.getBoolean(4);
				Date dateOfLaunch=rslt.getDate(5);
				String category=rslt.getString(6);
				boolean freeDelivery=rslt.getBoolean(7);
				MenuItem item=new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
				menuItemList.add(item);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> menuItemList = new ArrayList<>();
		try {
			Connection con=ConnectionHandler.getConnection();
			String query="SELECT * FROM MENU_ITEMS WHERE active=TRUE AND dateofLaunch < now()";
			ps=con.prepareStatement(query);
			ResultSet rslt=ps.executeQuery();
			
			while(rslt.next()) {
				long id=rslt.getLong(1);
				String name=rslt.getString(2);
				float price=rslt.getFloat(3);
				boolean active=rslt.getInt(4)==1;
				Date dateOfLaunch=rslt.getDate(5);
				String category=rslt.getString(6);
				boolean freeDelivery=rslt.getInt(7)==1;
				MenuItem item=new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
				menuItemList.add(item);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuItemList;
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem menuItem=null;
		
		try {
			Connection con=ConnectionHandler.getConnection();
			String query = "SELECT * FROM MENU_ITEMS WHERE id=?";
			ps=con.prepareStatement(query);
			ResultSet rslt=ps.executeQuery();
			
			while(rslt.next()) {
				long id=rslt.getLong(1);
				String name=rslt.getString(2);
				float price=rslt.getFloat(3);
				boolean active=rslt.getInt(4)==1;
				Date dateOfLaunch=rslt.getDate(5);
				String category=rslt.getString(6);
				boolean freeDelivery=rslt.getInt(7)==1;
				MenuItem item=new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
				break;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuItem;
	}

	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		try {
			Connection con=ConnectionHandler.getConnection();
			String query="UPDATE MENU_ITEMS SET item_name=?, price=?, active=?, dateoflaunch=?, categroy=?, freedelivery=? WHERE id=?";
			SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date date =java.sql.Date.valueOf(format.format(menuItem.getDateOfLaunch()));
			ps=con.prepareStatement(query);
			ps.clearParameters();
			
			ps.setString(1, menuItem.getName());
			ps.setFloat(2, menuItem.getPrice());
			ps.setBoolean(3, menuItem.isActive());
			ps.setString(4, format.format(menuItem.getDateOfLaunch()));
			ps.setString(5, menuItem.getCategory());
			ps.setBoolean(6, menuItem.isFreeDelivery());
			ps.setLong(7, menuItem.getId());
			
			if(ps.executeUpdate()>0)
				System.out.println("Query Successful");
			else
				System.out.println("Query Unsuccessful");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}






