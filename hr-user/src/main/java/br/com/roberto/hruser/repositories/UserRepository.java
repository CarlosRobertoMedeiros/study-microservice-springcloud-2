package br.com.roberto.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.roberto.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//Query Methods 
	User findByEmail(String email);
}
