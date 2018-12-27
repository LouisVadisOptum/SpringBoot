package com.louis.question.helper;

import com.louis.question.constants.UserConstants;
import com.louis.question.model.RestRequest;
import com.louis.question.model.RestResponse;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class RestRequestHelper {

    public RestResponse validateBody(RestRequest restRequest){
        RestResponse restResponse = new RestResponse();

        if(null == restRequest.getEmailAddress() || restRequest.getEmailAddress().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,UserConstants.EMAIL_ADDRESS_EMPTY);
        } else if(null == restRequest.getName() || restRequest.getName().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,UserConstants.USER_EMPTY);
        } else if(validateEmail(restRequest.getEmailAddress())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,UserConstants.EMAIL_ADDRESS_INCORRECT);
        } else {
            restResponse.setDescription(UserConstants.USER_CORRECT);
            restResponse.setCode(UserConstants.SUCCESS_CODE);
        }
        return restResponse;
    }

    public boolean validateEmail(String emailAddress){
        return !EmailValidator.getInstance(false).isValid(emailAddress);
    }
}
