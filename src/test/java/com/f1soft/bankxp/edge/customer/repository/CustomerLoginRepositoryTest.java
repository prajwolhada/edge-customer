package com.f1soft.bankxp.edge.customer.repository;

import com.flsoft.bankxp.edge.entities.model.CustomerLogin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import utilities.CustomerLoginMockUtil;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CustomerLoginRepositoryTest {

    @Mock
    private CustomerLoginRepository customerLoginRepository;

    @Test
    public void findByIdTest() {

        when(customerLoginRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(CustomerLoginMockUtil.mockCustomerLogin()));

        Optional<CustomerLogin> customerLoginOptional = customerLoginRepository.findById(1L);

        assertTrue(customerLoginOptional.isPresent());

    }

    @Test
    public void findCustomerLoginByUsernameTest() {

        when(customerLoginRepository.findCustomerLoginByUsername(any(String.class))).thenReturn(Optional.ofNullable(CustomerLoginMockUtil.mockCustomerLogin()));

        Optional<CustomerLogin> customerLoginOptional = customerLoginRepository.findCustomerLoginByUsername("9860465427");

        assertTrue(customerLoginOptional.isPresent());

    }
}
