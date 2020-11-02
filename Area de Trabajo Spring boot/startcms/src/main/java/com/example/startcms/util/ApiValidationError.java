package com.example.startcms.util;

public class ApiValidationError extends ApiSubError{
    private String object;
    private String field;
    private Object rejectedvalue;
    private String message;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getRejectedvalue() {
        return rejectedvalue;
    }

    public void setRejectedvalue(Object rejectedvalue) {
        this.rejectedvalue = rejectedvalue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
