package net.epiclanka.training.controllers;

 
 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.epiclanka.training.model.CustomerBillReq;
import net.epiclanka.training.model.CustomerBillRes;
import net.epiclanka.training.service.implement.CustomerPaymentServiceImplement;
import net.epiclanka.training.utill.EndPoints;

@RestController
@RequestMapping(value = EndPoints.paymentControllerValue)
public class BakeryBillController {

	
	@Autowired
	private CustomerPaymentServiceImplement customerPaymentService;
	
	@GetMapping
	public String welcome() {
		return "welcome Payment Controller";
	}
	
	
	@PostMapping(value = EndPoints.paymentCustomerHandlerEndpoint , consumes =MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<CustomerBillRes> customerPayment(@Valid @RequestBody CustomerBillReq customerBillReq ) {	
		
		return   customerPaymentService.customerPeymentHandle();
	}
	
	
	
}
