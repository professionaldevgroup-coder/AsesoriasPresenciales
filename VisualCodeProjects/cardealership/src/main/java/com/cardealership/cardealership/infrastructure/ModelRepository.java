package com.cardealership.cardealership.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cardealership.cardealership.models.Models;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Models, Long> {
    List<Models> findByBrandId(Long brandId);
    boolean existsByNameAndBrandId(String name, Long brandId);
}