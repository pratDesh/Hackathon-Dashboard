package com.bootcamp.dto;

import java.util.List;

public class ErrorDetailsDTO {

    public ErrorDetailsDTO(String status, String errorMessage, List<String> validationErrors) {
        this.status = status;
        this.errorMessage = errorMessage;
        this.validationErrors = validationErrors;
    }

    private String status;
    private String errorMessage;
    private List<String> validationErrors;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<String> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(List<String> validationErrors) {
        this.validationErrors = validationErrors;
    }


}
