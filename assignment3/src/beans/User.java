package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class User {
	//@NotNull(message = "Please enter a First Name. This is a required field.")
	//@Size(min=4, max=15)
	String firstName = "";
	
	//@NotNull(message = "Please enter a Last Name. This is a required field.")
	//@Size(min=4, max=15)
	String lastName = "";

	public User() {
		this.firstName = "Daniyar";
		this.lastName = "Abeuov";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


}
