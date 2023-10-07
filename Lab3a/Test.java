package Lab3a;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		Product p1 = new Product("001", "Coca Cola", 10.0, "Soft Drink");
		Product p2 = new Product("004", "Pepsi", 18.0, "Soft Drink");
		Product p3 = new Product("002", "Orange", 11.0, "Fruit");
		Product p4 = new Product("003", "Apple", 12.0, "Fruit");
		Product p5 = new Product("005", "Tivi", 12.0, "Electronic");

		OrderItem it1 = new OrderItem(p1, 2);
		OrderItem it2 = new OrderItem(p2, 2);
		OrderItem it3 = new OrderItem(p3, 2);
		OrderItem it4 = new OrderItem(p4, 2);
		OrderItem[] items = { it1, it2, it3, it4 };

		Arrays.sort(items);
		System.out.println(Arrays.toString(items));

		Order order = new Order(items);
		double totalCost = order.cost();
		System.out.println("Tong so tien dat hang: " + totalCost);
		System.out.println("Contains: " + order.contains(p1));
		System.out.println("Contains: " + order.contains(p5));

		Product[] type1 = order.filter("Soft Drink");
		Product[] type2 = order.filter("Fruit");

		System.out.println("Type 1: ");
		for (Product product : type1) {
			System.out.println(product.getName() + " ");
		}

		System.out.println("Type 2: ");
		for (Product product : type2) {
			System.out.println(product.getName() + " ");
		}

	}
}
