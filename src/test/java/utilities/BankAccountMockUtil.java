package utilities;

import com.flsoft.bankxp.edge.entities.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAccountMockUtil {

    public static BankAccount mockBankAccount() {
        BankAccount bankAccount = new BankAccount();

        bankAccount.setId(1L);
        bankAccount.setAccountNumber("123456789101112");
        bankAccount.setTxnEnabled('Y');
        bankAccount.setAlertEnabled('Y');
        bankAccount.setAccountAlias("1");
        bankAccount.setIsPrimary('Y');
        bankAccount.setIsAccountOwner('Y');
        bankAccount.setAccountOwnerCBSId("Y");
        bankAccount.setAccountType(mockAccountType());
        bankAccount.setCustomer(CustomerMockUtil.mockCustomer(CustomerLoginMockUtil.mockCustomerLogin()));
        bankAccount.setBranch(BranchMockUtil.mockBranch());
        bankAccount.setCardNumber("");
        bankAccount.setAddedDate(new Date());
        bankAccount.setAddedBy(new ApplicationUser());
        bankAccount.setLastModifiedDate(new Date());
        bankAccount.setLastModifiedBy(new ApplicationUser());
        bankAccount.setActive('Y');
        bankAccount.setServiceFlag('E');
        bankAccount.setServiceCode("CMD");
        bankAccount.setServiceRemarks("");
        bankAccount.setRenewDate(new Date());
        bankAccount.setExpiryDate(new Date());
        bankAccount.setServiceBlockDate(new Date());
        bankAccount.setIsTrialPeriod('N');
        bankAccount.setCurrencyCode("NPR");
        bankAccount.setRegCleared('Y');
        bankAccount.setChargeCode("0");
        bankAccount.setChargeRemarks("");
        bankAccount.setChargeDeductDate(new Date());
        bankAccount.setAccountHolderName("Customer Name");
        bankAccount.setAccountLabel("ACCOUNT");

        return bankAccount;
    }

    public static List<BankAccount> mockBankAccountList() {
        List<BankAccount> bankAccountList = new ArrayList<>();

        for (int i = 0; i <= 3; i++) {
            BankAccount bankAccount = new BankAccount();

            bankAccount.setId(Long.valueOf(i));
            bankAccount.setAccountNumber("1234567891011" + i);
            bankAccount.setTxnEnabled('Y');
            bankAccount.setAlertEnabled('Y');
            bankAccount.setAccountAlias(String.valueOf(i));
            bankAccount.setIsPrimary('Y');
            bankAccount.setIsAccountOwner('Y');
            bankAccount.setAccountOwnerCBSId("Y");
            bankAccount.setAccountType(mockAccountType());
            bankAccount.setCustomer(new Customer());
            bankAccount.setBranch(new Branch());
            bankAccount.setCardNumber("");
            bankAccount.setAddedDate(new Date());
            bankAccount.setAddedBy(new ApplicationUser());
            bankAccount.setLastModifiedDate(new Date());
            bankAccount.setLastModifiedBy(new ApplicationUser());
            bankAccount.setActive('Y');
            bankAccount.setServiceFlag('E');
            bankAccount.setServiceCode("CMD");
            bankAccount.setServiceRemarks("");
            bankAccount.setRenewDate(new Date());
            bankAccount.setExpiryDate(new Date());
            bankAccount.setServiceBlockDate(new Date());
            bankAccount.setIsTrialPeriod('N');
            bankAccount.setCurrencyCode("NPR");
            bankAccount.setRegCleared('Y');
            bankAccount.setChargeCode("0");
            bankAccount.setChargeRemarks("");
            bankAccount.setChargeDeductDate(new Date());
            bankAccount.setAccountHolderName("Customer Name");
            bankAccount.setAccountLabel("ACCOUNT");

            bankAccountList.add(bankAccount);
        }

        return bankAccountList;
    }

    public static AccountType mockAccountType() {
        AccountType accountType = new AccountType();

        accountType.setId(1L);
        accountType.setType("SBA");
        accountType.setAccountTypeName("Saving Account");
        accountType.setActive('Y');
        accountType.setAllowTxn('Y');
        accountType.setAllowRequest('Y');
        accountType.setAllowTxnAlert('Y');
        accountType.setAllowDebitTxn('Y');
        accountType.setAllowCreditTxn('Y');
        accountType.setIsChargeFree('N');
        accountType.setAccountCategory("SAVING");
        accountType.setAllowFixedDeposit('Y');
        accountType.setIsRegistrationChargeFree('N');
        accountType.setIsProfileChargeFree('N');
        accountType.setIsRenewChargeFree('N');
        accountType.setIsPasswordChargeFree('N');

        return accountType;
    }
}
