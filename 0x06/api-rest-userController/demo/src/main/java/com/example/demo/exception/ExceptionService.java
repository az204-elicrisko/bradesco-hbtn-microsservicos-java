package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionService {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @ExceptionHandler
    ResponseEntity<CPFException> handleException(CPFException err){
        UserErrorResponse uer = new UserErrorResponse();
        uer.setStatus(HttpStatus.BAD_REQUEST.value()); 
        uer.setMessage("You have entered CPF "+err.getMessage()+" invalid.");
        return new ResponseEntity(uer,HttpStatus.BAD_REQUEST); 
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @ExceptionHandler
    ResponseEntity<UserIdException> handleException(UserIdException err){
        UserErrorResponse uer = new UserErrorResponse();
        uer.setStatus(HttpStatus.BAD_REQUEST.value()); 
        uer.setMessage("You have entered ID "+err.getMessage()+" invalid.");
        return new ResponseEntity(uer,HttpStatus.BAD_REQUEST);
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @ExceptionHandler
    ResponseEntity<UserNameException> handleException(UserNameException err){
        UserErrorResponse uer = new UserErrorResponse();
        uer.setStatus(HttpStatus.BAD_REQUEST.value()); 
        uer.setMessage("You have entered USERNAME "+err.getMessage()+" invalid.");
        return new ResponseEntity(uer,HttpStatus.BAD_REQUEST);
    }
    
}