package com.f1soft.bankxp.edge.customer.inquiry.mapper;

import com.f1soft.bankxp.edge.customer.inquiry.dto.*;
import com.f1soft.bankxp.edge.customer.util.DateFormat;
import com.f1soft.bankxp.edge.customer.util.DateFormatter;
import com.flsoft.bankxp.edge.entities.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerDetailMapper {

    private CustomerDetailMapper() {
    }

    public static CustomerDetailResponse mapToCustomerDetailResponse(CustomerLogin customerLogin) {
        Customer customer = customerLogin.getCustomer();

        CustomerDetailResponse customerDetailResponse = new CustomerDetailResponse();

        customerDetailResponse.setCustomerId(customer.getId());
        customerDetailResponse.setCustomerLoginId(customerLogin.getId());
        customerDetailResponse.setUsername(customerLogin.getUsername());
        customerDetailResponse.setFirstName(customer.getFirstName());
        customerDetailResponse.setMiddleName(customer.getMiddleName());
        customerDetailResponse.setLastName(customer.getLastName());
        customerDetailResponse.setGender(customer.getGender());
        customerDetailResponse.setCbsId(customer.getCbsId());
        customerDetailResponse.setAddress(customer.getAddress());
        customerDetailResponse.setEmailAddress(customer.getEmailAddress());
        customerDetailResponse.setProfile(mapToProfileDetailResponse(customer.getProfile()));
        customerDetailResponse.setBranch(mapToBranchDetailResponse(customer.getBranch()));
        customerDetailResponse.setBankAccountList(mapToBankAccountDetailResponseList(customer.getBankAccountList()));

        return customerDetailResponse;
    }

    public static ProfileDetailResponse mapToProfileDetailResponse(Profile profile) {
        ProfileDetailResponse profileDetailResponse = new ProfileDetailResponse();

        profileDetailResponse.setId(profile.getId());
        profileDetailResponse.setCode(profile.getCode());
        profileDetailResponse.setName(profile.getProfileName());

        return profileDetailResponse;
    }

    public static BranchDetailResponse mapToBranchDetailResponse(Branch branch) {
        BranchDetailResponse branchDetailResponse = new BranchDetailResponse();
        branchDetailResponse.setId(branch.getId());
        branchDetailResponse.setName(branch.getBranchName());
        branchDetailResponse.setCode(branch.getBranchCode());
        branchDetailResponse.setIpsBranchCode(branch.getIpsBranchCode());
        branchDetailResponse.setLongitude(branch.getLongitude());
        branchDetailResponse.setLatitude(branch.getLatitude());
        branchDetailResponse.setLocation(branch.getBranchLocation());

        return branchDetailResponse;
    }

    public static List<BankAccountDetailResponse> mapToBankAccountDetailResponseList(List<BankAccount> bankAccountList) {
        if (bankAccountList.isEmpty()) {
            return new ArrayList<>();
        }

        return bankAccountList.stream()
                .filter(bankAccount -> bankAccount.getActive() == 'Y')
                .map(bankAccount -> {
                    BankAccountDetailResponse bankAccountDetailResponse = new BankAccountDetailResponse();

                    bankAccountDetailResponse.setId(bankAccount.getId());
                    bankAccountDetailResponse.setAccountNumber(bankAccount.getAccountNumber());
                    bankAccountDetailResponse.setCbsId(bankAccount.getAccountOwnerCBSId());
                    bankAccountDetailResponse.setAlertEnabled(bankAccount.getAlertEnabled());
                    bankAccountDetailResponse.setCurrencyCode(bankAccount.getCurrencyCode());
                    bankAccountDetailResponse.setIsPrimary(bankAccount.getIsPrimary());
                    bankAccountDetailResponse.setIsAccountOwner(bankAccount.getIsAccountOwner());
                    bankAccountDetailResponse.setIsTrialPeriod(bankAccount.getIsTrialPeriod());
                    bankAccountDetailResponse.setRenewDate(DateFormatter.convertToString(bankAccount.getRenewDate(), DateFormat.DATE_FORMAT));
                    bankAccountDetailResponse.setTxnEnabled(bankAccount.getTxnEnabled());
                    bankAccountDetailResponse.setAccountHolderName(bankAccount.getAccountHolderName());
                    bankAccountDetailResponse.setBranch(mapToBranchDetailResponse(bankAccount.getBranch()));
                    bankAccountDetailResponse.setAccountType(mapToAccountTypeDetailResponse(bankAccount.getAccountType()));

                    return bankAccountDetailResponse;
                }).collect(Collectors.toList());
    }

    public static AccountTypeDetailResponse mapToAccountTypeDetailResponse(AccountType accountType) {
        AccountTypeDetailResponse accountTypeDetailResponse = new AccountTypeDetailResponse();

        accountTypeDetailResponse.setId(accountType.getId());
        accountTypeDetailResponse.setAccountCategory(accountType.getAccountCategory());
        accountTypeDetailResponse.setAccountTypeName(accountType.getAccountTypeName());
        accountTypeDetailResponse.setAllowCreditTxn(accountType.getAllowCreditTxn());
        accountTypeDetailResponse.setAllowDebitTxn(accountType.getAllowDebitTxn());
        accountTypeDetailResponse.setAllowFixedDeposit(accountType.getAllowFixedDeposit());
        accountTypeDetailResponse.setAllowTxn(accountType.getAllowTxn());
        accountTypeDetailResponse.setAllowTxnAlert(accountType.getAllowTxnAlert());
        accountTypeDetailResponse.setIsChargeFree(accountType.getIsChargeFree());
        accountTypeDetailResponse.setType(accountType.getType());
        accountTypeDetailResponse.setIsRegistrationChargeFree(accountType.getIsRegistrationChargeFree());
        accountTypeDetailResponse.setIsRenewChargeFree(accountType.getIsRenewChargeFree());
        accountTypeDetailResponse.setIsPasswordChargeFree(accountType.getIsPasswordChargeFree());

        return accountTypeDetailResponse;

    }


}
