package com.f1soft.bankxp.edge.customer.inquiry.dto;

import com.f1soft.bankxp.edge.customer.dto.ModelBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDetailResponse extends ModelBase {

    private Long customerId;
    private Long customerLoginId;
    private String username;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String cbsId;
    private String address;
    private String emailAddress;
    private ProfileDetailResponse profile;
    private BranchDetailResponse branch;
    private List<BankAccountDetailResponse> bankAccountList;

}
