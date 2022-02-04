package br.com.roberto.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.roberto.hrpayroll.entities.Payment;
import br.com.roberto.hrpayroll.services.PaymentServices;

@EnableEurekaClient
@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
	
	@Autowired
	private PaymentServices paymentServices;
	
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, 
											  @PathVariable Integer days ){
		Payment payment = paymentServices.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}
	
	

}
