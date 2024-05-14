package com.turkcell.TurkcellCRM.customerService.entities.concretes;
import com.turkcell.TurkcellCRM.commonPackage.BaseEntity;
import com.turkcell.TurkcellCRM.customerService.entities.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {


    @Column(name = "firstName")
    @NotNull
    private String firstName;

    @Column(name = "secondName")
    private String secondName;

    @Column(name = "lastName")
    @NotNull
    private String lastName;

    @Column(name = "birthDate")
    @NotNull
    private LocalDateTime birthDate;

    @Column(name = "gender")
    @NotNull
    private Gender gender;

    @Column(name = "fatherName")
    private String fatherName;

    @Column(name = "motherName")
    private String motherName;

    @Column(name = "nationalityId")
    @NotNull
    private String nationalityNumber;

    @OneToOne(mappedBy = "customer")
    private ContactInfo contactInfo;

    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;






}
