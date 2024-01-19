package com.verystrong.car_loan_project.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Terms{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    @EqualsAndHashCode.Include
    private Long termsId;

    private String name; //약관명

    private String termsDetailUrl; //약관상세 URL
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Terms terms)) return false;
//        return Objects.equals(termsId, terms.termsId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(termsId);
//    }


}
