package br.com.roberto.hrpayroll.services;

import org.springframework.stereotype.Service;

import br.com.roberto.hrpayroll.entities.Payment;

@Service
public class PaymentServices {
	
	public Payment getPayment(Long workerId, int days) {
		return new Payment("Bob", 200.0, days);
	}

}
