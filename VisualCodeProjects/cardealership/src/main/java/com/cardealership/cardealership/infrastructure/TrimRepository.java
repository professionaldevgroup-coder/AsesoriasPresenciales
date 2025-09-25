package com.cardealership.cardealership.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cardealership.cardealership.models.Trims;

import java.util.List;

@Repository
public interface TrimRepository extends JpaRepository<Trims, Long> {
    List<Trims> findByModelId(Long modelId);
    boolean existsByNameAndModelId(String name, Long modelId);
}