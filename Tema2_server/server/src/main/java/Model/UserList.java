package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<User> users = new ArrayList<User>();

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users1) {
		users = users1;
	}
	
	public void addUser(User user) {
		users.add(user);
	}

}
