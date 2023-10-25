package com.f1soft.bankxp.edge.customer.controller;

import com.f1soft.bankxp.edge.customer.constant.MsgConstant;
import com.f1soft.bankxp.edge.customer.dto.ServerResponse;
import com.f1soft.bankxp.edge.customer.exception.EntityNotFoundException;
import com.f1soft.bankxp.edge.customer.inquiry.dto.CustomerDetailResponse;
import com.f1soft.bankxp.edge.customer.inquiry.service.impl.CustomerInquiryServiceImpl;
import com.f1soft.bankxp.edge.customer.util.ResponseMsg;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@AutoConfigureMockMvc
public class CustomerInquiryControllerTest {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private MockMvc mockMvc;

    @MockBean
    private CustomerInquiryServiceImpl customerInquiryService;

    public static final MediaType APPLICATION_JSON_UFT8 = MediaType.APPLICATION_JSON;

    @Test
    public void customerEnquiryUsingCustomerIdTest() throws Exception {

        when(customerInquiryService.customerInquiryById(1L))
                .thenReturn(successResponse());

        mockMvc.perform(get("/inquiry/customer-id/{customerId}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UFT8))
                .andExpect(jsonPath("$.success", is(true)))
                .andExpect(jsonPath("$.code", is("0")))
                .andExpect(jsonPath("$.data").exists());
    }

    @Test
    public void customerEnquiryUsingCustomerIdFailureTest() throws Exception {
        doThrow(new EntityNotFoundException(ResponseMsg.failurePlainResponse(MsgConstant.CUSTOMER_NOT_FOUND)))
                .when(customerInquiryService).customerInquiryById(2L);

        mockMvc.perform(get("/inquiry/customer-id/{customerId}", 2L))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.success", is(false)))
                .andExpect(jsonPath("$.code", is("2")))
                .andExpect(jsonPath("$.message").exists());
    }

    @Test
    public void customerEnquiryUsingCustomerLoginIdTest() throws Exception {
        when(customerInquiryService.customerInquiryByCustomerLoginId(1L))
                .thenReturn(successResponse());

        mockMvc.perform(get("/inquiry/customerlogin-id/{customerLoginId}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UFT8))
                .andExpect(jsonPath("$.success", is(true)))
                .andExpect(jsonPath("$.code", is("0")))
                .andExpect(jsonPath("$.data").exists());
    }

    @Test
    public void customerEnquiryUsingCustomerLoginIdFailureTest() throws Exception {
        doThrow(new EntityNotFoundException(ResponseMsg.failurePlainResponse(MsgConstant.CUSTOMER_NOT_FOUND)))
                .when(customerInquiryService).customerInquiryByCustomerLoginId(2L);

        mockMvc.perform(get("/inquiry/customerlogin-id/{customerLoginId}", 2L))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.success", is(false)))
                .andExpect(jsonPath("$.code", is("2")))
                .andExpect(jsonPath("$.message").exists());
    }

    @Test
    public void customerEnquiryUsingMobileTest() throws Exception {
        when(customerInquiryService.customerInquiryByUsername("9860465427"))
                .thenReturn(successResponse());

        mockMvc.perform(get("/inquiry/mobile-number/{mobileNumber}", "9860465427"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UFT8))
                .andExpect(jsonPath("$.success", is(true)))
                .andExpect(jsonPath("$.code", is("0")))
                .andExpect(jsonPath("$.data").exists());
    }

    @Test
    public void customerEnquiryUsingMobileFailureTest() throws Exception {
        doThrow(new EntityNotFoundException(ResponseMsg.failurePlainResponse(MsgConstant.CUSTOMER_NOT_FOUND)))
                .when(customerInquiryService).customerInquiryByUsername("9860465429");

        mockMvc.perform(get("/inquiry/mobile-number/{mobileNumber}", "9860465429"))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.success", is(false)))
                .andExpect(jsonPath("$.code", is("2")))
                .andExpect(jsonPath("$.message").exists());
    }

    @Test
    public void customerEnquiryUsingAccountNumberTest() throws Exception {
        when(customerInquiryService.customerInquiryByAccountNumber("123456789"))
                .thenReturn(successResponse());

        mockMvc.perform(get("/inquiry/account-number/{accountNumber}", "123456789"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UFT8))
                .andExpect(jsonPath("$.success", is(true)))
                .andExpect(jsonPath("$.code", is("0")))
                .andExpect(jsonPath("$.data").exists());
    }

    @Test
    public void customerEnquiryUsingAccountNumberFailureTest() throws Exception {
        doThrow(new EntityNotFoundException(ResponseMsg.failurePlainResponse(MsgConstant.BANK_ACCOUNT_NOT_FOUND)))
                .when(customerInquiryService).customerInquiryByAccountNumber("987654321");

        mockMvc.perform(get("/inquiry/account-number/{accountNumber}", "987654321"))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.success", is(false)))
                .andExpect(jsonPath("$.code", is("2")))
                .andExpect(jsonPath("$.message").exists());
    }

    private ServerResponse successResponse() {
        return ResponseMsg.successResponse(new CustomerDetailResponse(), "Data Fetched Successfully.");
    }
}
