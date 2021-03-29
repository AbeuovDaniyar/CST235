package business;

import java.util.List;

import javax.ejb.Local;

import beans.Product;

@Local
public interface ProductBusinessInterface {
	
public List<Product> getProducts();
public void addProduct(Product product);
public void removeProduct(int productID);
public void updateProduct(int productID, Product product);

}
