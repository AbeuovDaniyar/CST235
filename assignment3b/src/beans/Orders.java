package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Orders {
	List<Order> orders  = new ArrayList<Order>();
	
	public Orders() {
		orders.add(new Order("00000000", "This is product 1", (float)1.00, 1));
		orders.add(new Order("00000001", "This is product 2", (float)2.02, 14));
		orders.add(new Order("00000002", "This is product 3", (float)11.08, 15));
		orders.add(new Order("00000003", "This is product 4", (float)17.01, 123));
		orders.add(new Order("00000004", "This is product 5", (float)21.43, 16));
		orders.add(new Order("00000005", "This is product 6", (float)54.56, 14));
		orders.add(new Order("00000006", "This is product 7", (float)21.12, 54));
		orders.add(new Order("00000007", "This is product 8", (float)34.57, 23));
		orders.add(new Order("00000008", "This is product 9", (float)64.06, 56));
		orders.add(new Order("00000009", "This is product 10", (float)34.01, 12));
		orders.add(new Order("00000010", "This is product 11", (float)24.60, 21));
		orders.add(new Order("00000011", "This is product 12", (float)67.30, 35));
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
