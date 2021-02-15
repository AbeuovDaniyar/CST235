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
}
