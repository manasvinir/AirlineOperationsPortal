package com.manasvinir.AirlineOperationsPortal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//may shift exceptions to be handled by a global handler, but only if i need more specific error responses
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 3583457245783853742L;

    public NotFoundException(String message) {
        super(message);
    }
}
