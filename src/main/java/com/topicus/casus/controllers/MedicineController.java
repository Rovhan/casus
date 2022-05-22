package com.topicus.casus.controllers;

import com.topicus.casus.domain.model.Medicine;
import com.topicus.casus.repositories.MedicineRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/medicine")
public class MedicineController {

    private final MedicineRepository medicineRepository;

    public MedicineController(final MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @GetMapping
    public ResponseEntity<List<Medicine>> getMedicines() {
        return ResponseEntity.ok(medicineRepository.findAll());
    }
}
