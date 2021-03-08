package business;

import java.util.List;

import javax.ejb.Local;

import beans.User;

@Local
public interface UsersBusinessInterface {
	public List<User> getUsers();
	public String addUser(User user);
	public String login(User user);
}
