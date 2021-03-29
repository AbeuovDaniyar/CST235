package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Product;
import beans.User;
import business.ProductBusinessInterface;
import business.UsersBusinessInterface;

@ManagedBean
@ViewScoped
public class FormController {
	@Inject
	UsersBusinessInterface service;
	
	@Inject
	ProductBusinessInterface productService;
	
public String onSubmit() {
	FacesContext context = FacesContext.getCurrentInstance();
	User user = context.getApplication().evaluateExpressionGet(context, "#{user}" , User.class);
	FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
	return "TestResponse.xhtml";
}

public UsersBusinessInterface getService() {
	return service;
}

public ProductBusinessInterface getProductService() {
	return productService;
}

public String onAddProduct(Product product) {
	/*
	FacesContext context = FacesContext.getCurrentInstance();
	Product product = context.getApplication().evaluateExpressionGet(context, "#{product}" , Product.class);
	FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("product", product);*/
	
	ProductBusinessInterface productService = getProductService();
	productService.addProduct(product);

	return "displayProducts.xhtml";
}

public String onDelete(Product product) {	
	ProductBusinessInterface productService = getProductService();
	productService.removeProduct(product.getId());
	
	System.out.println("successfuly deleted product: " + product.name);
	return "displayProducts.xhtml";
}

public String onEdit(Product product) {	
	//put the get value into the response page 
	FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("product", product);
	return "EditProductForm.xhtml";
}

public String onSubmitEdit() {
	//read the get value
	FacesContext context = FacesContext.getCurrentInstance();
	
	//store the get value
	Product product = context.getApplication().evaluateExpressionGet(context, "#{product}" , Product.class);
	
	//call the update method from product business service 
	ProductBusinessInterface productService = getProductService();
	productService.updateProduct(product.getId(), product);
	
	System.out.println("successfuly edited product: " + product.id);
	
	//put the get value into the response page 
	FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("product", product);
	
	return "displayProducts.xhtml";
}

}
