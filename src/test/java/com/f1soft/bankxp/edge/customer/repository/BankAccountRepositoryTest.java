package com.f1soft.bankxp.edge.customer.repository;

import com.flsoft.bankxp.edge.entities.model.BankAccount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import utilities.BankAccountMockUtil;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BankAccountRepositoryTest {

    @Mock
    private BankAccountRepository bankAccountRepository;

    @Test
    public void findByAccountNumberTest() {
        when(bankAccountRepository.findByAccountNumber(any(String.class))).thenReturn(Optional.ofNullable(BankAccountMockUtil.mockBankAccount()));

        Optional<BankAccount> bankAccountOptional = bankAccountRepository.findByAccountNumber("123456789");

        assertTrue(bankAccountOptional.isPresent());
    }
}
