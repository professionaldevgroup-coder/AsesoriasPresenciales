package com.cardealership.cardealership.dto;

import java.math.BigDecimal;

public class VehicleDTO {
    private Long id;
    private String vin;
    private String stockCode;
    private String modelName;
    private String brandName;
    private String trimName;
    private Integer modelYear;
    private String exteriorColor;
    private String interiorColor;
    private String transmission;
    private String fuelType;
    private String drivetrain;
    private String bodyType;
    private Short doors;
    private Short seats;
    private BigDecimal odometerKm;
    private String condition;
    private String status;
    private BigDecimal listPrice;

    // Constructor from Vehicle entity
    public VehicleDTO(com.cardealership.cardealership.models.Vehicles vehicle) {
        this.id = vehicle.getId();
        this.vin = vehicle.getVin();
        this.stockCode = vehicle.getStockCode();
        this.modelName = vehicle.getModel() != null ? vehicle.getModel().getName() : null;
        this.brandName = vehicle.getModel() != null && vehicle.getModel().getBrand() != null ? 
                        vehicle.getModel().getBrand().getName() : null;
        this.trimName = vehicle.getTrim() != null ? vehicle.getTrim().getName() : null;
        this.modelYear = vehicle.getModelYear();
        this.exteriorColor = vehicle.getExteriorColor();
        this.interiorColor = vehicle.getInteriorColor();
        this.transmission = vehicle.getTransmission();
        this.fuelType = vehicle.getFuelType();
        this.drivetrain = vehicle.getDrivetrain();
        this.bodyType = vehicle.getBodyType();
        this.doors = vehicle.getDoors();
        this.seats = vehicle.getSeats();
        this.odometerKm = vehicle.getOdometerKm();
        this.condition = vehicle.getCondition();
        this.status = vehicle.getStatus();
        this.listPrice = vehicle.getListPrice();
    }

    // Getters
    public Long getId() { return id; }
    public String getVin() { return vin; }
    public String getStockCode() { return stockCode; }
    public String getModelName() { return modelName; }
    public String getBrandName() { return brandName; }
    public String getTrimName() { return trimName; }
    public Integer getModelYear() { return modelYear; }
    public String getExteriorColor() { return exteriorColor; }
    public String getInteriorColor() { return interiorColor; }
    public String getTransmission() { return transmission; }
    public String getFuelType() { return fuelType; }
    public String getDrivetrain() { return drivetrain; }
    public String getBodyType() { return bodyType; }
    public Short getDoors() { return doors; }
    public Short getSeats() { return seats; }
    public BigDecimal getOdometerKm() { return odometerKm; }
    public String getCondition() { return condition; }
    public String getStatus() { return status; }
    public BigDecimal getListPrice() { return listPrice; }
}
