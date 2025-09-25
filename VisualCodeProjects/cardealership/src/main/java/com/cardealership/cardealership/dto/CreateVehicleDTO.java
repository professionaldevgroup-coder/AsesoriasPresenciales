package com.cardealership.cardealership.dto;

import java.math.BigDecimal;

public record CreateVehicleDTO(
    String vin,
    String stockCode,
    Long modelId,      // ID del modelo en lugar del nombre
    Long trimId,       // ID del trim en lugar del nombre
    Integer modelYear,
    String exteriorColor,
    String interiorColor,
    String transmission,
    String fuelType,
    String drivetrain,
    String bodyType,
    Short doors,
    Short seats,
    BigDecimal odometerKm,
    String condition,
    String status,
    BigDecimal costPrice,
    BigDecimal listPrice
) {}