package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.User;

@Stateless
@Local(UsersBusinessInterface.class)
@Alternative
public class UserBusinessService implements UsersBusinessInterface{
	
	List<User> users = new ArrayList<User>();
	
	public UserBusinessService() {
		
	}
	
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		users.add(user);
		return "RegisterResponse.xhtml";
	}

	@Override
	public String login(User user) {
		// TODO Auto-generated method stub
		if(user.getUserName() == null || user.getPassword() == null) {
			return "loginFailed.xhtml";
		}
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUserName().contains(user.getUserName()) && users.get(i).getPassword().contains(user.getPassword())) {
				System.out.println("Logged in successfuly!");
				return "TestResponse.xhtml";
			}
		}
		return "FailedLogin.xhtml";
	}

}
