package com.application.modul3.user;

import org.springframework.stereotype.Service;

@Service
public class UserMapper {
	public UserDB user2UserDB(User user) {
		UserDB userDB = new UserDB();
		userDB.setFirstName(user.getFirstName());
		userDB.setLastName(user.getLastName());
		userDB.setEmail(user.getEmail());
		userDB.setPassword(user.getPassword());
		userDB.setAge(user.getAge());
		return userDB;
	}

	public User userDB2User(UserDB userDB) {
		User user = new User();
		user.setId(userDB.getId());
		user.setFirstName(userDB.getFirstName());
		user.setLastName(userDB.getLastName());
		user.setEmail(userDB.getEmail());
		user.setPassword(userDB.getPassword());
		user.setAge(userDB.getAge());
		return user;
	}
}
