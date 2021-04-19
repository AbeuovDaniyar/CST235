package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;

@Stateless
@Local(OrdersDataInterface.class)
@Alternative
public class OrdersDataService implements OrdersDataInterface{

	@Override
	public void create(Order order) {
		// TODO Auto-generated method stub
		Connection conn = null;
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "root";
		//String sql = "INSERT INTO testapp.\"Orders\"(\"ID\", \"ORDER_NO\", \"PRODUCT_NAME\", \"PRICE\", \"QUANTITY\") VALUES (12, '0000000012', 'This is Product 12', 12.00, 12)";
		String sql = String.format("INSERT INTO testapp.\"Orders\"(\"ID\", \"ORDER_NO\", \"PRODUCT_NAME\", \"PRICE\", \"QUANTITY\")"
				+ " VALUES(%d, '%s', '%s', %f, %d)", 11, order.getOrderNo(), order.getProductName(), order.getPrice(), order.getQuantity());
		
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

}
