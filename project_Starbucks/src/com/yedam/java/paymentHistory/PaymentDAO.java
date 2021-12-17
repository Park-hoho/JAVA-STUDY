package com.yedam.java.paymentHistory;

import java.util.List;

import com.yedam.java.app.customer.Customer;

public interface PaymentDAO {
	
	//전체조회(M)
	List<Payment> selectAll();
	
	//단건조회(M)
	Payment selectOne(int paymentId);
	
	//결제 내역 입력(M, C)
	void insert(Payment payment);
	
	//전체 상세 조회(M)
	void showDetailPaymentHistory();
	
	//본인 결제 정보 조회 (C)
	void showCustomerPaymentHistory(Customer customer);
}
