package com.Supplier.app;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public class SupplierServiceTest {

    @InjectMocks
    private SupplierService supplierService;

    @Mock
    private SupplierRepository supplierRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
  public   void testSearchSuppliers() {
        // Arrange
        String location = "New York";
        String natureOfBusinessStr =  "SMALL_SCALE";
        Set<String> processes = Set.of("Process1", "Process2");
        Pageable pageable = Pageable.ofSize(10);

        NatureOfBusiness natureOfBusiness =mock(NatureOfBusiness.class);
        
        Page<Supplier> expectedPage = new PageImpl<>(List.of(new Supplier(), new Supplier()));

        when(supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcessesIn(
                Mockito.anyString(), Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(expectedPage);
        when(natureOfBusiness.toString()).thenReturn(natureOfBusinessStr);
        // Act
        Page<Supplier> actualPage = supplierService.searchSuppliers(location, natureOfBusinessStr, processes, pageable);

        // Assert
        // Check that the actual page content matches the expected page content
        assertThat(actualPage.getContent()).isEqualTo(expectedPage.getContent());
        // Verify that the repository method was called with the correct parameters
//        verify(supplierRepository).findByLocationAndNatureOfBusinessAndManufacturingProcessesIn(
//                location, natureOfBusiness, processes, pageable);
    }

}
