package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;

/**
 * Session Bean implementation class OredersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@Alternative
public class OredersBusinessService implements OrdersBusinessInterface{

	List<Order> orders = new ArrayList<Order>();
    /**
     * Default constructor. 
     */
    public OredersBusinessService() {
		// TODO Auto-generated constructor stub
		orders.add(new Order("00000000", "This is product 1 bs", (float)1.00, 1));
		orders.add(new Order("00000001", "This is product 2 bs", (float)2.02, 14));
		orders.add(new Order("00000002", "This is product 3 bs", (float)11.08, 15));
		orders.add(new Order("00000003", "This is product 4 bs", (float)17.01, 123));
		orders.add(new Order("00000004", "This is product 5 bs", (float)21.43, 16));
		orders.add(new Order("00000005", "This is product 6 bs", (float)54.56, 14));
		orders.add(new Order("00000006", "This is product 7 bs", (float)21.12, 54));
		orders.add(new Order("00000007", "This is product 8 bs", (float)34.57, 23));
		orders.add(new Order("00000008", "This is product 9 bs", (float)64.06, 56));
		orders.add(new Order("00000009", "This is product 10 bs", (float)34.01, 12));
		orders.add(new Order("00000010", "This is product 11 bs", (float)24.60, 21));
		orders.add(new Order("00000011", "This is product 12 bs", (float)67.30, 35));
    }

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("*******Hello this is OrdersBusinessService*********");
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		
		return orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		// TODO Auto-generated method stub
		this.orders = orders;
	}

}
