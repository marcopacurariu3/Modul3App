package com.application.modul3.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<UserDB> getAllUsers() {
		return userRepository.findAll();
	}

	public UserDB createUser(UserDB user) {
		return userRepository.saveAndFlush(user);
	}

	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}

	public UserDB updateUser(UserDB userToUpdate) {
		UserDB userFromDb = userRepository.getById(userToUpdate.getId());
		userFromDb.setFirstName(userToUpdate.getFirstName());
		userFromDb.setLastName(userToUpdate.getLastName());
		userFromDb.setPassword(userToUpdate.getPassword());
		userFromDb.setEmail(userToUpdate.getEmail());
		userRepository.flush();
		return userFromDb;
	}

	public Optional<UserDB> getUserById(Integer id) {
		return userRepository.findById(id);
	}
}
