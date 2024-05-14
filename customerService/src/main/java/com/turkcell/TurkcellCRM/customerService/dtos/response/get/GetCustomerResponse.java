package com.turkcell.TurkcellCRM.customerService.dtos.response.get;

import com.turkcell.TurkcellCRM.commonPackage.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCustomerResponse {
    private String firstName;
    private String secondName;
    private String lastName;
    private LocalDateTime birthDate;
    private Gender gender;
    private String fatherName;
    private String motherName;
    private String nationalNumber;

}