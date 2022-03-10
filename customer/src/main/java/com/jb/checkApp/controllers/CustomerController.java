package com.jb.checkApp.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jb.checkApp.exceptions.CustomerSystemException;
import com.jb.checkApp.models.CustomerRequest;
import com.jb.checkApp.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String checkCustomer(@RequestBody CustomerRequest customer) throws JsonProcessingException,NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
       if(customerService.check(customer)){
           return "SUCCESS!!!";
       }else {
         return "FAILURE";
    }
}}