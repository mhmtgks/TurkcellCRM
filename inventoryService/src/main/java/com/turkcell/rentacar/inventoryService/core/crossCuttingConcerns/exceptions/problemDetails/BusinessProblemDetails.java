package com.turkcell.rentacar.inventoryService.core.utilities.exceptions.problemDetails;

public class BusinessProblemDetails extends com.turkcell.rentacar.core.utilities.exceptions.problemDetails.ProblemDetails {
    public BusinessProblemDetails(){
        setTitle("Business Rule Violation");
        setType("http://mydomain.com/exceptions/business");
        setStatus("400");
    }

}
