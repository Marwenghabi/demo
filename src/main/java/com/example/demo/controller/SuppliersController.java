package com.example.demo.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RandomPhoneNumber;
import com.example.demo.dto.RandomPhoneNumberResponse;
import com.example.demo.entity.Supplier;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/suppliers")
@CrossOrigin(origins = "http://localhost:3000/", exposedHeaders = "Authorization")
@Api(value = "Suppliers", description = "API to manage suppliers")
public class SuppliersController {

	private final SupplierService supplierService;
	@Autowired
	private SupplierRepository supplierRepository;

	@Autowired
	public SuppliersController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	@GetMapping("/all")
	@ApiOperation(value = "Get all suppliers", response = Supplier.class)
	public ResponseEntity<List<Supplier>> getAllSuppliers() {
		List<Supplier> suppliers = supplierService.getAllSuppliers();
		return ResponseEntity.ok(suppliers);
	}

	@PostMapping("/add")
	@ApiOperation(value = "Add a new supplier", response = Supplier.class)
	public ResponseEntity<String> addSupplier(@RequestBody Supplier supplier) {
		String response = supplierService.addSupplier(supplier);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/telecom")
	@ApiOperation(value = "Get telecom suppliers , Retrieve a paginated list of telecom suppliers.", response = Supplier.class)
	public Page<Supplier> getAllTelecomSuppliersOrderedByDate(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size, Pageable pageable) {
		return supplierService.getAllTelecomSuppliersOrderedByDate(pageable);
	}

	@GetMapping("/orange")
	@ApiOperation(value = "Get orange suppliers Retrieve a paginated list of orange suppliers.", response = Supplier.class)
	public Page<Supplier> getAllOrangeSuppliersOrderedByDate(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size, Pageable pageable) {
		return supplierService.getAllOrangeSuppliersOrderedByDate(pageable);
	}

	@GetMapping("/ooredoo")
	@ApiOperation(value = "Get ooredoo suppliers, Retrieve a paginated list of ooredoo suppliers.", response = Supplier.class)
	public Page<Supplier> getAllOoredooSuppliersOrderedByDate(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size, Pageable pageable) {
		return supplierService.getAllOoredooSuppliersOrderedByDate(pageable);
	}

	@GetMapping("/total-week")
	@ApiOperation(value = "Get the total count of  suppliers for the current week", response = Supplier.class)
	public ResponseEntity<Long> countTotalSuppliersByWeek() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
		Date startOfWeek = calendar.getTime();
		Long count = supplierService.countTotalByWeekSuppliers(startOfWeek);
		return ResponseEntity.ok(count);
	}

