package com.cardealership.cardealership.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardealership.cardealership.Services.BrandService;
import com.cardealership.cardealership.dto.VehicleDTO;
import com.cardealership.cardealership.infrastructure.BrandRepository;
import com.cardealership.cardealership.models.Brands;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/brands")
@Tag(name = "Brands", description = "Endpoints for managing Brands")
@CrossOrigin(origins = "*")
public class BrandController {
    private final BrandRepository brandRepository;
    private final BrandService brandService;

    @Autowired
    public BrandController(BrandRepository brandRepository, BrandService brandService) {
        this.brandRepository = brandRepository;
        this.brandService = brandService;
    }

    @GetMapping("/getAllBrands")
    @Operation(summary = "Get all brands", description = "Retrieves a list of all brands in the system")
    public ResponseEntity<List<Brands>> getAllBrands() {
        List<Brands> brands = brandRepository.findAll().stream().toList();
        return ResponseEntity.ok(brands);
    }

    @PostMapping("/createBrand")
    public ResponseEntity<String> createBrand(@RequestBody String brandNameString) {
        try {
            var brandCreate = brandService.addBrand(brandNameString);

            if (brandCreate) {
                return ResponseEntity.ok(brandNameString);
            }

            return ResponseEntity.internalServerError().body("Error to insert the Brand name");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

}
