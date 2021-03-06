package net.epiclanka.training.model;

 
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import net.epiclanka.training.utill.RegxStrings;

public class CustomerBillReq {
	

	@NotBlank 
	private String billId;
	@DecimalMin("200.0")
	private double price;
	@NotBlank
	@Pattern(regexp = RegxStrings.nameValidateRegx , message = "INVALID Name" )
	private String customerName;
	@NotBlank
	@Pattern(regexp = RegxStrings.emailValidateRegx , message = "INVALID Email")
	private String customerEmail;
	@NotBlank
	@Pattern(regexp = RegxStrings.phoneValidateRegx ,message = "Invalid Mobile No")
	private String customerMobileNo;
	@NotBlank
	@Pattern( regexp = RegxStrings.base64ValidateRegx , message = "Base64 Encoding Of Card No is Wrong ")
	private String customerCreditCardNo;
	
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerMobileNo() {
		return customerMobileNo;
	}
	public void setCustomerMobileNo(String customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}
	public String getCustomerCreditCardNo() {
		return customerCreditCardNo;
	}
	public void setCustomerCreditCardNo(String customerCreditCardNo) {
		this.customerCreditCardNo = customerCreditCardNo;
	}
	
}
