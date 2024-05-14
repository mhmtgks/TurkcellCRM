package com.turkcell.TurkcellCRM.customerService.dtos.response;

import com.turkcell.TurkcellCRM.commonPackage.Product;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCustomerResponse {
    private int addressId;
    private int customerId;
    private int totalAmount;

    private List<Product> products;
}
