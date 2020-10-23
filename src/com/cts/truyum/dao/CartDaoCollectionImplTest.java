package com.cts.truyum.dao;

import java.text.ParseException;
import java.util.List;
import com.cts.truyum.model.*;

public class CartDaoCollectionImplTest {
	
	public static CartDao cartDao=new CartDaoCollectionImpl();
	
	public static void testAddCartItem() throws CartEmptyException {
		cartDao.removeCartItem(1, 1);
		List<MenuItem> cartItemList;
		cartItemList=cartDao.getAllCartItems(1);
		cartItemList.forEach(System.out::println);
	}
	
	public static void testGetAllCartItems() throws CartEmptyException {
		List<MenuItem> allCartItems;
		allCartItems=cartDao.getAllCartItems(1);
		allCartItems.forEach(System.out::println);
	}
	
	public static void testRemoveCartItem() throws CartEmptyException {
		try {
			cartDao.addCartItem(1, 1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<MenuItem> cartItemList;
		cartItemList=cartDao.getAllCartItems(1);
		cartItemList.forEach(System.out::println);
	}
	public static void main(String[] args) {
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
