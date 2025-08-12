package me.dio.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;

@Service
public class UserServoceImpl implements UserService {
	
	
	private final UserRepository userRepository;
	
	public UserServoceImpl (UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findBydId(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public User create(User userToCreate) {
		// TODO Auto-generated method stub
		if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
			throw new IllegalArgumentException("This Account number already exists");
		}
		
		return  userRepository.save(userToCreate);
	}

}
