package com.turkcell.rentacar.inventoryService.entities.concretes;

import com.turkcell.rentacar.inventoryService.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {

    @Column(name = "name")
    private String name;

}
