package com.f1soft.bankxp.edge.customer.inquiry.dto;

import com.f1soft.bankxp.edge.customer.dto.ModelBase;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountTypeDetailResponse extends ModelBase {
@Id
    private Long id;
    private String accountCategory;
    private String accountTypeName;
    private Character allowCreditTxn;
    private Character allowDebitTxn;
    private Character allowFixedDeposit;
    private Character allowTxn;
    private Character allowTxnAlert;
    private Character isChargeFree;
    private String type;
    private Character isRegistrationChargeFree;
    private Character isRenewChargeFree;
    private Character isPasswordChargeFree;

}
