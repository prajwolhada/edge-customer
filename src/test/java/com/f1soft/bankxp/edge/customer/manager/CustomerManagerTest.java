package com.f1soft.bankxp.edge.customer.manager;

import com.f1soft.bankxp.edge.customer.exception.EntityNotFoundException;
import com.f1soft.bankxp.edge.customer.repository.BankAccountRepository;
import com.f1soft.bankxp.edge.customer.repository.CustomerLoginRepository;
import com.f1soft.bankxp.edge.customer.repository.CustomerRepository;
import com.flsoft.bankxp.edge.entities.model.CustomerLogin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import utilities.BankAccountMockUtil;
import utilities.CustomerLoginMockUtil;
import utilities.CustomerMockUtil;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CustomerManagerTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerLoginRepository customerLoginRepository;

    @Mock
    private BankAccountRepository bankAccountRepository;

    @InjectMocks
    private CustomerManager customerManager;

    @Test
    public void findCustomerLoginByUsernameTest() {
        when(customerLoginRepository.findCustomerLoginByUsername("9860465427"))
                .thenReturn(Optional.ofNullable(CustomerLoginMockUtil.mockCustomerLogin()));
        when(customerLoginRepository.findCustomerLoginByUsername("9860465429"))
                .thenReturn(Optional.empty());

        assertAll("Testing customerLogin by username",
                () -> assertNotNull(customerManager.findCustomerLoginByUsername("9860465427")),
                () -> assertThrows(EntityNotFoundException.class, () -> customerManager.findCustomerLoginByUsername("9860465429")));
    }

    @Test
    public void findCustomerLoginByIdTest() {
        when(customerLoginRepository.findById(1L))
                .thenReturn(Optional.ofNullable(CustomerLoginMockUtil.mockCustomerLogin()));
        when(customerLoginRepository.findById(2L))
                .thenReturn(Optional.empty());

        assertAll("Testing customerLogin by Id",
                () -> assertNotNull(customerManager.findCustomerLoginById(1L)),
                () -> assertThrows(EntityNotFoundException.class, () -> customerManager.findCustomerLoginById(2L)));
    }

    @Test
    public void findCustomerByIdTest() {
        CustomerLogin customerLogin = CustomerLoginMockUtil.mockCustomerLogin();
        when(customerRepository.findById(1L))
                .thenReturn(Optional.ofNullable(CustomerMockUtil.mockCustomer(customerLogin)));
        when(customerRepository.findById(2L))
                .thenReturn(Optional.empty());

        assertAll("Testing customer by Id",
                () -> assertNotNull(customerManager.findCustomerById(1L)),
                () -> assertThrows(EntityNotFoundException.class, () -> customerManager.findCustomerById(2L)));
    }

    @Test
    public void findPrimaryBankAccountByAccountNumberTest() {
        when(bankAccountRepository.findByAccountNumber("123456789"))
                .thenReturn(Optional.ofNullable(BankAccountMockUtil.mockBankAccount()));
        when(bankAccountRepository.findByAccountNumber("987654321"))
                .thenReturn(Optional.empty());

        assertAll("Testing customerLogin by username",
                () -> assertNotNull(customerManager.findPrimaryBankAccountByAccountNumber("123456789")),
                () -> assertThrows(EntityNotFoundException.class, () -> customerManager.findPrimaryBankAccountByAccountNumber("987654321")));
    }
}
