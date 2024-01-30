package com.verystrong.car_loan_project.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Entity
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=50,nullable = false)
    private String name;

    @Column(length=50,nullable = false)
    private String info;

    @Column(length = 100)
    private String imgPath;

    @Column
    private BigDecimal price;

}
