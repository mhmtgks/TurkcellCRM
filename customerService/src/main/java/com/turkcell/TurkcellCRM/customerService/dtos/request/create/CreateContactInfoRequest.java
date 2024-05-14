package com.turkcell.TurkcellCRM.customerService.dtos.request.create;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateContactInfoRequest {
    @Email
    @NotNull
    private String email;
    private String homePhone;
    @NotNull
    private String mobilePhone;
    private String tax;
}
