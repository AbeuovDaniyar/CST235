package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@ViewScoped
public class Product {
@NotNull(message = "Please enter Product Name. This is a required field.")
@Size(min=4, max=15, message = "Product Name must be at least 4 letters long and less then 15 letters long")	
public String name = "";
@NotNull(message = "Please enter Product Description. This is a required field.")
@Size(min=4, max=15, message = "Product Description must be at least 4 letters long and less then 15 letters long")	
public String description = "";
@NotNull(message = "Please enter Publisher name. This is a required field.")
@Size(min=4, max=15, message = "Publisher name must be at least 4 letters long and less then 15 letters long")	
public String publisher = "";
@NotNull(message = "Please enter Developer studio name. This is a required field.")
@Size(min=4, max=15, message = "Developer studio must be at least 4 letters long and less then 15 letters long")	
public String developer = "";
@NotNull(message = "Please enter Supported Platform name/s. This is a required field.")
@Size(min=4, max=15, message = "Supported Platform must be at least 4 letters long and less then 15 letters long")	
public String platform = "";
@NotNull(message = "Please enter Product price. This is a required field.")	
public double price = 0.00;

public Product(String name, String description, String publisher, String developer, String platform, double price) {
	this.name = name;
	this.description = description;
	this.developer = developer;
	this.publisher = publisher;
	this.platform = platform;
	this.price = price;
}

public Product() {
	this.name = "";
	this.description = "";
	this.developer = "";
	this.publisher = "";
	this.platform = "";
	this.price = 0.00;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public String getDeveloper() {
	return developer;
}
public void setDeveloper(String developer) {
	this.developer = developer;
}
public String getPlatform() {
	return platform;
}
public void setPlatform(String platform) {
	this.platform = platform;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}


}
