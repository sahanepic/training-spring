package net.epiclanka.training.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.epiclanka.training.model.CustomerBillRes;
import net.epiclanka.training.service.interfaceserveice.CustomerPaymentService;

@Service
public class CustomerPaymentServiceImplement implements CustomerPaymentService {

	
	public ResponseEntity<CustomerBillRes> customerPeymentHandle() {
		
		CustomerBillRes customerBillRes = new CustomerBillRes();
		customerBillRes.setBillID("123432");
		customerBillRes.setMessage("Thank Sir, Be Safe ");
		customerBillRes.setPaymentStatus("completed");
		return new  ResponseEntity<>( customerBillRes, HttpStatus.OK);
	}
	
	
	
}
