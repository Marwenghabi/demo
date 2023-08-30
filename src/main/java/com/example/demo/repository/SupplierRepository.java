package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    // Define the custom query method to find suppliers by type
//    List<Supplier> findByType(String type);
	 Page<Supplier> findByType(String type, Pageable pageable);
}
