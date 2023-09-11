package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
	// Define the custom query method to find suppliers by type
//    List<Supplier> findByType(String type);
	Page<Supplier> findByType(String type, Pageable pageable);

	Page<Supplier> findByTypeOrderByDateDesc(String type, Pageable pageable);

	@Query("SELECT COUNT(s) FROM Supplier s WHERE s.type = 'telecom'")
	Long countTelecomSuppliers();

	@Query("SELECT COUNT(s) FROM Supplier s WHERE s.type = 'orange'")
	Long countOrangeSuppliers();

	@Query("SELECT COUNT(s) FROM Supplier s WHERE s.type = 'ooredoo'")
	Long countOoredooSuppliers();
	
	
//week
	@Query("SELECT COUNT(s) FROM Supplier s WHERE s.type = 'telecom' AND s.date >= ?1")
	Long countTelecomSuppliersByWeek(Date weekStartDate);

	@Query("SELECT COUNT(s) FROM Supplier s WHERE s.type = 'Orange' or s.type='orange' AND s.date >= ?1")
	Long countOrangeSuppliersByWeek(Date weekStartDate);

	@Query("SELECT COUNT(s) FROM Supplier s WHERE s.type = 'Ooredoo' or s.type = 'ooredoo' AND s.date >= ?1")
	Long countOoredooSuppliersByWeek(Date weekStartDate);
	
	
//month
	@Query("SELECT COUNT(s) FROM Supplier s WHERE s.type = 'telecom' AND s.date >= ?1")
	Long countTelecomSuppliersByMonth(Date startDate);

	@Query("SELECT COUNT(s) FROM Supplier s WHERE s.type = 'orange' AND s.date >= ?1")
	Long countOrangeSuppliersByMonth(Date startDate);

	@Query("SELECT COUNT(s) FROM Supplier s WHERE s.type = 'ooredoo' AND s.date >= ?1")
	Long countOoredooSuppliersByMonth(Date startDate);

	
	
	@Query("SELECT COUNT(s) FROM Supplier s WHERE  s.date >= ?1")
	Long countTotalByWeekSuppliers(Date weekStartDate);

	@Query("SELECT COUNT(s) FROM Supplier s WHERE  s.date >= ?1")
	Long countSuppliersByMonth(Date startDate);
	

}
