package com.example.demo.controller;

import com.example.demo.entity.Supplier;
import com.example.demo.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@Api(tags = "Suppliers")
public class SuppliersController {

    private final SupplierService supplierService;

    @Autowired
    public SuppliersController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
    
   
    @GetMapping("/all")
    @ApiOperation(value = "Get all suppliers", notes = "Retrieve a list of all suppliers.")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        return ResponseEntity.ok(suppliers);
    }

    
    @PostMapping("/add")
    @ApiOperation(value = "Add a new supplier", notes = "Add a new supplier to the system.")
    public ResponseEntity<String> addSupplier(@RequestBody Supplier supplier) {
        String response = supplierService.addSupplier(supplier);
        return ResponseEntity.ok(response);
    }
    
    
    @GetMapping("/telecom")
    @ApiOperation(value = "Get telecom suppliers", notes = "Retrieve a paginated list of telecom suppliers.")
    public ResponseEntity<Page<Supplier>> getTelecomSuppliers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Supplier> telecomSuppliers = supplierService.getTelecomSuppliers(page, size);
        return ResponseEntity.ok(telecomSuppliers);
    }
    
    @GetMapping("/orange")
    @ApiOperation(value = "Get orange suppliers", notes = "Retrieve a paginated list of orange suppliers.")
    public ResponseEntity<Page<Supplier>> getOrangeSuppliers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Supplier> orangeSuppliers = supplierService.getOrangeSuppliers(page, size);
        return ResponseEntity.ok(orangeSuppliers);
    }
    
    @GetMapping("/ooredoo")
    @ApiOperation(value = "Get ooredoo suppliers", notes = "Retrieve a paginated list of ooredoo suppliers.")
    public ResponseEntity<Page<Supplier>> getOoredoSuppliers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Supplier> ooredooSuppliers = supplierService.getOoredooSuppliers(page, size);
        return ResponseEntity.ok(ooredooSuppliers);
    }
    
    
    
    @GetMapping("/{id}")
    @ApiOperation(value = "Get a supplier by ID")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        Supplier supplier = supplierService.getSupplierById(id);
        if (supplier != null) {
            return ResponseEntity.ok(supplier);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    

    @PutMapping("/{id}")
    @ApiOperation(value = "Update a supplier")
    public ResponseEntity<String> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        String response = supplierService.updateSupplier(id, supplier);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a supplier")
    public ResponseEntity<String> deleteSupplier(@PathVariable Long id) {
        String response = supplierService.deleteSupplier(id);
        return ResponseEntity.ok(response);
    }
}
