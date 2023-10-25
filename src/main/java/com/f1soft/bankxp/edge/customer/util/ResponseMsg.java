package com.f1soft.bankxp.edge.customer.util;

import com.f1soft.bankxp.edge.customer.constant.ErrorCodeEnum;
import com.f1soft.bankxp.edge.customer.dto.ServerResponse;

public class ResponseMsg {

    public static ServerResponse successPlainResponse(String message) {
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setSuccess(true);
        serverResponse.setCode("0");
        serverResponse.setMessage(message);
        return serverResponse;
    }

    public static ServerResponse failurePlainResponse(String code, String message) {
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setSuccess(false);
        serverResponse.setCode(code);
        serverResponse.setMessage(message);
        return serverResponse;
    }

    public static ServerResponse failurePlainResponse(String message) {
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setSuccess(false);
        serverResponse.setCode(ErrorCodeEnum.FAILURE.getCode());
        serverResponse.setMessage(message);
        return serverResponse;
    }

    public static ServerResponse successResponsse(Object ojb) {
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setSuccess(true);
        serverResponse.setObj(ojb);
        return serverResponse;
    }

    public static ServerResponse successResponse(Object ojb, String message) {
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setSuccess(true);
        serverResponse.setCode(ErrorCodeEnum.SUCCESS.getCode());
        serverResponse.setObj(ojb);
        serverResponse.setMessage(message);
        return serverResponse;
    }
}
