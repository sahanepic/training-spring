package net.epiclanka.training.mapper;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import net.epiclanka.training.model.CustomerBill;
import net.epiclanka.training.model.CustomerBillReq;
import net.epiclanka.training.utill.UtillLogger;
import net.epiclanka.training.utill.core.UtillBase64;
import net.epiclanka.training.utill.core.UtillEncryptDecrypt;

@Service
public class CustomerBillMapper {

	@Autowired
	private Environment env;
	
	 
	public CustomerBill	 customerbillRequestMapToObject(CustomerBillReq customerBillReq) {
		
		CustomerBill customerBill = new CustomerBill();
		customerBill.setBillId(customerBillReq.getBillId());
		customerBill.setCustomerName(customerBillReq.getCustomerName());
		customerBill.setCustomerMobileNo(customerBillReq.getCustomerMobileNo());
		customerBill.setCustomerEmail(customerBillReq.getCustomerEmail());
		customerBill.setPrice(customerBillReq.getPrice());
		String encdeckey = env.getProperty("encdeckey");
		String decodedcardno =UtillBase64.getDecodedString(customerBillReq.getCustomerCreditCardNo());
		String customerCardNo = UtillEncryptDecrypt.ThripleDESDecryption(encdeckey ,decodedcardno )  ;
		customerBill.setCustomerCreditCardNo(customerCardNo);
		 
		
		
		
		UtillLogger.logInfo(CustomerBillMapper.class,"The Customer Credit  "  +" Card No " + customerBill.getCustomerCreditCardNo()  );
		
		
		return customerBill;
	}
	
	
	
}
