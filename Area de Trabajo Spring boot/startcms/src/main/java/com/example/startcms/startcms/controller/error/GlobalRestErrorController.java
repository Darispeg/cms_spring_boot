package com.example.startcms.startcms.controller.error;


import com.example.startcms.util.ApiError;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/* import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice; */
import org.springframework.web.context.request.ServletWebRequest;

//@RestControllerAdvice(basePackages = {"com.example.startcms.startcms.controller.rest"})
public class GlobalRestErrorController {

    //@ExceptionHandler({EmptyResultDataAccessException.class})
    public ResponseEntity<Object> getEmptyResultDataAccessException(EmptyResultDataAccessException exception, ServletWebRequest servletWebRequest){

        ApiError apiError = new ApiError();
        
        apiError.setMessage(exception.getMessage());
        apiError.setMethpd(servletWebRequest.getHttpMethod().name());
        apiError.setStatus(HttpStatus.NOT_FOUND);

        return ResponseEntity.status(apiError.getStatus()).body(apiError);

    }

}
