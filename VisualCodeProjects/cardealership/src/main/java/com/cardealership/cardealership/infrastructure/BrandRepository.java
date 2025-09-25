package com.cardealership.cardealership.infrastructure;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cardealership.cardealership.models.Brands;

public interface BrandRepository extends JpaRepository<Brands, Long> {
    @Override
    @EntityGraph()
    List<Brands> findAll();

    @Override
    @EntityGraph()
    Brands saveAndFlush(Brands brand);

    Brands findByName(String name);

}
