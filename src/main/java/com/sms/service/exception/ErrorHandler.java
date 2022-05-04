package com.sms.service.exception;

import com.sms.service.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> customExceptionHandler(CustomException ex) {
        ResponseDTO response = new ResponseDTO();
        response.setMessage(ex.getMessage());
        response.setError(ex.getError());


        return new ResponseEntity<>(response, ex.getHttpStatus());
    }
}
