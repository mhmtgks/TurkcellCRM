package com.turkcell.TurkcellCRM.customerService.dtos.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserJwtRequest {
    private String password;
    private String email;
}
