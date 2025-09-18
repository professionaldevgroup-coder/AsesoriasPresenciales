package com.cardealership.cardealership.infrastructure;

import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cardealership.cardealership.models.Vehicles;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicles, Long> {
    @Override
    @EntityGraph(attributePaths = {"model", "model.brand", "trim"})
    List<Vehicles> findAll();

    @EntityGraph(attributePaths = {"model", "model.brand", "trim"})
    List<Vehicles> findByModel_Brand_Name(String brandName);
}