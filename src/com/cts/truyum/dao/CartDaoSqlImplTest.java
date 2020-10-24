package com.cts.truyum.dao;

import java.text.ParseException;
import java.util.List;
import com.cts.truyum.model.*;

public class CartDaoSqlImplTest {
	
	public static void testAddCartItem() throws ParseException {
		CartDaoSqlIml cartDaoSqlIml=new CartDaoSqlIml();
		cartDaoSqlIml.addCartItem(2, 2);
		cartDaoSqlIml.addCartItem(1, 2);
		cartDaoSqlIml.addCartItem(2, 2);
		cartDaoSqlIml.addCartItem(2, 3);
		cartDaoSqlIml.addCartItem(2, 4);
	}
	public static void testGetAllCartitem() {
		int user_id=2;
		CartDaoSqlIml cartDaoSqlIml=new CartDaoSqlIml();
		List<MenuItem> menuItemList=cartDaoSqlIml.getAllCartItems(user_id);
		for(MenuItem item: menuItemList)
			System.out.println("Adding to:"+item);
	}
	
	public static void testRemoveCartItem() {
		CartDaoSqlIml cartDaoSqlIml=new CartDaoSqlIml();
		long userId=1;
		System.out.println("\n Before Removing");
		for(MenuItem item : cartDaoSqlIml.getAllCartItems(userId)) {
			System.out.println("Item:"+item);
		}
		long menuItemId=1;
		cartDaoSqlIml.removeCartItem(userId, menuItemId);
		System.out.println("\n After Deleting");
		for(MenuItem item : cartDaoSqlIml.getAllCartItems(userId)) {
			System.out.println(item);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		System.out.println("AddCartItem");
		try {
			testAddCartItem();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("getAllCartItem");
		testGetAllCartitem();
		System.out.println("removeCartItem");
		testRemoveCartItem();
		testGetAllCartitem();
		System.out.println("Completed!!!");
	}
}
