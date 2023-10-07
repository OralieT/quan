package Lab3a;

public class Product implements Comparable<Product> {
	private String id;
	private String name;
	private double price;
	private String type;

	public Product(String id, String name, double price, String type) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Product: id= " + id + ", name= " + name + ", price= " + price + ", type= " + type;
	}
	
	public int compareTo(Product o) {
		return this.id.compareTo(o.id);
	}
	
}
