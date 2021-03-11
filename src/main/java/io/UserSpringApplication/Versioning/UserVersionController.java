package io.UserSpringApplication.Versioning;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserVersionController {
	
	@Autowired
	UserVersionService service;
	
	@GetMapping("/users/v1")
	public List<UserVersioning> getAllUserVersion1() {
		return service.getAllUserVersion1();
	}
	
	@GetMapping("/users/v2")
	public List<UserVersioning2> getAllUserVersion2() {
		return service.getAllUserVersion2();
	}
	
	@GetMapping(value = "/users", params = "version=1")
	public List<UserVersioning> getAllUserVersion1Params() {
		return service.getAllUserVersion1Params();
	}
	
	@GetMapping(value = "/users", params = "version=2")
	public List<UserVersioning2> getAllUserVersion2Params() {
		return service.getAllUserVersion2Params();
	}
	
	@GetMapping(value = "/users", headers = "X-API-VERSION=1")
	public List<UserVersioning> getAllUserVersion1headers() {
		return service.getAllUserVersion1headers();
	}
	
	@GetMapping(value = "/users", headers = "X-API-VERSION=2")
	public List<UserVersioning2> getAllUserVersion2headers() {
		return service.getAllUserVersion2headers();
	}
	
	@GetMapping(value = "/users", produces = "application/vnd.company.app-v1+json")
	public List<UserVersioning> getAllUserVersion1produces() {
		return service.getAllUserVersion1Produces();
	}
	
	@GetMapping(value = "/users", produces = "application/vnd.company.app-v2+json")
	public List<UserVersioning2> getAllUserVersion2Produces() {
		return service.getAllUserVersion2Produces();
	}
	
}
