package com.example.demo.service;

import com.example.demo.entity.Supplier;

import org.springframework.data.domain.Pageable;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

public interface SupplierService {

	List<Supplier> getAllSuppliers();

	Supplier getSupplierById(Long id);

	String addSupplier(Supplier supplier);

	String updateSupplier(Long id, Supplier supplier);

	String deleteSupplier(Long id);

//	Page<Supplier> getTelecomSuppliers(int page, int size);
//	
//
//	Page<Supplier> getOrangeSuppliers(int page, int size);
//
//	Page<Supplier> getOoredooSuppliers(int page, int size);

	Long countTelecomSuppliers();

	Long countOrangeSuppliers();

	Long countOoredooSuppliers();

	Long countTelecomSuppliersByWeek(Date startDate);

	Long countOrangeSuppliersByWeek(Date startDate);

	Long countOoredooSuppliersByWeek(Date startDate);

	Long countTelecomSuppliersByMonth(Date startDate);

	Long countOrangeSuppliersByMonth(Date startDate);

	Long countOoredooSuppliersByMonth(Date startDate);

	Page<Supplier> getAllTelecomSuppliersOrderedByDate(Pageable pageable);

	Page<Supplier> getAllOrangeSuppliersOrderedByDate(Pageable pageable);

	Page<Supplier> getAllOoredooSuppliersOrderedByDate(Pageable pageable);

	Long countTotalByWeekSuppliers(Date startDate);

	Long countSuppliersByMonth(Date startDate);
}
