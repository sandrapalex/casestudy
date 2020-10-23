package com.cts.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.cts.truyum.model.*;
import com.sun.tools.javac.main.Main.Result;

public class CartDaoSqlIml implements CartDao{

	@Override
	public void addCartItem(long userId, long menuItemId) throws ParseException {
		try {
			Connection con=ConnectionHandler.getConnection();
			String query="INSERT INTO CART(ct_user_id,ct_menu_id) VALUES(?, ?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);
			if(ps.executeUpdate() >0)
				System.out.println("Query Successful");
			else
				System.out.println("Query Unsuccessful");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) {
		List<MenuItem> menuItemList=new ArrayList<>();
		Cart cart=new Cart(menuItemList,0);
		double total=0;
		try {
			Connection con=ConnectionHandler.getConnection();
			String query="SELECT * FROM MENU_ITEMS WHERE ID IN(SELECT ct_menu_id FROM CART WHERE ct_user_id =?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setLong(1, userId);
			ResultSet rslt=ps.executeQuery();
			
			while(rslt.next()) {
				long id=rslt.getLong(1);
				String name=rslt.getString(2);
				float price=rslt.getFloat(3);
				total=total+price;
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
		cart.setMenuItemList(menuItemList);
		cart.setTotal(total);
		return menuItemList;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		Connection con=ConnectionHandler.getConnection();
		String query="DELETE FROM CART WHERE ct_menu_id= ? AND ct_user_id=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setLong(1, userId);
		ps.setLong(2, menuItemId);
		
		if(ps.executeUpdate() >0)
			System.out.println("Query Successful");
		else
			System.out.println("Query Unsuccessful");
		
	}
	
}
