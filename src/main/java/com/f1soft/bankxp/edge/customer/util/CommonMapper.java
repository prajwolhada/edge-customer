package com.f1soft.bankxp.edge.customer.util;

import com.f1soft.bankxp.edge.customer.dto.GenericResponse;
import com.f1soft.bankxp.edge.customer.dto.ServerResponse;

/*
 * @Author Rashim Dhaubanjar
 */
public class CommonMapper {

    private CommonMapper() {
    }

    public static GenericResponse convertToGenericResponse(ServerResponse serverResponse) {
        GenericResponse genericResponse = new GenericResponse();
        if (serverResponse.isSuccess()) {
            genericResponse.setSuccess(serverResponse.isSuccess());
            genericResponse.setMessage(serverResponse.getMessage());
            genericResponse.setData(serverResponse.getObj());
            genericResponse.setCode("0");
        } else {
            genericResponse.setSuccess(serverResponse.isSuccess());
            genericResponse.setMessage(serverResponse.getMessage());
            genericResponse.setCode(serverResponse.getCode());
        }
        return genericResponse;
    }
}
