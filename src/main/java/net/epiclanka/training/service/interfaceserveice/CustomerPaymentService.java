package net.epiclanka.training.service.interfaceserveice;

import org.springframework.http.ResponseEntity;

import net.epiclanka.training.model.CustomerBillRes;

public interface CustomerPaymentService {
	
	public ResponseEntity<CustomerBillRes> customerPeymentHandle() ;

}
