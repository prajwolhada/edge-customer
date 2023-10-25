package com.f1soft.bankxp.edge.customer.service;

import com.f1soft.bankxp.edge.customer.constant.ErrorCodeEnum;
import com.f1soft.bankxp.edge.customer.constant.MsgConstant;
import com.f1soft.bankxp.edge.customer.dto.ServerResponse;
import com.f1soft.bankxp.edge.customer.exception.EntityNotFoundException;
import com.f1soft.bankxp.edge.customer.inquiry.service.impl.CustomerInquiryServiceImpl;
import com.f1soft.bankxp.edge.customer.manager.CustomerManager;
import com.f1soft.bankxp.edge.customer.util.ResponseMsg;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CustomerInquiryServiceTest {

    @Mock
    private CustomerManager customerManager;

    @InjectMocks
    private CustomerInquiryServiceImpl customerInquiryService;

    @Test
    public void customerInquiryByIdTest() {
        CustomerLogin customerLogin = CustomerLoginMockUtil.mockCustomerLogin();

        when(customerManager.findCustomerById(1L))
                .thenReturn(CustomerMockUtil.mockCustomer(customerLogin));
        doThrow(new EntityNotFoundException(ResponseMsg.failurePlainResponse(MsgConstant.CUSTOMER_NOT_FOUND)))
                .when(customerManager).findCustomerById(2L);


        ServerResponse serverResponse = customerInquiryService.customerInquiryById(1L);

        assertTrue(serverResponse.isSuccess());
        assertNotNull(serverResponse.getObj());
        assertNotNull(serverResponse.getMessage());
        assertNotNull(serverResponse.getCode());
        assertEquals(ErrorCodeEnum.SUCCESS.getCode(), serverResponse.getCode());

        assertThrows(EntityNotFoundException.class, () -> {
            customerInquiryService.customerInquiryById(2L);
        });

        verify(customerManager, times(2)).findCustomerById(any(Long.class));
    }

    @Test
    public void customerInquiryByCustomerLoginIdTest() {
        when(customerManager.findCustomerLoginById(1L))
                .thenReturn(CustomerLoginMockUtil.mockCustomerLogin());
        doThrow(new EntityNotFoundException(ResponseMsg.failurePlainResponse(MsgConstant.CUSTOMER_NOT_FOUND)))
                .when(customerManager).findCustomerLoginById(2L);

        ServerResponse serverResponse = customerInquiryService.customerInquiryByCustomerLoginId(1L);

        assertTrue(serverResponse.isSuccess());
        assertNotNull(serverResponse.getObj());
        assertNotNull(serverResponse.getMessage());
        assertNotNull(serverResponse.getCode());
        assertEquals(ErrorCodeEnum.SUCCESS.getCode(), serverResponse.getCode());

        assertThrows(EntityNotFoundException.class, () -> {
            customerInquiryService.customerInquiryByCustomerLoginId(2L);
        });

        verify(customerManager, times(2)).findCustomerLoginById(any(Long.class));
    }

    @Test
    public void customerInquiryByUsernameTest() {
        when(customerManager.findCustomerLoginByUsername("9860465427"))
                .thenReturn(CustomerLoginMockUtil.mockCustomerLogin());
        doThrow(new EntityNotFoundException(ResponseMsg.failurePlainResponse(MsgConstant.CUSTOMER_NOT_FOUND)))
                .when(customerManager).findCustomerLoginByUsername("9812345678");

        ServerResponse serverResponse = customerInquiryService.customerInquiryByUsername("9860465427");

        assertTrue(serverResponse.isSuccess());
        assertNotNull(serverResponse.getObj());
        assertNotNull(serverResponse.getMessage());
        assertNotNull(serverResponse.getCode());
        assertEquals(ErrorCodeEnum.SUCCESS.getCode(), serverResponse.getCode());

        assertThrows(EntityNotFoundException.class, () -> {
            customerInquiryService.customerInquiryByUsername("9812345678");
        });

        verify(customerManager, times(2)).findCustomerLoginByUsername(any(String.class));
    }

    @Test
    public void customerInquiryByAccountNumberTest() {

        when(customerManager.findPrimaryBankAccountByAccountNumber("123456789"))
                .thenReturn(BankAccountMockUtil.mockBankAccount());
        doThrow(new EntityNotFoundException(ResponseMsg.failurePlainResponse(MsgConstant.BANK_ACCOUNT_NOT_FOUND)))
                .when(customerManager).findPrimaryBankAccountByAccountNumber("987654321");

        ServerResponse serverResponse = customerInquiryService.customerInquiryByAccountNumber("123456789");

        assertTrue(serverResponse.isSuccess());
        assertNotNull(serverResponse.getObj());
        assertNotNull(serverResponse.getMessage());
        assertNotNull(serverResponse.getCode());
        assertEquals(ErrorCodeEnum.SUCCESS.getCode(), serverResponse.getCode());

        assertThrows(EntityNotFoundException.class, () -> {
            customerInquiryService.customerInquiryByAccountNumber("987654321");
        });

        verify(customerManager, times(2)).findPrimaryBankAccountByAccountNumber(any(String.class));
    }
}
