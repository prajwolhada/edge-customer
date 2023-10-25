package com.f1soft.bankxp.edge.customer.inquiry.dto;

import com.f1soft.bankxp.edge.customer.dto.ModelBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileDetailResponse extends ModelBase {

   private Long id;
   private String code;
   private String name;
}
