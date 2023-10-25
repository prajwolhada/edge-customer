package com.f1soft.bankxp.edge.customer.exception;


import com.f1soft.bankxp.edge.customer.dto.ServerResponse;


public class EntityNotFoundException extends ServerException {

    public EntityNotFoundException(final String message) {
        super(message);
    }

    public EntityNotFoundException(final ServerResponse serverResponse) {
        super(serverResponse);
    }
}
