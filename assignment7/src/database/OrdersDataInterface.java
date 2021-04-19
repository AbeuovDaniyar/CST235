package database;

import javax.ejb.Local;

import beans.Order;

@Local
public interface OrdersDataInterface {
	
public void create(Order order);

}
