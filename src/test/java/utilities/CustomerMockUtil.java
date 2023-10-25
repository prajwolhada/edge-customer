package utilities;

import com.flsoft.bankxp.edge.entities.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerMockUtil {

    public static Customer mockCustomer(CustomerLogin customerLogin) {
        Customer customer = new Customer();

        List<CustomerLogin> customerLoginList = new ArrayList<>();
        customerLoginList.add(customerLogin);

        customer.setId(1L);
        customer.setFirstName("Bal");
        customer.setMiddleName("Krishna");
        customer.setLastName("Sama");
        customer.setAddress("Baneshwor Kathmandu");
        customer.setEmailAddress("bal_sama@gmail.com");
        customer.setActive('Y');
        customer.setBranchId(1L);
        customer.setRejectRemarks("");
        customer.setApproved('Y');
        customer.setGender("M");
        customer.setApprovedBy(new ApplicationUser());
        customer.setApprovedDate(new Date());
        customer.setRejectedBy(new ApplicationUser());
        customer.setRejectedDate(new Date());
        customer.setDeletedBy(new ApplicationUser());
        customer.setDeletedDate(new Date());
        customer.setDeleteRemarks("");
        customer.setDeletedApprovedBy(new ApplicationUser());
        customer.setDeletedApprovedDate(new Date());
        customer.setEditApprovedBy("");
        customer.setEditApprovedDate(new Date());
        customer.setLastModifiedRemarks("");
        customer.setLatestActivityRemarks("");
        customer.setContactNo("9860465427");
        customer.setMobileNumber("9860465427");
        customer.setLatestChangedMobile("");
        customer.setCbsId("1234");
        customer.setAcHolder('Y');
        customer.setMode("");
        customer.setPrimaryAccount("ACCOUNT");
        customer.setHasSecurityQuestion('Y');
        customer.setTxnAuthMode("OTP");
        customer.setQrLogin("Y");
        customer.setRegistrationType("SELF_REGISTRATION");
        customer.setBankAccountList(BankAccountMockUtil.mockBankAccountList());
        customer.setCardAccountList(new ArrayList<CardAccount>());
        customer.setCustomerLinkedAccountList(new ArrayList<CustomerLinkedAccount>());
        customer.setCustomerLoginList(customerLoginList);
        customer.setBranch(BranchMockUtil.mockBranch());
        customer.setProfile(ProfileMockUtil.mockProfile());
        customer.setSecurityAnswerList(new ArrayList<CustomerSecurityAnswer>());
        customer.setProfileImage("");
        customer.setEmailVerify('Y');
        customer.setLanguage("EN");
        customer.setNotificationLanguage("EN");
        customer.setBankKycVerify('Y');
        customer.setCreatedBy(new ApplicationUser());
        customer.setCreatedDate(new Date());
        customer.setLastModifiedBy(new ApplicationUser());
        customer.setLastModifiedDate(new Date());

        return customer;
    }
}
