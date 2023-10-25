package com.f1soft.bankxp.edge.customer.controller;

import com.f1soft.bankxp.edge.customer.dto.ServerResponse;
import com.f1soft.bankxp.edge.customer.inquiry.service.CustomerInquiryService;
import com.f1soft.bankxp.edge.customer.util.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("inquiry")
public class CustomerInquiryController {

    @Autowired
    private CustomerInquiryService customerInquiryService;


    @GetMapping(value = "customer-id/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> customerEnquiryUsingCustomerId(@PathVariable("customerId") Long customerId) {
        ServerResponse serverResponse = customerInquiryService.customerInquiryById(customerId);
        return ResponseBuilder.response(serverResponse);
    }

    @GetMapping(value = "customerlogin-id/{customerLoginId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> customerEnquiryUsingCustomerLoginId(@PathVariable("customerLoginId") Long customerLoginId) {
        ServerResponse serverResponse = customerInquiryService.customerInquiryByCustomerLoginId(customerLoginId);
        return ResponseBuilder.response(serverResponse);
    }

    @GetMapping(value = "mobile-number/{mobileNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> customerEnquiryUsingMobile(@PathVariable("mobileNumber") String mobileNumber) {
        ServerResponse serverResponse = customerInquiryService.customerInquiryByUsername(mobileNumber);
        return ResponseBuilder.response(serverResponse);
    }

    @GetMapping(value = "account-number/{accountNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> customerEnquiryUsingAccountNumber(@PathVariable("accountNumber") String accountNumber) {
        ServerResponse serverResponse = customerInquiryService.customerInquiryByAccountNumber(accountNumber);
        return ResponseBuilder.response(serverResponse);
    }
}
