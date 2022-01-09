package com.application.modul3.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDB, Integer> {
	Optional<UserDB> findByEmail(String email);
}
