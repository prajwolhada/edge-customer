package com.f1soft.bankxp.edge.customer.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    SUCCESS("0"),
    NO_RESULT_FOUND("1"),
    FAILURE("2"),
    TIME_OUT("-10");

    private String code;

}
