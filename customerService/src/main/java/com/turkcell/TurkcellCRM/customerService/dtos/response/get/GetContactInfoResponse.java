package com.turkcell.TurkcellCRM.customerService.dtos.response.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetContactInfoResponse {
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String tax;
}