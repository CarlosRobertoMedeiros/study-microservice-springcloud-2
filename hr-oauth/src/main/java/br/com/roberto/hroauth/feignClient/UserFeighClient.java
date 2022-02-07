package br.com.roberto.hroauth.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.roberto.hroauth.to.User;

@Component
@FeignClient(name = "hr-user", path = "users")
public interface UserFeighClient {
	
	@GetMapping(value = "/search")
	ResponseEntity<User> findByEmail(@RequestParam String email);

}
