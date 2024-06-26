package com.turkcell.TurkcellCRM.orderService.entities.concretes;

import com.turkcell.TurkcellCRM.commonPackage.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product extends BaseEntity {


    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "unitOfStock")
    private int unitOfStock;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
