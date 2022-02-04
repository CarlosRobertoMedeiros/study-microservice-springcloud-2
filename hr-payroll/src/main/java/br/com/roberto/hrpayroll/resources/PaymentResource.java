package br.com.roberto.hrpayroll.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.roberto.hrpayroll.entities.Payment;
import br.com.roberto.hrpayroll.services.PaymentServices;
import br.com.roberto.hrpayroll.to.FalhaDeComunicacao;
import io.github.resilience4j.retry.annotation.Retry;

@EnableEurekaClient
@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
	
	private Logger logger = LoggerFactory.getLogger(PaymentResource.class);
	
	private static Byte valor = 0;
	
	@Value("${resilience4j.retry.instances.default.max-attempts}")
	private Byte qtdeMaxTentativas;
	
	@Autowired
	private PaymentServices paymentServices;
	
	@GetMapping(value = "/{workerId}/days/{days}")
	@Retry(name = "default", fallbackMethod = "getPaymentFallBack")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, 
											  @PathVariable Integer days ){
		Payment payment = paymentServices.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}
	
	public ResponseEntity<FalhaDeComunicacao> getPaymentFallBack(Long workerId, 
			  										  Integer days, 
			  										  Exception ex ) {
		FalhaDeComunicacao falhaDeComunicacao = new FalhaDeComunicacao("Falha de Comunicação", 
													"Após "+ qtdeMaxTentativas + " tentativas, não foi possível conectar na instância de pagamentos "
													+ "para recuperar os dados do worker "+ workerId
													+ " tente novamente mais tarde ...");
		
		
		return ResponseEntity.status(HttpStatus.OK).body(falhaDeComunicacao);
	}
	

}
