package me.dio.service;

import me.dio.domain.model.User;

public interface UserService {
	
	User findBydId(Long id);
	
	User create(User userToCreate);
	
	
}
