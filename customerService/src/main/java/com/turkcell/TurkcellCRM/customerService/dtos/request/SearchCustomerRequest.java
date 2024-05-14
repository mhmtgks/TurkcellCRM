package com.turkcell.TurkcellCRM.customerService.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCustomerRequest
{
    private int nationalityId;
    private String customerId;
    private String accountNumber;
    private String gsmNumber;
    private String firstName;
    private String lastName;
    private String orderNumber;
}
