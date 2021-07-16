package net.epiclanka.training.service.implement;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.epiclanka.training.model.CustomerBill;
import net.epiclanka.training.model.CustomerBillHistory;
import net.epiclanka.training.model.CustomerBillRes;
import net.epiclanka.training.repos.CustomerBillRepository;
import net.epiclanka.training.service.interfaceserveice.CustomerPaymentService;
import net.epiclanka.training.utill.UtillLogger;

@Service
public class CustomerPaymentServiceImplement implements CustomerPaymentService {

	@Autowired
	private CustomerBillRepository customerBillRepository;

	public ResponseEntity<CustomerBillRes> customerPeymentHandle(CustomerBill customerBill) {
		CustomerBillRes customerBillRes = new CustomerBillRes();
		customerBillRes.setBillID(customerBillRepository.save(customerBill).getBillId());
		customerBillRes.setMessage("Thank Sir, Be Safe ");
		customerBillRes.setPaymentStatus("completed");
		return new ResponseEntity<>(customerBillRes, HttpStatus.OK);
	}

	// create an error object

	public ResponseEntity<CustomerBillHistory> customerPeymentHistoryHandle() {

		List<CustomerBill> coutomers = (List<CustomerBill>) customerBillRepository.findAll();
		Iterator<CustomerBill> itr = coutomers.iterator();
		while (itr.hasNext()) {
			CustomerBill customerBill = itr.next();
			UtillLogger.logInfo(CustomerPaymentService.class, customerBill.getBillId());
		}
		CustomerBillHistory customerBillHistory = new CustomerBillHistory();
		customerBillHistory.setPaymentcount(coutomers.size());

//		 String jsonCustomer = new Gson().toJson(coutomers);
//		 UtillLogger.logInfo(CustomerPaymentService.class, jsonCustomer);
//		 customerBillHistory.setEncodedCustomerHistory(jsonCustomer);
		return new ResponseEntity<CustomerBillHistory>(customerBillHistory, HttpStatus.OK);
	}

}
