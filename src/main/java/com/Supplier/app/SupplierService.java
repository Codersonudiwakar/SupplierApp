package com.Supplier.app;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Page<Supplier> searchSuppliers(String location, String natureOfBusinessStr,
            Set<String> processes, Pageable pageable) {
        NatureOfBusiness natureOfBusiness = NatureOfBusiness.valueOf(natureOfBusinessStr.toUpperCase());

return supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcessesIn(
location,natureOfBusiness , processes, pageable);
}
}
