package com.f1soft.bankxp.edge.customer.exception;

import com.f1soft.bankxp.edge.customer.constant.ErrorCodeEnum;
import com.f1soft.bankxp.edge.customer.dto.ServerResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ServerException extends RuntimeException {

    private ServerResponse serverResponse;

    public boolean isInvalidLogin() {
        return false;
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public Integer getCode() {
        return null;
    }

    public String getProcessingCode() {
        return null;
    }

    public ServerException() {
        super();
    }

    public ServerException(final String message) {
        super(message);
    }

    public ServerException(final ServerResponse serverResponse) {
        this.serverResponse = serverResponse;
    }

    public ServerResponse getServerResponse() {
        if (serverResponse == null) {
            ServerResponse serverResponse = new ServerResponse();
            serverResponse.setSuccess(false);
            serverResponse.setCode(ErrorCodeEnum.FAILURE.getCode());
            serverResponse.setMessage("Internal Server Error!");

            return serverResponse;
        }
        return serverResponse;
    }
}
