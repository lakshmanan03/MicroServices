package com.scgapps.mobile.api.library.rest.errors;

import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

public class RPMException extends RuntimeException {
    private ErrorInfo errorInfo;
    private HttpStatus httpStatus = null;

    public static RPMException throwErrorMessage(ErrorInfo errorInfo){
        return new RPMException(errorInfo);
    }

    public static RPMException throwErrorMessage(HttpStatus httpStatus, ErrorInfo errorInfo){
        return new RPMException(httpStatus,errorInfo);
    }

    private RPMException() {
        super("");
    }

    private  RPMException(@NotNull ErrorInfo errorInfo) {
        super(errorInfo.getMessage());
        this.errorInfo = errorInfo;
    }

    private  RPMException(HttpStatus httpStatus, @NotNull ErrorInfo errorInfo) {
        super(errorInfo.getMessage());
        this.errorInfo = errorInfo;
        this.httpStatus = httpStatus;
    }

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public HttpStatus getHttpStatus(){
        return httpStatus;
    }
}

