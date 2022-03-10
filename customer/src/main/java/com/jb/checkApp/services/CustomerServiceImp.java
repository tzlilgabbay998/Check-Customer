package com.jb.checkApp.services;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.jb.checkApp.models.CustomerRequest;
import com.jb.checkApp.utils.Utils;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp extends Utils implements CustomerService {
    CustomerRequest customerRequest = new CustomerRequest();

    @Override
    public boolean check(CustomerRequest customer)  {
        customerRequest = customer;
        if(!isAdditionalPropertiesExist()){
            if(isIdValid())
                if(isFirstNameValid())
                    if(isLastNameValid())
                        if(isPhoneValid())
                            return isEmailValid();
                    }
        return false;
    }

    private boolean isAdditionalPropertiesExist() {
        return customerRequest.getAdditionalProperties().size() > 0;
    }

    private boolean isIdValid(){
        Integer id = customerRequest.getId();
        if(id != null ){
            return String.valueOf(id).length() == 9;
        }
        return false;
    }

    private boolean isFirstNameValid(){
        String firstName = customerRequest.getFirstName();

        if(firstName != null && firstName.length() > 2)
            return isOnlyLetters(firstName);

        return false;

    }

    private boolean isLastNameValid(){
        String lastName = customerRequest.getLastName();

        if(lastName != null && lastName.length() > 2)
            return isOnlyLetters(lastName);

        return false;
    }

    private boolean isPhoneValid(){
        String phone = customerRequest.getPhone();

        if(phone == null)
            return false;

        if(phone.contains("-"))
            phone = phone.replaceAll("-","");

        if(phone.length() < 9 || phone.length() > 10)
            return false;

        return isOnlyDigits(phone);
    }

    private boolean isEmailValid() {
        String mail = customerRequest.getEmail();

        if (mail != null && countCharInString(mail, '@') == 1 && mail.contains(".") && mail.length() > 5) {
            int atIndex = mail.indexOf('@');
            String subString = mail.substring(atIndex);

            if(subString.contains(".")) {
                int dotIndex = subString.indexOf(".");
                return dotIndex > 1 && subString.charAt(subString.length()-1) != '.';
            }
        }
        return false;
    }

}