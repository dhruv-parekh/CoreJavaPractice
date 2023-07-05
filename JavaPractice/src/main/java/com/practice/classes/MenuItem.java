package com.practice.classes;

import java.util.List;

public class MenuItem {

	private String item;
	private String type;
	private double price;
	
	
	List<String> foodOnly = List.of("tuna sandwich", "ham and cheese sandwich", "bacon and egg", "steak", "hamburger", "cinnamon roll");
	List<String> drinkOnly = List.of("orange juice", "lemonade", "cranberry juice", "pineapple juice", "lemon iced tea", "vanilla chai latte", "hot chocolate", "iced coffee");
	

	
	public MenuItem() {
	}

	public MenuItem(String item, String type, double price) {
		super();
		this.item = item;
		this.type = type;
		this.price = price;
	}
	

//	public MenuItem[] getMenu() {
//		return menu;
//	}
//
//	public void setMenu(MenuItem[] menu) {
//		this.menu = menu;
//	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
