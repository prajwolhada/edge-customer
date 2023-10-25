package com.f1soft.bankxp.edge.customer.inquiry.service;

import com.f1soft.bankxp.edge.customer.dto.ServerResponse;

public interface CustomerInquiryService {

    ServerResponse customerInquiryById(Long customerId);

    ServerResponse customerInquiryByCustomerLoginId(Long customerLoginId);

    ServerResponse customerInquiryByUsername(String mobileNumber);

    ServerResponse customerInquiryByAccountNumber(String accountNumber);
}
