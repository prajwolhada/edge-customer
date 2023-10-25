package com.f1soft.bankxp.edge.customer.exception.handler;

import com.f1soft.bankxp.edge.customer.constant.ErrorCodeEnum;
import com.f1soft.bankxp.edge.customer.dto.GenericResponse;
import com.f1soft.bankxp.edge.customer.dto.ServerResponse;
import com.f1soft.bankxp.edge.customer.exception.EntityNotFoundException;
import com.f1soft.bankxp.edge.customer.exception.InvalidRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler {

    private ResponseEntity<Object> buildResponseEntity(ServerResponse serverResponse, HttpStatus httpStatus) {
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setSuccess(serverResponse.isSuccess());
        genericResponse.setMessage(serverResponse.getMessage());
        genericResponse.setCode(serverResponse.getCode());

        return new ResponseEntity<>(genericResponse, httpStatus);
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Object> handleRuntimeException(Exception ex) {
        log.error("Exception message : {}", ex.getMessage());

        if (log.isDebugEnabled()) {
            log.error("Exception : ", ex);
            log.error("Exception Localized Message: ", ex.getLocalizedMessage());
        }
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setSuccess(false);
        serverResponse.setCode(ErrorCodeEnum.FAILURE.getCode());
        serverResponse.setMessage("Internal Server Error");
        return buildResponseEntity(serverResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidRequestException.class)
    protected ResponseEntity<Object> handleInvalidRequestException(InvalidRequestException ex) {
        log.error("Exception message : {}", ex.getMessage());

        if (log.isDebugEnabled()) {
            log.error("Exception : ", ex);
            log.error("Exception Localized Message: ", ex.getLocalizedMessage());
        }

        ServerResponse serverResponse = ex.getServerResponse();

        return buildResponseEntity(serverResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
        log.error("Exception message : {}", ex.getMessage());

        if (log.isDebugEnabled()) {
            log.error("Exception : ", ex);
        }
        return buildResponseEntity(ex.getServerResponse(), HttpStatus.NOT_ACCEPTABLE);
    }
}
