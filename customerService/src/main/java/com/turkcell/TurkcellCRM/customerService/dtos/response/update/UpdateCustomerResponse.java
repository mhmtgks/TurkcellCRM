package com.turkcell.TurkcellCRM.customerService.dtos.response.update;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCustomerResponse {


    private String firstName;

    private String lastName;

    private String nationalityNumber;


}
