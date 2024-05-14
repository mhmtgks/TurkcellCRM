package com.turkcell.TurkcellCRM.customerService.dtos.request.update;
import com.turkcell.TurkcellCRM.commonPackage.Gender;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCustomerRequest {

    @NotNull
    private String firstName;

    private String secondName;

    @NotNull
    private String lastName;

    @NotNull
    private LocalDateTime birthDate;

    @NotNull
    private Gender gender;

    private String fatherName;

    private String motherName;

    @NotNull
    private String nationalityNumber;


}
