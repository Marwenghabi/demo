package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Supplier;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	private final SupplierRepository supplierRepository;

	@Autowired
	public SupplierServiceImpl(SupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}

	public List<Supplier> getAllSuppliers() {
		return supplierRepository.findAll();
	}

//    @Override
//    public Page<Supplier> getTelecomSuppliers(int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);      
//        return supplierRepository.findByType("Telecom", pageable);
//    }
//    
//    
//    @Override
//    public Page<Supplier> getOrangeSuppliers(int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        return supplierRepository.findByType("Orange", pageable);
//    }
//    
//    @Override
//    public Page<Supplier> getOoredooSuppliers(int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        return supplierRepository.findByType("Ooredoo", pageable);
//    }

	@Override
	public Page<Supplier> getAllTelecomSuppliersOrderedByDate(Pageable pageable) {
		return supplierRepository.findByTypeOrderByDateDesc("Telecom", pageable);
	}

	@Override
	public Page<Supplier> getAllOrangeSuppliersOrderedByDate(Pageable pageable) {
		return supplierRepository.findByTypeOrderByDateDesc("Orange", pageable);
	}

	@Override
	public Page<Supplier> getAllOoredooSuppliersOrderedByDate(Pageable pageable) {
		return supplierRepository.findByTypeOrderByDateDesc("Ooredoo", pageable);
	}

	@Override
	public Long countTotalByWeekSuppliers(Date startDate) {
		return supplierRepository.countTotalByWeekSuppliers(startDate);

	}

	@Override
	public Long countSuppliersByMonth(Date startDate) {
		return supplierRepository.countSuppliersByMonth(startDate);
	}

	@Override
	public Long countTelecomSuppliers() {
		return supplierRepository.countTelecomSuppliers();
	}

	@Override
	public Long countOrangeSuppliers() {
		return supplierRepository.countOrangeSuppliers();
	}

	@Override
	public Long countOoredooSuppliers() {
		return supplierRepository.countOoredooSuppliers();
	}

	@Override
	public Long countTelecomSuppliersByWeek(Date startDate) {
		return supplierRepository.countTelecomSuppliersByWeek(startDate);
	}

	@Override
	public Long countOrangeSuppliersByWeek(Date startDate) {
		return supplierRepository.countTelecomSuppliersByWeek(startDate);
	}

	@Override
	public Long countOoredooSuppliersByWeek(Date startDate) {
		return supplierRepository.countTelecomSuppliersByWeek(startDate);
	}

	@Override
	public Long countTelecomSuppliersByMonth(Date startDate) {
		return supplierRepository.countTelecomSuppliersByMonth(startDate);
	}

	@Override
	public Long countOrangeSuppliersByMonth(Date startDate) {
		return supplierRepository.countTelecomSuppliersByMonth(startDate);
	}

	@Override
	public Long countOoredooSuppliersByMonth(Date startDate) {
		return supplierRepository.countTelecomSuppliersByMonth(startDate);
	}

	@Override
	public Supplier getSupplierById(Long id) {
		return supplierRepository.findById(id).orElse(null);
	}

	@Override
	public String addSupplier(Supplier supplier) {
		supplierRepository.save(supplier);
		return "Supplier added successfully";
	}

	@Override
	public String updateSupplier(Long id, Supplier supplier) {
		Optional<Supplier> existingSupplierOptional = supplierRepository.findById(id);
		if (existingSupplierOptional.isPresent()) {
			Supplier existingSupplier = existingSupplierOptional.get();

			existingSupplier.setMessage(supplier.getMessage());
			existingSupplier.setType(supplier.getType());
			existingSupplier.setPhoneNumber(supplier.getPhoneNumber());
			existingSupplier.setDate(supplier.getDate());
			// Set other fields as needed
			supplierRepository.save(existingSupplier);
			return "Supplier updated successfully";
		} else {
			return "Supplier not found";
		}
	}

	@Override
	public String deleteSupplier(Long id) {
		Optional<Supplier> supplierOptional = supplierRepository.findById(id);
		if (supplierOptional.isPresent()) {
			supplierRepository.delete(supplierOptional.get());
			return "Supplier deleted successfully";
		} else {
			return "Supplier not found";
		}
	}
}
