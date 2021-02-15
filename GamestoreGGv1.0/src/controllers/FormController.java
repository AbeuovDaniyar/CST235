package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean
@ViewScoped
public class FormController {
	
public String onSubmit() {
	FacesContext context = FacesContext.getCurrentInstance();
	User user = context.getApplication().evaluateExpressionGet(context, "#{user}" , User.class);
	FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
	return "TestResponse.xhtml";
}

public String onRegister() {
	FacesContext context = FacesContext.getCurrentInstance();
	User newUser = context.getApplication().evaluateExpressionGet(context, "#{user}" , User.class);
	FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", newUser);
	return "RegisterResponse.xhtml";
}

public String onLogin(User user) {
	FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
	if(user.getUserName().contains("danny") && user.getPassword().contains("cst235")) {
		return "TestResponse.xhtml";
	}
	return "FailedLogin.xhtml";
}
}
