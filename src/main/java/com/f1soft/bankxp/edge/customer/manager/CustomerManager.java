package com.f1soft.bankxp.edge.customer.manager;

import com.f1soft.bankxp.edge.customer.constant.MsgConstant;
import com.f1soft.bankxp.edge.customer.exception.EntityNotFoundException;
import com.f1soft.bankxp.edge.customer.repository.BankAccountRepository;
import com.f1soft.bankxp.edge.customer.repository.CustomerLoginRepository;
import com.f1soft.bankxp.edge.customer.repository.CustomerRepository;
import com.f1soft.bankxp.edge.customer.util.ResponseMsg;
import com.flsoft.bankxp.edge.entities.model.BankAccount;
import com.flsoft.bankxp.edge.entities.model.Customer;
import com.flsoft.bankxp.edge.entities.model.CustomerLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class CustomerManager {

    @Autowired
    private CustomerLoginRepository customerLoginRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerLogin findCustomerLoginByUsername(String username) throws EntityNotFoundException {
        Optional<CustomerLogin> customerLoginOptional = customerLoginRepository.findCustomerLoginByUsername(username);
        return customerLoginOptional
                .orElseThrow(() -> new EntityNotFoundException(ResponseMsg.failurePlainResponse(MsgConstant.CUSTOMER_NOT_FOUND)));
    }

    public CustomerLogin findCustomerLoginById(Long customerLoginId) throws EntityNotFoundException {
        Optional<CustomerLogin> customerLoginOptional = customerLoginRepository.findById(customerLoginId);
        return customerLoginOptional
                .orElseThrow(() -> new EntityNotFoundException(ResponseMsg.failurePlainResponse(MsgConstant.CUSTOMER_NOT_FOUND)));
    }

    public Customer findCustomerById(Long customerId) throws EntityNotFoundException {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        return customerOptional
                .orElseThrow(() -> new EntityNotFoundException(ResponseMsg.failurePlainResponse(MsgConstant.CUSTOMER_NOT_FOUND)));
    }

    public BankAccount findPrimaryBankAccountByAccountNumber(String accountNumber) {
        Optional<BankAccount> bankAccountOptional = bankAccountRepository.findByAccountNumber(accountNumber);
        return bankAccountOptional
                .orElseThrow(() -> new EntityNotFoundException(ResponseMsg.failurePlainResponse(MsgConstant.BANK_ACCOUNT_NOT_FOUND)));
    }
}
