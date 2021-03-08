package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

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

}
