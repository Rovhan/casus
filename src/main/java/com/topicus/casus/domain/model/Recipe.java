package com.topicus.casus.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bsnPatient;
    private LocalDate prescriptionDate;
    private LocalDate endDate;
    private String deliveryMethod;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MedicineOrder> medicineOrders;



}
