package com.moonlight.mnt.exception;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String>errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->errors.put(error.getField(),error.getDefaultMessage()));
        return errors;
	}
	@ExceptionHandler(DuplicatePaymentException.class)
	public Map<String, String> handleDuplicatePaymentException(DuplicatePaymentException ex) {
	    Map<String, String> error = new HashMap<>();
	    error.put("message",ex.getMessage());
	    return error;
	}
	@ExceptionHandler(DuplicateFlatException.class)
	public Map<String, String> handleDuplicateFlatException(DuplicateFlatException ex) {
	    Map<String, String> error = new HashMap<>();
	    error.put("message",ex.getMessage());
	    return error;
	}
}
