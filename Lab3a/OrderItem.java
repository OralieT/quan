package Lab3a;

public class OrderItem implements Comparable<OrderItem> {
	private Product p;
	private int quality;

	public OrderItem(Product p, int quality) {
		super();
		this.p = p;
		this.quality = quality;
	}
	
	public int compareTo(OrderItem o) {
		return p.getId().compareTo(o.p.getId());
	}
	
	@Override
	public String toString() {
		return p + ": " + quality ;
	}

	public Product getP() {
		return p;
	}

	public int getQuality() {
		return quality;
	}
}
