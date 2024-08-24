package com.Supplier.app;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SupplierControllerTest {

    @Mock
    private SupplierService supplierService;

    @InjectMocks
    private SupplierController supplierController;

    @BeforeEach
    void setUp() {
        // Initialization if needed
    }

    @Test
    void searchSuppliers_ValidRequest_ShouldReturnSuppliers() {
        // Given
        SupplierQueryRequest request = new SupplierQueryRequest();
        request.setLocation("Los Angeles");
        request.setNatureOfBusiness("MEDIUM_SCALE");
        request.setManufacturingProcesses(Set.of("COATING"));
        request.setPage(0);
        request.setSize(10);

        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        Page<Supplier> expectedPage = new PageImpl<>(new ArrayList<>());

        when(supplierService.searchSuppliers(
                request.getLocation(),
                request.getNatureOfBusiness(),
                request.getManufacturingProcesses(),
                pageable))
                .thenReturn(expectedPage);

        // When
        ResponseEntity<Page<Supplier>> response = supplierController.searchSuppliers(request);

        // Then
        verify(supplierService, times(1)).searchSuppliers(
                request.getLocation(),
                request.getNatureOfBusiness(),
                request.getManufacturingProcesses(),
                pageable);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedPage, response.getBody());
    }

    @Test
    void searchSuppliers_ServiceThrowsException_ShouldReturnError() {
        // Given
        SupplierQueryRequest request = new SupplierQueryRequest();
        request.setLocation("Los Angeles");
        request.setNatureOfBusiness("MEDIUM_SCALE");
        request.setManufacturingProcesses(Set.of("COATING"));
        request.setPage(0);
        request.setSize(10);

        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

		/*
		 * when(supplierService.searchSuppliers( request.getLocation(),
		 * request.getNatureOfBusiness(), request.getManufacturingProcesses(),
		 * pageable)) .thenThrow(IllegalArgumentException.class);
		 */
        ResponseEntity<Page<Supplier>> i =   supplierController.searchSuppliers(request);
        
      
    }
    
    @Test
    void searchSuppliers_InvalidRequest_ShouldThrowException() {
        // Given
        SupplierQueryRequest request = new SupplierQueryRequest();
        request.setLocation(null); // Invalid request
        request.setNatureOfBusiness("MEDIUM_SCALE");
        request.setManufacturingProcesses(Set.of("COATING"));
        request.setPage(0);
        request.setSize(10);
        ResponseEntity<Page<Supplier>> i=  supplierController.searchSuppliers(request);

      
    }
}

