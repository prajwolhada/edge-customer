package com.f1soft.bankxp.edge.customer.inquiry.dto;

import com.f1soft.bankxp.edge.customer.dto.ModelBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDetailResponse extends ModelBase {

    private Long id;
    private String accountNumber;
    private String cbsId;
    private Character alertEnabled;
    private String currencyCode;
    private Character isPrimary;
    private Character isAccountOwner;
    private Character isTrialPeriod;
    private String renewDate;
    private Character txnEnabled;
    private BranchDetailResponse branch;
    private String accountHolderName;
    private AccountTypeDetailResponse accountType;

}
