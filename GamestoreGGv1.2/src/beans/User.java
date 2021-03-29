package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@ViewScoped
public class User {
	@NotNull(message = "Please enter a First Name. This is a required field.")
	@Size(min=4, max=15, message = "First Name must be at least 4 letters long and less then 15 letters long")
	String firstName = "";
	
	@NotNull(message = "Please enter a Last Name. This is a required field.")
	@Size(min=4, max=20, message = "Last Name must be at least 4 letters long and less then 20 letters long")
	String lastName = "";
	
	@NotNull(message = "Please enter a email. This is a required field.")
	@Size(min=4, max=40, message = "Email must be at least 4 letters long and less then 40 letters long")
	String email = "";
	
	@NotNull(message = "Please enter a Username. This is a required field.")
	@Size(min=4, max=20, message = "Username must be at least 4 letters long and less then 20 letters long")
	String userName = "";
	
	@NotNull(message = "Please enter a Password. This is a required field.")
	@Size(min=4, max=20, message = "Password must be at least 4 letters long and less then 20 letters long")
	String password = "";
	
	@NotNull(message = "Please enter a Phone Number. This is a required field.")
	@Size(min=5, max=20 , message = "Phone number must be 10 digits")
	String phoneNumber = "";
	
	@NotNull(message = "Please enter your Address. This is a required field.")
	@Size(min=4, max=40, message = "Address must be at least 4 letters long and less then 40 letters long")
	String address = "";
	
	public User(String firstName, String lastName, String email, String userName, String password, String phoneNumber, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public User() {
		this.firstName = "Daniyar";
		this.lastName = "Abeuov";
		this.email = "danny@gmail.com";
		this.userName = "danny";
		this.password = "cst123";
		this.phoneNumber = "6232652825";
		this.address = "Camelback rd";
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}
