package com.example.demo.controller;

import com.example.demo.dto.RandomPhoneNumber;
import com.example.demo.dto.RandomPhoneNumberResponse;
import com.example.demo.entity.Supplier;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/suppliers")
@Api(tags = "Suppliers")
public class SuppliersController {

    private final SupplierService supplierService;
    @Autowired
    private SupplierRepository supplierRepository;

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
    
    @GetMapping("/total-telecom")
    @ApiOperation(value = "Get the total count of telecom suppliers")
    public ResponseEntity<Long> countTelecomSuppliers() {
        Long count = supplierService.countTelecomSuppliers();
        return ResponseEntity.ok(count);
    }
    
    @GetMapping("/total-orange")
    @ApiOperation(value = "Get the total count of orange suppliers")
    public ResponseEntity<Long> countOrangeSuppliers() {
        Long count = supplierService.countOrangeSuppliers();
        return ResponseEntity.ok(count);
    }
    
    @GetMapping("/total-ooredoo")
    @ApiOperation(value = "Get the total count of ooredoo suppliers")
    public ResponseEntity<Long> countOoredooSuppliers() {
        Long count = supplierService.countOoredooSuppliers();
        return ResponseEntity.ok(count);
    }
    
    @GetMapping("/telecom-total-week")
    @ApiOperation(value = "Get the total count of telecom suppliers for the current week")
    public ResponseEntity<Long> countTelecomSuppliersByWeek() {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        Date startOfWeek = calendar.getTime();
        Long count = supplierService.countTelecomSuppliersByWeek(startOfWeek);
        return ResponseEntity.ok(count);
    }
    
    @GetMapping("/orange-total-week")
    @ApiOperation(value = "Get the total count of orange suppliers for the current week")
    public ResponseEntity<Long> countOrangeSuppliersByWeek() {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        Date startOfWeek = calendar.getTime();
        Long count = supplierService.countOrangeSuppliersByWeek(startOfWeek);
        return ResponseEntity.ok(count);
    }
    
    @GetMapping("/ooredoo-total-week")
    @ApiOperation(value = "Get the total count of ooredoo suppliers for the current week")
    public ResponseEntity<Long> countOoredooSuppliersByWeek() {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        Date startOfWeek = calendar.getTime();
        Long count = supplierService.countOoredooSuppliersByWeek(startOfWeek);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/telecom-total-month")
    @ApiOperation(value = "Get the total count of telecom suppliers for the current month")
    public ResponseEntity<Long> countTelecomSuppliersByMonth() {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startOfMonth = calendar.getTime();
        Long count = supplierService.countTelecomSuppliersByMonth(startOfMonth);
        return ResponseEntity.ok(count);
    }
    
    
    @GetMapping("/orange-total-month")
    @ApiOperation(value = "Get the total count of orange suppliers for the current month")
    public ResponseEntity<Long> countOrangeSuppliersByMonth() {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startOfMonth = calendar.getTime();
        Long count = supplierService.countOrangeSuppliersByMonth(startOfMonth);
        return ResponseEntity.ok(count);
    }
    
    @GetMapping("/ooredoo-total-month")
    @ApiOperation(value = "Get the total count of ooredo suppliers for the current month")
    public ResponseEntity<Long> countOoredooSuppliersByMonth() {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startOfMonth = calendar.getTime();
        Long count = supplierService.countOoredooSuppliersByMonth(startOfMonth);
        return ResponseEntity.ok(count);
    }
    
    
    @GetMapping("/randomPhoneNumber")
    public ResponseEntity<RandomPhoneNumberResponse> getRandomPhoneNumber() {
        List<Supplier> suppliers = supplierRepository.findAll();
        if (suppliers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new RandomPhoneNumberResponse("No phone numbers available.", null));
        }

        int randomIndex = new Random().nextInt(suppliers.size());
        Supplier randomSupplier = suppliers.get(randomIndex);

        RandomPhoneNumberResponse response = new RandomPhoneNumberResponse("Success", new RandomPhoneNumber(randomSupplier.getType(), randomSupplier.getPhoneNumber()));
        return ResponseEntity.ok(response);
    }
    
//    @GetMapping("/randomPhoneNumber")
//    public String getRandomPhoneNumber() {
//        List<Supplier> suppliers = supplierRepository.findAll();
//        if (suppliers.isEmpty()) {
//            return "No phone numbers available.";
//        }
//
//        int randomIndex = new Random().nextInt(suppliers.size());
//        Supplier randomSupplier = suppliers.get(randomIndex);
//
//        return randomSupplier.getPhoneNumber();
//    }

//    @GetMapping("/{id}")
//    @ApiOperation(value = "Get a supplier by ID")
//    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
//        Supplier supplier = supplierService.getSupplierById(id);
//        if (supplier != null) {
//            return ResponseEntity.ok(supplier);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PutMapping("/{id}")
//    @ApiOperation(value = "Update a supplier")
//    public ResponseEntity<String> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
//        String response = supplierService.updateSupplier(id, supplier);
//        return ResponseEntity.ok(response);
//    }
//
//    @DeleteMapping("/{id}")
//    @ApiOperation(value = "Delete a supplier")
//    public ResponseEntity<String> deleteSupplier(@PathVariable Long id) {
//        String response = supplierService.deleteSupplier(id);
//        return ResponseEntity.ok(response);
//    }
}
