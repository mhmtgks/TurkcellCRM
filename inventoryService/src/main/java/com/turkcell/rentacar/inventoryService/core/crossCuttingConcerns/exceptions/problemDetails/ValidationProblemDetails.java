package com.turkcell.rentacar.core.utilities.exceptions.problemDetails;


import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@Data
public class ValidationProblemDetails extends ProblemDetails{
    public ValidationProblemDetails(){
        setTitle("Validation Rule Violation");
        setDetail("Validation Problem");
        setType("http://mydomain.com/exceptions/validation");
        setStatus("400"); }
    private Map<String,String> errors;
@ExceptionHandler({ MethodArgumentNotValidException.class })
@ResponseStatus(HttpStatus.BAD_REQUEST)
public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception) {
    Map<String,String> validationErrors = new HashMap<>();
    exception.getBindingResult().getFieldErrors().stream().map(error -> validationErrors.put(error.getField(),error.getDefaultMessage()) )
            .toList();
    ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
    validationProblemDetails.setErrors(validationErrors);
    return validationProblemDetails;
}
}


