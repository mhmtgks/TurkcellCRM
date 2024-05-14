package com.turkcell.TurkcellCRM.customerService.clients;

import com.turkcell.TurkcellCRM.customerService.dtos.request.CreateUserJwtRequest;
import com.turkcell.TurkcellCRM.customerService.dtos.response.SearchCustomerResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name="identityservice",url = "http://localhost:8083/api/v1/auth")
public interface IdentityServiceClient {
    @PostMapping("/login")
    String getJwt(@RequestBody CreateUserJwtRequest userInfo);
}
