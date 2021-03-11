package io.UserSpringApplication.Versioning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import io.UserSpringApplication.User.User;

@Service
public class UserVersionService {
	
	List<UserVersioning> users = new ArrayList<>(Arrays.asList(
			new UserVersioning("adarsh","Adarsh","janakpuri","9582906116","Adarsh123"),
			new UserVersioning("suraj","Suraj","Gurgaon","9582906115","Suraj123")
			));
	
	List<UserVersioning2> users2 = new ArrayList<>(Arrays.asList(
			new UserVersioning2("Adarsh"),
			new UserVersioning2("Suraj")
			));
	
	public List<UserVersioning> getAllUserVersion1() {
		return users;
	}
	
	public List<UserVersioning2> getAllUserVersion2() {
		return users2;
	}

	public List<UserVersioning> getAllUserVersion1Params() {
		return users;
	}

	public List<UserVersioning2> getAllUserVersion2Params() {
		return users2;
	}

	public List<UserVersioning> getAllUserVersion1headers() {
		return users;
	}

	public List<UserVersioning2> getAllUserVersion2headers() {
		return users2;
	}

	public List<UserVersioning> getAllUserVersion1Produces() {
		return users;
	}

	public List<UserVersioning2> getAllUserVersion2Produces() {
		return users2;
	}
	
	
}
