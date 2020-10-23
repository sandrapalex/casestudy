package com.cts.truyum.dao;

import com.cts.truyum.model.*;
import com.cts.truyum.util.*;
import java.lang.Exception;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartDaoCollectionImpl implements CartDao{
	private static Map<Long, Cart> userCarts;
	
	public CartDaoCollectionImpl() {
		super();
		if(userCarts==null) {
			userCarts=new HashMap<Long, Cart>();
		}
	}
	
	public  Map<Long, Cart> getUserCarts() {
		return userCarts;
	}

	public  void setUserCarts(Map<Long, Cart> userCarts) {
		CartDaoCollectionImpl.userCarts = userCarts;
	}
	@Override
	public void addCartItem(long userId, long menuItemId) throws ParseException{
		
		MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
		MenuItem item=menuItemDao.getMenuItem(menuItemId);
		
		if(userCarts.containsKey(userId)) {
			List<MenuItem> menuItemList=userCarts.get(userId).getMenuItemList();
			menuItemList.add(item);
			userCarts.get(userId).setMenuItemList(menuItemList);
		}
		else {
			List<MenuItem> userList= new ArrayList<>();
			userList.add(item);
			Cart cart=new Cart(userList);
			userCarts.put(userId, cart);
		}
	}


	public List<MenuItem> getAllCartItems(long userId){
		Cart cart=userCarts.get(userId);
		List<MenuItem> allCartItems=cart.getMenuItemList();
		if(allCartItems.isEmpty()) {
			throw new CartEmptyException();
		}
	}
	public void removeCartItem(long userId, long menuItemId) {
		
	}
}
