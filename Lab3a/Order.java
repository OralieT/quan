package Lab3a;

public class Order {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		super();
		this.items = items;
	}

	public double cost() {
		// TODO
		double totalCost = 0.0;
		for (OrderItem orderItem : items) {
			totalCost += orderItem.getP().getPrice() * orderItem.getQuality();
		}
		return totalCost;
	}

	// using binary search approach
	public boolean contains(Product p) {
		int left = 0;
		int right = items.length - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			Product product = items[mid].getP();
			int result = product.getId().compareTo(p.getId());
			
			if(result == 0) {
				return true;
			} else if (result < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}

	// get all products based on the given type using
	// linear search
	public Product[] filter(String type) {
		int count = 0;
		for (int i = 0; i < items.length; i++) {
			if(items[i].getP().getType().equals(type)) {
				count++;
			}
		}
		Product result[] = new Product[count];
		int index = 0;
		
		for (int i = 0; i < items.length; i++) {
			if(items[i].getP().getType().equals(type)) {
				result[index] = items[i].getP();
				index++;
			}
		}
		return result;
	}
}
