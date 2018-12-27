package com.louis.question.controller;


import com.louis.question.helper.RestRequestHelper;
import com.louis.question.model.RestRequest;
import com.louis.question.model.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    RestRequestHelper restRequestHelper;

    @RequestMapping(value="/user/{id}", method = {RequestMethod.PUT})
    public RestResponse insertUser(@RequestBody RestRequest restRequest, @PathVariable Long id){
        RestResponse restResponse = restRequestHelper.validateBody(restRequest);

        return restResponse;
    }


}
