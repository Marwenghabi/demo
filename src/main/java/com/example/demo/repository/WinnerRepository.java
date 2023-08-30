package com.example.demo.repository;

import com.example.demo.entity.Winner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WinnerRepository extends JpaRepository<Winner, Long> {

    // Vous pouvez ajouter des méthodes de requête personnalisées ici si nécessaire
}
