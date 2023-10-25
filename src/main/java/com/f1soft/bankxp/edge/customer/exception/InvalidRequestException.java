package com.f1soft.bankxp.edge.customer.exception;


import com.f1soft.bankxp.edge.customer.dto.ServerResponse;


public class InvalidRequestException extends ServerException {

    public InvalidRequestException(final String message) {
        super(message);
    }

    public InvalidRequestException(final ServerResponse serverResponse) {
        super(serverResponse);
    }
}
