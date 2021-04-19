package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Order;
import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;

@ManagedBean
@ViewScoped
public class FormController {
	@Inject
	OrdersBusinessInterface service;
	
	@EJB
	MyTimerService timer;
	


public OrdersBusinessInterface getService() {
	return service;
}

public String onLogOff() {
	// Invalidate the Session to clear the security token
	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			
	// Redirect to a protected page (so we get a full HTTP Request) to get Login Page
	return "TestResponse.xhtml?faces-redirect=true";

} 


private void getAllOrders() {
	Connection conn = null;
	String url = "jdbc:postgresql://localhost:5432/postgres";
	String username = "postgres";
	String password = "root";
	String sql = "SELECT \"ID\", \"ORDER_NO\", \"PRODUCT_NAME\", \"PRICE\", \"QUANTITY\" FROM testapp.\"Orders\"";
	List<Order> orders = new ArrayList<Order>();
	
	try {
		//connect to database
		conn = DriverManager.getConnection(url, username, password);
		
		//exeute sql query
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			orders.add(new Order(rs.getString("ORDER_NO"),
									rs.getString("PRODUCT_NAME"),
									rs.getFloat("PRICE"),
									rs.getInt("QUANTITY")));
		}
		
		for(int i = 0; i < orders.size(); i++) {
			System.out.println("Order: " + orders.get(i).getOrderNo() 
										 + " | " + orders.get(i).getProductName()
										 + " | " + orders.get(i).getPrice()
										 + " | " + orders.get(i).getQuantity());
		}
		
		rs.close();
		//System.out.println("Success!!");
		//conn.close();
	}
	catch (SQLException e){
		e.printStackTrace();
		System.out.println("Failure!!");
	}
	finally 
	{
		if(conn != null) 
		{
			try 
			{
				conn.close();
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}

private void insertOrder() {
	Connection conn = null;
	String url = "jdbc:postgresql://localhost:5432/postgres";
	String username = "postgres";
	String password = "root";
	String sql = "INSERT INTO testapp.\"Orders\"(\"ID\", \"ORDER_NO\", \"PRODUCT_NAME\", \"PRICE\", \"QUANTITY\") VALUES (11, '0000000011', 'This is Product 11', 11.00, 11)";
	
	try {
		//connect to database
		conn = DriverManager.getConnection(url, username, password);
		
		//exeute sql query
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	}
	catch (SQLException e){
		e.printStackTrace();
		System.out.println("Failure!!");
	}
	finally 
	{
		if(conn != null) 
		{
			try 
			{
				conn.close();
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}

public String onSendOrder() {
	//FacesContext context = FacesContext.getCurrentInstance();
	//Order order = context.getApplication().evaluateExpressionGet(context, "#{order}" , Order.class);
	//String orderNo, String productName, float price, int quantity
	Order order = new Order("0000000011", "This is Product 11", 11, 11);
	
	service.sendOrder(order);
	
	FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("order", order);
	return "OrderResponse.xhtml";
} 
}
