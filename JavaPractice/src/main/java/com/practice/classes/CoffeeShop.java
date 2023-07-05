package com.practice.classes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CoffeeShop {

	private String name;

	List<String> orders = new LinkedList<>();
	 MenuItem[] menu = {
			new MenuItem("tuna sandwich", "food", 5.0),
			new MenuItem("ham and cheese sandwich", "food", 5.0),
			new MenuItem("bacon and egg", "food", 5.0),
			new MenuItem("steak", "food", 5.0),
			new MenuItem("hamburger", "food", 5.0),
			new MenuItem("cinnamon roll", "food", 5.0),
			new MenuItem("lemonade", "drink", 1.0),
			new MenuItem("orange juice", "drink", 5.0),
			new MenuItem("cranberry juice", "drink", 5.0),
			new MenuItem("pineapple juice", "drink", 5.0),
			new MenuItem("iced coffee", "drink", 5.0),
			new MenuItem("lemon iced tea", "drink", 5.0),
			
	};

	MenuItem mi = new MenuItem();

	// 1
	void addOrder(String name) {
		boolean flag = false;
		for (MenuItem m : menu) {
			if (m.getItem().equals(name)) {
				orders.add(name);
				flag = true;
				break;
			}
		}
		 if(flag) {
			 System.out.println("item added");
		 }
		 else  System.out.println("item not available.");
	}

	// 2
	void fulfillOrder() {
		String res = "all orders have been fulfilled.";
		if (orders.size() != 0) {
			String item = orders.get(orders.size()-1);
			res = item + " is ready and served.";
			orders.remove(item);
		}
		System.out.println(res);
	}

	// 3
	void listOrders() {
		System.out.println(orders);
	}

	// 4
	void dueAmount() {
		double total = 0;

		for (String name : orders) {

			for (MenuItem m : menu) {
				if (m.getItem().equals(name)) {
					total += m.getPrice();
					break;
				}
			}
		}
		System.out.println(total);
	}

	// 5
	void cheapestItem() {
		double val = 100;
		String cheapestItem = "";
		for (MenuItem m : menu) {
			if (m.getPrice() <= val) {
				cheapestItem = m.getItem();
				val = m.getPrice();
			}
		}
		System.out.println(cheapestItem);
	}

	// 6
	void foodOnly() {
		System.out.println(mi.foodOnly);
	}

	// 7
	void drinksOnly() {
		System.out.println(mi.drinkOnly);
	}
	
	public static void main(String[] args) {
		CoffeeShop tcs = new CoffeeShop();
		
		tcs.addOrder("hot cocoa");
		tcs.addOrder("iced tea");
		tcs.addOrder("cinnamon roll");
		tcs.addOrder("tuna sandwich");
		
		tcs.listOrders();
		tcs.dueAmount();
		
		tcs.fulfillOrder();
		tcs.fulfillOrder();
		tcs.fulfillOrder();
		
		tcs.listOrders();
		tcs.dueAmount();
		
		tcs.cheapestItem();
		tcs.drinksOnly();
		tcs.foodOnly();
		
		
	}

//	List<String> foodOnly = List.of("tuna sandwich", "ham and cheese sandwich", "bacon and egg", "steak", "hamburger", "cinnamon roll");
//	List<String> drinkOnly = List.of("orange juice", "lemonade", "cranberry juice", "pineapple juice", "lemon iced tea", "vanilla chai latte", "hot chocolate", "iced coffee");
//	
	

}
