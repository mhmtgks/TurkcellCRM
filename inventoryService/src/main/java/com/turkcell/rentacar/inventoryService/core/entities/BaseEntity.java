package com.turkcell.rentacar.core.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor

@Data
@MappedSuperclass
public class BaseEntity {
//    @Id  //primary key demek
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id")
      @Id
      @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "base_sequence_generator" //generator name
)
    private int id;
    @Column(name="createdDate")
    private LocalDateTime createdDate;
    @Column(name="updatedDate")
    private  LocalDateTime updatedDate;
    @Column(name="deletedDate")
    private  LocalDateTime deletedDate;
}
