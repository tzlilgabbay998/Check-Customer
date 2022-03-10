package com.jb.checkApp.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jb.checkApp.models.CustomerRequest;

import java.lang.reflect.InvocationTargetException;

public interface CustomerService {

    boolean check(CustomerRequest customer) throws JsonProcessingException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

}
