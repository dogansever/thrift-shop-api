package com.sever.thriftshopapi.exceptions;

import com.sever.thriftshopapi.dtos.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse handleNoHandlerFoundException(HttpServletResponse response) {
        response.setHeader("Error", "true");
        return ErrorResponse.builder().error("No handler found").build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(Exception exception) {
        return ErrorResponse.builder().error(exception.getMessage()).build();
    }
}
