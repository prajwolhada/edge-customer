package com.f1soft.bankxp.edge.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponse<T> extends ModelBase {

    private static final long serialVersionUID = 1L;

    private boolean success;
    private String message;
    private String code;
    private T data;
}
