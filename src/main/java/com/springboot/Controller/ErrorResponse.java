package com.springboot.Controller;

public class ErrorResponse {
    private  String  defaultMessage;
    private String objectName;
    private String field;
    private  String rejectedValue;
    private  String code;

    public ErrorResponse(String defaultMessage, String objectName, String field, String rejectedValue, String code) {
        this.defaultMessage = defaultMessage;
        this.objectName = objectName;
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.code = code;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(String rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "defaultMessage='" + defaultMessage + '\'' +
                ", objectName='" + objectName + '\'' +
                ", field='" + field + '\'' +
                ", rejectedValue='" + rejectedValue + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
