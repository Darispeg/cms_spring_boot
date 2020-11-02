package com.example.startcms.util;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {
    
    private HttpStatus status;

    private String message;

    private String methpd;

    private List<ApiSubError> subErrors;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMethpd() {
        return methpd;
    }

    public void setMethpd(String methpd) {
        this.methpd = methpd;
    }

    public List<ApiSubError> getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(List<ApiSubError> subErrors) {
        this.subErrors = subErrors;
    }

}
