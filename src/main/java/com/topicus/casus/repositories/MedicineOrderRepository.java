package com.topicus.casus.repositories;

import com.topicus.casus.domain.model.MedicineOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineOrderRepository extends JpaRepository<MedicineOrder, Long> {
}
