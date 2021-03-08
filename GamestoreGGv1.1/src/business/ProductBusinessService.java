package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Product;

@Stateless
@Local(ProductBusinessInterface.class)
@Alternative
public class ProductBusinessService implements ProductBusinessInterface{
	List<Product> products = new ArrayList<Product>();
	
	public ProductBusinessService() {
	 
	}
	
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		products.add(product);
		System.out.println("**************** Successfully added new product: " + product.name);
	}

}
