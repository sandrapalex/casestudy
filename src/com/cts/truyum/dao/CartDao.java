package com.cts.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cts.truyum.model.*;
public interface CartDao {
	public void addCartItem(long userId, long menuItemId) throws ParseException;
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException; //raises CartemptyException;
	public void removeCartItem(long userId, long menuItemId);

}
