package com.turkcell.rentacar.inventoryService.business.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllBrandResponse {
    private int id;
    private String name;

}
