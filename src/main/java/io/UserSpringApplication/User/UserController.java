package io.UserSpringApplication.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.converter.json.MappingJacksonValue;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/")
	@ApiOperation(value = "get all the users",response = User.class)
	public MappingJacksonValue getAllUsers() {
		List<User> usersTemp =  userService.getAllUsers();
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name","address","phoneNumber","id");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("passwordfilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(usersTemp);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Find user by id",
	notes = "Provide an id to look up for a particular user",
	response = User.class)
	public EntityModel<User> getUser(@ApiParam(value = "Id value for the user you need to retrieve", required = true)  
	@PathVariable String id) {
		User user = userService.getUser(id);
		EntityModel<User> resource = EntityModel.of(user);
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
		resource.add(link.withRel("All Users"));
		return resource;
	}
	
	@GetMapping(value = "/withoutHateos/{id}")
	@ApiOperation(value = "Find the user by id",
	notes = "Find the user by id by dynamic filtering and not using hateos",
	response = User.class)
	public MappingJacksonValue getUserFilter(@ApiParam(value = "ID value for the user you need to retrieve", required = true)@PathVariable String id) {
		User user = userService.getUser(id);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name","address","phoneNumber","id");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("passwordfilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(user);
		System.out.println(mapping);
		mapping.setFilters(filters);
		return mapping;
	}
	
	@PostMapping(value = "/")
	@ApiOperation(value = "Add the user",
	notes = "Provide the user json format user object to add the user",
	response = User.class)
	public MappingJacksonValue addUser(@RequestBody User user) {
		User userTemp = userService.addUser(user);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name","address","phoneNumber","id");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("passwordfilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(userTemp);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@PutMapping(value = "/{id}")
	@ApiOperation(value = "Update the user by id",
	notes = "Provide the user id and json format user object to update the user",
	response = User.class)
	public User updateUser(@RequestBody User user,@PathVariable String id) {
		return userService.updateUser(user,id);
	}
	
	@DeleteMapping(value = "/{id}")
	@ApiOperation(value = "Delete the user by id",
	notes = "Provide the user id to delete the user")
	public MappingJacksonValue deleteUser(@PathVariable String id) {
		User user = userService.deleteUser(id);
SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name","address","phoneNumber","id");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("passwordfilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(user);
		mapping.setFilters(filters);
		
		return mapping;
	}

}
