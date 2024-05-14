package com.turkcell.TurkcellCRM.customerService.entities.concretes;
import com.turkcell.TurkcellCRM.commonPackage.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "contactinfos")
public class ContactInfo extends BaseEntity {

    @Column(name = "email")
    @NotNull
    @Email
    private String email;

    @Column(name = "homePhone")
    private String homePhone;

    @Column(name = "mobilePhone")
    @NotNull
    private String mobilePhone;

    @Column(name = "tax")
    private String tax;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


}