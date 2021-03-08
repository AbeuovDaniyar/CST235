package controllers;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

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
	
public String onSubmit() {
	FacesContext context = FacesContext.getCurrentInstance();
	User user = context.getApplication().evaluateExpressionGet(context, "#{user}" , User.class);
	
	service.test();
	
	//start a timer 
	timer.setTimer(5000);
	
	FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
	return "TestResponse.xhtml";
}

public OrdersBusinessInterface getService() {
	return service;
}
}
