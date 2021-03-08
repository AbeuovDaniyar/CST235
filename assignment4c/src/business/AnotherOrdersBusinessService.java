package business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;

/**
 * Session Bean implementation class AnotherOrdersBusinessService
 */
@Stateless
@LocalBean
@Alternative
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {

	List<Order> orders;
	
    /**
     * Default constructor. 
     */
    public AnotherOrdersBusinessService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("*******Hello this is AnotherOrdersBusinessService*********");
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOrders(List<Order> orders) {
		// TODO Auto-generated method stub
		
	}

}
