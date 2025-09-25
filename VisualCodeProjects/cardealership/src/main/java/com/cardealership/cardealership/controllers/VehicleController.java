package com.cardealership.cardealership.controllers;

import com.cardealership.cardealership.dto.CreateVehicleDTO;
import com.cardealership.cardealership.dto.VehicleDTO;
import com.cardealership.cardealership.models.Vehicles;
import com.cardealership.cardealership.infrastructure.VehicleRepository;
import com.cardealership.cardealership.Services.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vehicles")
@CrossOrigin(origins = "*")
@Tag(name = "Vehicles", description = "Endpoints for managing vehicles")
public class VehicleController {

    private final VehicleRepository vehicleRepository;
    private final VehicleService vehicleService;

    public VehicleController(VehicleRepository vehicleRepository, VehicleService vehicleService) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleService = vehicleService;
    }
    
    @GetMapping("/getAllVehicles")
    @Operation(summary = "Get all vehicles", description = "Retrieves a list of all vehicles in the system")
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        List<VehicleDTO> vehicles = vehicleRepository.findAll().stream()
            .map(VehicleDTO::new)
            .collect(Collectors.toList());
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/getVehicle/{id}")
    @Operation(summary = "Get a vehicle by ID", description = "Retrieves a specific vehicle by its ID")
    @Transactional(readOnly = true)
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable Long id) {
        return vehicleRepository.findById(id)
                .map(vehicle -> ResponseEntity.ok(new VehicleDTO(vehicle)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/brand/{brandName}")
    @Operation(summary = "Get vehicles by brand", description = "Retrieves all vehicles of a specific brand")
    @Transactional(readOnly = true)
    public ResponseEntity<List<VehicleDTO>> getVehiclesByBrand(@PathVariable String brandName) {
        List<VehicleDTO> vehicles = vehicleRepository.findByModel_Brand_Name(brandName).stream()
            .map(VehicleDTO::new)
            .collect(Collectors.toList());
        return ResponseEntity.ok(vehicles);
    }

    @PostMapping("/createVehicle")
    @Operation(summary = "Create a new vehicle", description = "Adds a new vehicle to the system")
    public ResponseEntity<?> createVehicle(@RequestBody CreateVehicleDTO createDTO) {
        try {
            // Aquí irá la lógica para convertir CreateVehicleDTO a Vehicle
            Vehicles vehicle = vehicleService.createVehicle(createDTO);
            return ResponseEntity.ok(new VehicleDTO(vehicle));
        } catch (Exception e) {
            return ResponseEntity
                .internalServerError()
                .body("Ocurrió un error al crear el vehículo: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a vehicle", description = "Updates an existing vehicle's information")
    public ResponseEntity<Vehicles> updateVehicle(@PathVariable Long id, @RequestBody Vehicles vehicle) {
        if (!vehicleRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        vehicle.setId(id);
        return ResponseEntity.ok(vehicleRepository.save(vehicle));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a vehicle", description = "Removes a vehicle from the system")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        if (!vehicleRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        vehicleRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
