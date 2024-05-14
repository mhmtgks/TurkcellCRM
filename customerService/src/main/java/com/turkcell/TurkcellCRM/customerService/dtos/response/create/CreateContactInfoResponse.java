package com.turkcell.TurkcellCRM.customerService.dtos.response.create;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateContactInfoResponse {

    private String email;
    private String homePhone;

    private String mobilePhone;
    private String tax;
}
