package com.cts.truyum.dao;
import java.lang.Exception;
public class CartDaoCollectionImpl implements CartDao{
	private HashMap<Long, Cart> userCarts;
	public CartDaoCollectionImpl() {
		super();
	}
	public HashMap<Long, Cart> getUserCarts() {
		return userCarts;
	}
	public void setUserCarts(HashMap<Long, Cart> userCarts) {
		this.userCarts = userCarts;
	}
	public void addCartItem(long userId, long menuItemId) {
		
	}
	public List<MenuItem> getAllCartItems(long userId)throws CartEmptyException{
		
	}
	public void removeCartItem(long userId, long menuItemId) {
		
	}
}
