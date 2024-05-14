package com.turkcell.TurkcellCRM.customerService.dtos.response.get;

import java.time.LocalDateTime;
import com.turkcell.TurkcellCRM.commonPackage.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllCustomerResponse {
    private String firstName;
    private String secondName;
    private String lastName;
    private LocalDateTime birthDate;
    private Gender gender;
    private String fatherName;
    private String motherName;
    private String nationalNumber;
    private int customerId;
}
