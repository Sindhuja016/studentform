package com.userform.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.userform.Entity.User;
import com.userform.dto.UserDto;
import com.userform.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	public UserDto create(UserDto userdto) {
		User u=new User();
		u.setName(userdto.getName());
		u.setPassword(userdto.getPassword());
		u.setEmail(userdto.getEmail());
		User us= userRepo.save(u);
		
		UserDto dto=new UserDto();	
		dto.setId(us.getId());
		dto.setName(us.getName());
		dto.setPassword(us.getPassword());
		dto.setEmail(us.getEmail());
		
		return dto;
	}
	
	public List<UserDto> createMore(List<UserDto> userDtos) {
	    List<UserDto> dt = new ArrayList<>();
	    
	    for (UserDto userDto : userDtos) {
	        User user = new User();
	        user.setName(userDto.getName());
	        user.setPassword(userDto.getPassword());
	        user.setEmail(userDto.getEmail());
	        
	        User u = userRepo.save(user);
	        
	        UserDto dto = new UserDto();
	        
	        dto.setId(u.getId());
	        dto.setName(u.getName());
	        dto.setPassword(u.getPassword());
	        dto.setEmail(u.getEmail());

	        dt.add(dto);
	    }
	    
	    return dt;
	}


	
	public UserDto getUserByName(String name) {
		User user=userRepo.findByName(name);
		
		UserDto dto=new UserDto();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setPassword(user.getPassword());
		dto.setEmail(user.getEmail());
		return dto;
	}
	
	public UserDto getUserById(Long Id) throws Exception {
		Optional<User> us=userRepo.findById(Id);
		
		if(us.isPresent()) {
		User user=us.get();
		UserDto dto=new UserDto();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setPassword(user.getPassword());
		dto.setEmail(user.getEmail());
		return dto;
		}
		else {
		    throw new Exception("User with ID " + Id + " not found");
		}
	}
	public List<UserDto> getAllUsers(){
		List<User> users=userRepo.findAll();
		List<UserDto> dt = new ArrayList<>();
		
		for(User user:users) {
			UserDto dto=new UserDto();
			dto.setId(user.getId());
			dto.setName(user.getName());
			dto.setPassword(user.getPassword());
			dto.setEmail(user.getEmail());
			dt.add(dto);
		}
		return dt;
	}

	public UserDto updateUser(UserDto dto, Long userid) {
		Optional<User> user=userRepo.findById(userid);
		User us=user.get();
		
		us.setName(dto.getName());
		us.setPassword(dto.getPassword());
		us.setEmail(dto.getEmail());
		User u=userRepo.save(us);
		
		UserDto dt=new UserDto();
		dt.setId(u.getId());
		dt.setName(u.getName());
		dt.setPassword(u.getPassword());
		dt.setEmail(u.getEmail());
		
		return dt;
		
		
	}

	public void deleteUser(Long Id) {
		userRepo.deleteById(Id);
		
	}


}