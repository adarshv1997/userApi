package io.UserSpringApplication.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	List<User> users = new ArrayList<>(Arrays.asList(
			new User("adarsh","Adarsh","janakpuri","9582906116","Adarsh123"),
			new User("suraj","Suraj","Gurgaon","9582906115","Suraj123")
			));
	
	public List<User> getAllUsers() {
		return users;
	}
	
	public User getUser(String id) {
		return users.stream()
						.filter(user -> user.getId().equals(id))
						.findFirst()
						.get();
	}
	
	public User addUser(User user) {
		users.add(user);
		return user;
	}
	
	public User updateUser(User user, String id) {
		for(int i=0; i<users.size(); i++) {
			User tempUser = users.get(i);
			if(tempUser.getId().equals(id)) {
				users.set(i, user);
				return user;
			}
		}
		return null;
	}
	
	public User deleteUser(String id) {
		User userTemp = users.stream().filter(user -> user.getId().equals(id)).findFirst().get();
		users.removeIf(user -> user.getId().equals(id));
		return userTemp;
	}
			
}
