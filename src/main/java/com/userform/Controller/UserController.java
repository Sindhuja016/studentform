package com.userform.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.userform.dto.UserDto;

import com.userform.service.UserService;



@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public UserDto create(@RequestBody UserDto userdto) {
		return userService.create(userdto);
	}
	
	@PostMapping("/createmore")
	public List<UserDto> createMore(@RequestBody List<UserDto> userdto) {
		return userService.createMore(userdto);
	}

	
	@GetMapping("/getbyname")	
	public UserDto getByName(@RequestParam String name) {
		return userService.getUserByName(name);
	}
	
	@GetMapping("/getbyid/{Id}")
	public UserDto getUserById(@PathVariable Long Id) throws Exception {
		return userService.getUserById(Id);
	}
	
	@GetMapping("/getall")
	public List<UserDto> getAllUser(){
		return userService.getAllUsers();
	}
	
	@PutMapping("/update/{Id}")
	public UserDto updateUser(@RequestBody UserDto dto,@PathVariable("Id") Long userid) {
		return userService.updateUser(dto,userid);
		
	}
    
	@DeleteMapping("/delete/{Id}")
	public void deleteUser(@PathVariable Long Id) {
		userService.deleteUser(Id);
	}
	
	
	
	
	
}