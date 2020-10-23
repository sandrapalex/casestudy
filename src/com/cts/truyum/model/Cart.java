package com.cts.truyum.model;

import java.util.List;

public class Cart {
	private List<MenuItem> menuItemList;
	private double total;
	public Cart(List<MenuItem> menuItemList) {
		super();
		this.menuItemList = menuItemList;
	}
	
	public Cart(List<MenuItem> menuItemList, double total) {
		super();
		this.menuItemList = menuItemList;
		this.total=total;
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}
	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str="menuItemList="+menuItemList+" total="+total;
		return str;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Cart other=(Cart) obj;
		if(menuItemList==null) {
			if(other.menuItemList !=null)
				return false;
		}
		else if(!menuItemList.equals(other.menuItemList)){
			return false;
		}
		if(Double.doubleToLongBits(total)!=Double.doubleToLongBits(other.total))
			return false;
		return true;
	}
	
	
	
}
