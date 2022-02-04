package br.com.roberto.hrpayroll.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.roberto.hrpayroll.response.Worker;

@Component
@FeignClient(name="hr-worker" , url="localhost:8001", path = "/workers")
public interface WorkerFeignClient {
	
	@GetMapping
	ResponseEntity<List<Worker>> findAll();
	
	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id); 
	
}
