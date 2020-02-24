
package com.net.commerce.product.internal;

import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.MapBindingResult;

import java.util.HashMap;

public class RestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private HttpStatus status;
    private Errors errors;

  

    public RestException(final HttpStatus status, final String errorCode, final String defaultMessage, final String... args) {
        super();
        this.status = status;

        Errors error = new MapBindingResult(new HashMap<>(), "Multivalue");
        error.reject(errorCode, args, defaultMessage);

        this.errors = error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Errors getErrors() {
        return errors;
    }

}

