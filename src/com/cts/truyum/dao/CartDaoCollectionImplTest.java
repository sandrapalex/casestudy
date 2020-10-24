package com.cts.truyum.dao;

import java.text.ParseException;
import java.util.List;
import com.cts.truyum.model.*;

public class CartDaoCollectionImplTest {
	
	public static CartDao cartDao=new CartDaoCollectionImpl();
	
	public static void testAddCartItem() throws CartEmptyException, ParseException {
		List<MenuItem> cartItemList;
		cartDao.addCartItem(1, 4);
		cartDao.addCartItem(2, 3);
		cartItemList=cartDao.getAllCartItems(1);
		cartItemList.forEach(System.out::println);
	}
	
	public static void testGetAllCartItems() throws CartEmptyException {
		List<MenuItem> allCartItems;
		allCartItems=cartDao.getAllCartItems(1);
		allCartItems.forEach(System.out::println);
	}
	
	public static void testRemoveCartItem() throws CartEmptyException {
		List<MenuItem> cartItemList;
		cartDao.removeCartItem(1, 4);
		cartItemList=cartDao.getAllCartItems(1);
		cartItemList.forEach(System.out::println);
	}
	public static void main(String[] args) throws ParseException {
		try {
			testAddCartItem();
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		try {
			testGetAllCartItems();
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		try {
			testRemoveCartItem();
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
