package com.cts.truyum.dao;

public interface CartDao {
	public void addCartItem(long userId, long menuItemId);
	public List<MenuItem> getAllCartItems(long userId);
	public void removeCartItem(long userId, long menuItemId);

}
