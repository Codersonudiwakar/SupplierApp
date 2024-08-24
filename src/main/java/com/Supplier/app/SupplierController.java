package com.Supplier.app;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("/query")
    public ResponseEntity<Page<Supplier>> searchSuppliers(@RequestBody SupplierQueryRequest request) {

        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        Page<Supplier> result = supplierService.searchSuppliers(
            request.getLocation(),
            request.getNatureOfBusiness(), 
            request.getManufacturingProcesses(),
            pageable
        );
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}




