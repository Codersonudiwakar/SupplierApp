package com.Supplier.app;

import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Set;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Page<Supplier> findByLocationAndNatureOfBusinessAndManufacturingProcessesIn(
        String location, 
        NatureOfBusiness natureOfBusiness, 
        Set<String> manufacturingProcesses,
        Pageable pageable
    );
}


