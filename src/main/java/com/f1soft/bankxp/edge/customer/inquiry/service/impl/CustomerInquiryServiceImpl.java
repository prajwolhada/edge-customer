package com.f1soft.bankxp.edge.customer.inquiry.service.impl;

import com.f1soft.bankxp.edge.customer.dto.ServerResponse;
import com.f1soft.bankxp.edge.customer.inquiry.dto.CustomerDetailResponse;
import com.f1soft.bankxp.edge.customer.inquiry.mapper.CustomerDetailMapper;
import com.f1soft.bankxp.edge.customer.inquiry.service.CustomerInquiryService;
import com.f1soft.bankxp.edge.customer.manager.CustomerManager;
import com.f1soft.bankxp.edge.customer.util.ResponseMsg;
import com.flsoft.bankxp.edge.entities.model.BankAccount;
import com.flsoft.bankxp.edge.entities.model.Customer;
import com.flsoft.bankxp.edge.entities.model.CustomerLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerInquiryServiceImpl implements CustomerInquiryService {

    @Autowired
    private CustomerManager customerManager;

    @Override
    public ServerResponse customerInquiryById(Long customerId) {
        Customer customer = customerManager.findCustomerById(customerId);
        CustomerLogin customerLogin = customer.getCustomerLoginList().get(0);

        CustomerDetailResponse customerDetailResponse = CustomerDetailMapper.mapToCustomerDetailResponse(customerLogin);

        return ResponseMsg.successResponse(customerDetailResponse, "Data Fetched Successfully.");
    }

    @Override
    public ServerResponse customerInquiryByCustomerLoginId(Long customerLoginId) {
        CustomerLogin customerLogin = customerManager.findCustomerLoginById(customerLoginId);

        CustomerDetailResponse customerDetailResponse = CustomerDetailMapper.mapToCustomerDetailResponse(customerLogin);

        return ResponseMsg.successResponse(customerDetailResponse, "Data Fetched Successfully.");
    }

    @Override
    public ServerResponse customerInquiryByUsername(String username) {
        CustomerLogin customerLogin = customerManager.findCustomerLoginByUsername(username);

        CustomerDetailResponse customerDetailResponse = CustomerDetailMapper.mapToCustomerDetailResponse(customerLogin);

        return ResponseMsg.successResponse(customerDetailResponse, "Data Fetched Successfully.");
    }

    @Override
    public ServerResponse customerInquiryByAccountNumber(String accountNumber) {
        BankAccount bankAccount = customerManager.findPrimaryBankAccountByAccountNumber(accountNumber);

        Customer customer = bankAccount.getCustomer();
        CustomerLogin customerLogin = customer.getCustomerLoginList().get(0);

        CustomerDetailResponse customerDetailResponse = CustomerDetailMapper.mapToCustomerDetailResponse(customerLogin);

        return ResponseMsg.successResponse(customerDetailResponse, "Data Fetched Successfully.");
    }
}
