package com.srsvmj.employee_service_with_mapstruct.exception;


public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
