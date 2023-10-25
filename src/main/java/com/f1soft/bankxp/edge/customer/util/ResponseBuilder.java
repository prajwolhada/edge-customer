package com.f1soft.bankxp.edge.customer.util;

import com.f1soft.bankxp.edge.customer.dto.ServerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

    public final static ResponseEntity<?> response(ServerResponse serverResponse) {
        if (serverResponse.isSuccess()) {
            return new ResponseEntity<>(CommonMapper.convertToGenericResponse(serverResponse), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(CommonMapper.convertToGenericResponse(serverResponse), HttpStatus.OK);
        }
    }
}
