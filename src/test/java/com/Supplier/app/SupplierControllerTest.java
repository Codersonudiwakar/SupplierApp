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

public class SupplierControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private SupplierService supplierService;

    @InjectMocks
    private SupplierController supplierController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
    }

    @Test
    void testSearchSuppliers() throws Exception {
        // Arrange
        SupplierQueryRequest request = new SupplierQueryRequest();
        request.setLocation("New York");
        request.setNatureOfBusiness("MANUFACTURING");
        request.setManufacturingProcesses(Set.of("Process1", "Process2"));
        request.setPage(0);
        request.setSize(10);

  //      NatureOfBusiness natureOfBusiness = mock(NatureOfBusiness.class);
        Pageable pageable = PageRequest.of(0, 10);
        Page<Supplier> expectedPage = new PageImpl<>(List.of(new Supplier(), new Supplier()));

        when(supplierService.searchSuppliers(
                request.getLocation(),
                request.getNatureOfBusiness(),
                request.getManufacturingProcesses(),
                pageable
        )).thenReturn(expectedPage);
        supplierController.searchSuppliers(request);
       
    }
}