	@GetMapping("/total-month")
	@ApiOperation(value = "Get the total count of suppliers for the current month", response = Supplier.class)
	public ResponseEntity<Long> countSuppliersByMonth() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date startOfMonth = calendar.getTime();
		Long count = supplierService.countSuppliersByMonth(startOfMonth);
		return ResponseEntity.ok(count);
	}

	@GetMapping("/total-year")
	@ApiOperation(value = "Get the total count of suppliers for the current year", response = Supplier.class)
	public ResponseEntity<Long> countTotalByYearSuppliers() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date startOfYear = calendar.getTime();
		Long count = supplierService.countSuppliersByMonth(startOfYear);
		return ResponseEntity.ok(count);
	}

	// suppliers telecom
	@GetMapping("/total-telecom")
	@ApiOperation(value = "Get the total count of telecom suppliers", response = Supplier.class)
	public ResponseEntity<Long> countTelecomSuppliers() {
		Long count = supplierService.countTelecomSuppliers();
		return ResponseEntity.ok(count);
	}

	@GetMapping("/telecom-total-week")
	@ApiOperation(value = "Get the total count of telecom suppliers for the current week", response = Supplier.class)
	public ResponseEntity<Long> countTelecomSuppliersByWeek() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
		Date startOfWeek = calendar.getTime();
		Long count = supplierService.countTelecomSuppliersByWeek(startOfWeek);
		return ResponseEntity.ok(count);
	}

	@GetMapping("/telecom-total-month")
	@ApiOperation(value = "Get the total count of suppliers for the current month", response = Supplier.class)
	public ResponseEntity<Long> countTelecomSuppliersByMonth() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date startOfMonth = calendar.getTime();
		Long count = supplierService.countTelecomSuppliersByMonth(startOfMonth);
		return ResponseEntity.ok(count);
	}

	@GetMapping("/telecom-total-year")
	@ApiOperation(value = "Get the total count of telecom suppliers for the current year", response = Supplier.class)
	public ResponseEntity<Long> countTelecomSuppliersByYear() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date startOfYear = calendar.getTime();
		Long count = supplierService.countTelecomSuppliersByMonth(startOfYear);
		return ResponseEntity.ok(count);
	}

	@GetMapping("/telecom-percentage-week")
	@ApiOperation(value = "Get the percentage of telecom suppliers for the current week", response = Double.class)
	public ResponseEntity<Double> getTelecomPercentageByWeek() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
		Date startOfWeek = calendar.getTime();
		Long totalTelecom = supplierService.countTelecomSuppliersByWeek(startOfWeek);
		Long totalAllSuppliers = supplierService.countTotalByWeekSuppliers(startOfWeek);
		double percentage = (totalTelecom * 100.0) / totalAllSuppliers;
		return ResponseEntity.ok(percentage);
	}

	@GetMapping("/telecom-percentage-month")
	@ApiOperation(value = "Get the percentage of telecom suppliers for the current month", response = Double.class)
	public ResponseEntity<Double> getTelecomPercentageByMonth() {
		Date now = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date startOfMonth = calendar.getTime();
		Long totalTelecom = supplierService.countTelecomSuppliersByWeek(startOfMonth);
		Long totalAllSuppliers = supplierService.countTotalByWeekSuppliers(startOfMonth);
		double percentage = (totalTelecom * 100.0) / totalAllSuppliers;
		return ResponseEntity.ok(percentage);
	}

	@GetMapping("/telecom-percentage-year")
	@ApiOperation(value = "Get the percentage of telecom suppliers for the current year", response = Supplier.class)
	public ResponseEntity<Double> getTelecomPercentageByYear() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date startOfYear = calendar.getTime();
		Long count = supplierService.countTelecomSuppliersByMonth(startOfYear);
		Long totalAllSuppliers = supplierService.countSuppliersByMonth(startOfYear);
		double percentage = (count * 100.0) / totalAllSuppliers;
		return ResponseEntity.ok(percentage);
	}

	// Rest APIS orange suppliers
	@GetMapping("/total-orange")
	@ApiOperation(value = "Get the total count of orange suppliers", response = Supplier.class)
	public ResponseEntity<Long> countOrangeSuppliers() {
		Long count = supplierService.countOrangeSuppliers();
		return ResponseEntity.ok(count);
	}

	@GetMapping("/orange-total-week")
	@ApiOperation(value = "Get the total count of orange suppliers for the current week", response = Supplier.class)
	public ResponseEntity<Long> countOrangeSuppliersByWeek() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
		Date startOfWeek = calendar.getTime();
		Long count = supplierService.countOrangeSuppliersByWeek(startOfWeek);
		return ResponseEntity.ok(count);
	}

	@GetMapping("/orange-total-month")
	@ApiOperation(value = "Get the total count of orange suppliers for the current month", response = Supplier.class)
	public ResponseEntity<Long> countOrangeSuppliersByMonth() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date startOfMonth = calendar.getTime();
		Long count = supplierService.countOrangeSuppliersByMonth(startOfMonth);
		return ResponseEntity.ok(count);

	}

	@GetMapping("/orange-total-year")
	@ApiOperation(value = "Get the total count of orange suppliers for the current year", response = Supplier.class)
	public ResponseEntity<Long> countOrangeSuppliersByYear() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date startOfYear = calendar.getTime();
		Long count = supplierService.countOrangeSuppliersByMonth(startOfYear);
		return ResponseEntity.ok(count);
	}

	@GetMapping("/orange-percentage-week")
	@ApiOperation(value = "Get the percentage of orange suppliers for the current week", response = Double.class)
	public ResponseEntity<Double> getOrangePercentageByWeek() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
		Date startOfWeek = calendar.getTime();
		Long totalOrange = supplierService.countOrangeSuppliersByWeek(startOfWeek);
		Long totalAllSuppliers = supplierService.countTotalByWeekSuppliers(startOfWeek);
		double percentage = (totalOrange * 100.0) / totalAllSuppliers;
		return ResponseEntity.ok(percentage);
	}

	@GetMapping("/orange-percentage-month")
	@ApiOperation(value = "Get the percentage of orange suppliers for the current month", response = Double.class)
	public ResponseEntity<Double> getOrangePercentageByMonth() {
		Date now = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date startOfMonth = calendar.getTime();
		Long totalOrange = supplierService.countOrangeSuppliersByMonth(startOfMonth);
		Long totalAllSuppliers = supplierService.countTotalByWeekSuppliers(startOfMonth);
		double percentage = (totalOrange * 100.0) / totalAllSuppliers;
		return ResponseEntity.ok(percentage);
	}

	@GetMapping("/orange-percentage-year")
	@ApiOperation(value = "Get the percentage of orange suppliers for the current year", response = Supplier.class)
	public ResponseEntity<Double> getOrangePercentageByYear() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date startOfYear = calendar.getTime();
		Long count = supplierService.countOrangeSuppliersByMonth(startOfYear);
		Long totalAllSuppliers = supplierService.countSuppliersByMonth(startOfYear);
		double percentage = (count * 100.0) / totalAllSuppliers;
		return ResponseEntity.ok(percentage);
	}

	// Rest APIS Ooredoo suppliers
	@GetMapping("/total-ooredoo")
	@ApiOperation(value = "Get the total count of ooredoo suppliers", response = Supplier.class)
	public ResponseEntity<Long> countOoredooSuppliers() {
		Long count = supplierService.countOoredooSuppliers();
		return ResponseEntity.ok(count);
	}

	@GetMapping("/ooredoo-total-week")
	@ApiOperation(value = "Get the total count of ooredoo suppliers for the current week", response = Supplier.class)
	public ResponseEntity<Long> countOoredooSuppliersByWeek() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
		Date startOfWeek = calendar.getTime();
		Long count = supplierService.countOoredooSuppliersByWeek(startOfWeek);
		return ResponseEntity.ok(count);
	}

	@GetMapping("/ooredoo-total-month")
	@ApiOperation(value = "Get the total count of ooredo suppliers for the current month", response = Supplier.class)
	public ResponseEntity<Long> countOoredooSuppliersByMonth() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date startOfMonth = calendar.getTime();
		Long count = supplierService.countOoredooSuppliersByMonth(startOfMonth);
		return ResponseEntity.ok(count);
	}

	@GetMapping("/ooredoo-total-year")
	@ApiOperation(value = "Get the total count of ooredoo suppliers for the current year", response = Supplier.class)
	public ResponseEntity<Long> countOoredooSuppliersByYear() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date startOfYear = calendar.getTime();
		Long count = supplierService.countOoredooSuppliersByMonth(startOfYear);
		return ResponseEntity.ok(count);
	}

	@GetMapping("/ooredoo-percentage-week")
	@ApiOperation(value = "Get the percentage of ooredoo suppliers for the current week", response = Double.class)
	public ResponseEntity<Double> getOoredooPercentageByWeek() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
		Date startOfWeek = calendar.getTime();
		Long totalOoredoo = supplierService.countOoredooSuppliersByWeek(startOfWeek);
		Long totalAllSuppliers = supplierService.countTotalByWeekSuppliers(startOfWeek);
		double percentage = (totalOoredoo * 100.0) / totalAllSuppliers;
		return ResponseEntity.ok(percentage);
	}

	@GetMapping("/ooredoo-percentage-month")
	@ApiOperation(value = "Get the percentage of ooredoo suppliers for the current month", response = Double.class)
	public ResponseEntity<Double> getOoredooPercentageByMonth() {
		Date now = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date startOfMonth = calendar.getTime();
		Long totalOoredoo = supplierService.countOoredooSuppliersByMonth(startOfMonth);
		Long totalAllSuppliers = supplierService.countTotalByWeekSuppliers(startOfMonth);
		double percentage = (totalOoredoo * 100.0) / totalAllSuppliers;
		return ResponseEntity.ok(percentage);
	}

	@GetMapping("/ooredoo-percentage-year")
	@ApiOperation(value = "Get the percentage of ooredoo  suppliers for the current year", response = Supplier.class)
	public ResponseEntity<Double> getOoredooPercentageByYear() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date startOfYear = calendar.getTime();
		Long count = supplierService.countOoredooSuppliersByMonth(startOfYear);
		Long totalAllSuppliers = supplierService.countSuppliersByMonth(startOfYear);
		double percentage = (count * 100.0) / totalAllSuppliers;
		return ResponseEntity.ok(percentage);
	}

	// random phone number
	@GetMapping("/randomPhoneNumber")
	public ResponseEntity<RandomPhoneNumberResponse> getRandomPhoneNumber() {
		List<Supplier> suppliers = supplierRepository.findAll();
		if (suppliers.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new RandomPhoneNumberResponse("No phone numbers available.", null));
		}

		int randomIndex = new Random().nextInt(suppliers.size());
		Supplier randomSupplier = suppliers.get(randomIndex);

		RandomPhoneNumberResponse response = new RandomPhoneNumberResponse("Success",
				new RandomPhoneNumber(randomSupplier.getType(), randomSupplier.getPhoneNumber()));
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
