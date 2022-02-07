package br.com.roberto.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.roberto.hroauth.feignClient.UserFeighClient;
import br.com.roberto.hroauth.to.User;

@Service
public class UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeighClient userFeighClient;
	
	public User findByEmail(String email) {
		User user = userFeighClient.findByEmail(email).getBody();
		if(user==null) {
			logger.error("Email not found "+email);
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("Email found "+email);
		return user;
		
	}
	
	
	

}
