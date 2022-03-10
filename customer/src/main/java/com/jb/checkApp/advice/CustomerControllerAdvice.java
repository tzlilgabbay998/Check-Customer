package com.jb.checkApp.advice;

import com.jb.checkApp.exceptions.CustomerSystemException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerControllerAdvice {

    @ExceptionHandler(value = {CustomerSystemException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrDetails errDetails(Exception e){
        return new ErrDetails("FAILURE!!!",e.getMessage());
    }
}
