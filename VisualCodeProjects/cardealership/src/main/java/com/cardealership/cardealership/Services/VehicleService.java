package com.cardealership.cardealership.Services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cardealership.cardealership.dto.CreateVehicleDTO;
import com.cardealership.cardealership.infrastructure.VehicleRepository;
import com.cardealership.cardealership.models.Vehicles;
import com.cardealership.cardealership.infrastructure.ModelRepository;
import com.cardealership.cardealership.infrastructure.TrimRepository;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final ModelRepository modelRepository;
    private final TrimRepository trimRepository;

    public VehicleService(
            VehicleRepository vehicleRepository, 
            ModelRepository modelRepository,
            TrimRepository trimRepository) {
        this.vehicleRepository = vehicleRepository;
        this.modelRepository = modelRepository;
        this.trimRepository = trimRepository;
    }

    @Transactional
    public Vehicles createVehicle(CreateVehicleDTO dto) {
        // Validaciones básicas
        if (vehicleRepository.existsByVin(dto.vin())) {
            throw new IllegalArgumentException("Ya existe un vehículo con este VIN");
        }

        if (vehicleRepository.existsByStockCode(dto.stockCode())) {
            throw new IllegalArgumentException("Ya existe un vehículo con este código de stock");
        }

        // Obtener modelo y trim
        var model = modelRepository.findById(dto.modelId())
            .orElseThrow(() -> new IllegalArgumentException("Modelo no encontrado"));
            
        var trim = trimRepository.findById(dto.trimId())
            .orElseThrow(() -> new IllegalArgumentException("Trim no encontrado"));

        if(model.getId() != (trim.getModel().getId())){
            throw new IllegalArgumentException("El modelo no es el mismo que esta asignado al Trim, vuelva a intentarlo");
        }


        // Crear nuevo vehículo
        var vehicle = new Vehicles(
            dto.vin(),
            dto.stockCode(),
            model,
            trim,
            dto.modelYear(),
            dto.exteriorColor(),
            dto.interiorColor(),
            dto.transmission(),
            dto.fuelType(),
            dto.drivetrain(),
            dto.bodyType(),
            dto.doors(),
            dto.seats(),
            dto.odometerKm(),
            dto.condition(),
            dto.status(),
            dto.costPrice(),
            dto.listPrice()
        );

        return vehicleRepository.save(vehicle);
    }

    @Transactional(readOnly = true)
    public Vehicles getVehicleByVin(String vin) {
        return vehicleRepository.findByVin(vin)
            .orElseThrow(() -> new IllegalArgumentException("Vehículo no encontrado"));
    }

    @Transactional
    public Vehicles updateVehicle(Long id, CreateVehicleDTO dto) {
        var existingVehicle = vehicleRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Vehículo no encontrado"));

        // Validar VIN único si cambió
        if (!existingVehicle.getVin().equals(dto.vin()) && 
            vehicleRepository.existsByVin(dto.vin())) {
            throw new IllegalArgumentException("VIN ya existe");
        }

        // Actualizar campos
        var model = modelRepository.findById(dto.modelId())
            .orElseThrow(() -> new IllegalArgumentException("Modelo no encontrado"));
            
        var trim = trimRepository.findById(dto.trimId())
            .orElseThrow(() -> new IllegalArgumentException("Trim no encontrado"));

        // Actualizar propiedades
        existingVehicle.setVin(dto.vin());
        existingVehicle.setStockCode(dto.stockCode());
        existingVehicle.setModel(model);
        existingVehicle.setTrim(trim);
        existingVehicle.setModelYear(dto.modelYear());
        existingVehicle.setExteriorColor(dto.exteriorColor());
        existingVehicle.setInteriorColor(dto.interiorColor());
        // ... actualizar resto de propiedades

        return vehicleRepository.save(existingVehicle);
    }

    @Transactional
    public void deleteVehicle(Long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new IllegalArgumentException("Vehículo no encontrado");
        }
        vehicleRepository.deleteById(id);
    }
}