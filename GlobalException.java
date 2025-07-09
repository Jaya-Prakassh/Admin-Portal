package com.sony.adminportal.Controller;

import com.sony.adminportal.Exception.InvalidProductException;
import com.sony.adminportal.Model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(InvalidProductException.class)
    public ResponseEntity<?> handleInvalidProductName(InvalidProductException invalidProductException){
        ErrorModel errorModel = ErrorModel .builder()
                .errorCode("Invalid_Product_Name")
                .errorMessage(invalidProductException.getMessage())
                .build();
        return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
    }

}
