package com.cardealership.cardealership.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "vehicles", schema = "car_dealership",
    indexes = {
        @Index(name = "idx_vehicles_model", columnList = "model_id"),
        @Index(name = "idx_vehicles_status", columnList = "status")
    })
public class Vehicles extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "vin", unique = true, nullable = false)
    private String vin;

    @Column(name = "stock_code", unique = true, nullable = false)
    private String stockCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false, 
                foreignKey = @ForeignKey(name = "vehicles_model_id_fkey"))
    private Models model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trim_id", nullable = false,
                foreignKey = @ForeignKey(name = "vehicles_trim_id_fkey"))
    private Trims trim;

    @Column(name = "model_year")
    private Integer modelYear;

    @Column(name = "exterior_color")
    private String exteriorColor;

    @Column(name = "interior_color")
    private String interiorColor;

    @Column(name = "transmission")
    private String transmission;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "drivetrain")
    private String drivetrain;

    @Column(name = "body_type")
    private String bodyType;

    @Column(name = "doors")
    private Short doors;

    @Column(name = "seats")
    private Short seats;

    @Column(name = "odometer_km")
    private BigDecimal odometerKm;

    @Column(name = "condition")
    private String condition;

    @Column(name = "status")
    private String status;

    @Column(name = "cost_price")
    private BigDecimal costPrice;

    @Column(name = "list_price")
    private BigDecimal listPrice;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    public Vehicles() {}

    public Vehicles(Vehicles value) {
        this.vin = value.vin;
        this.stockCode = value.stockCode;
        this.model = value.model;
        this.trim = value.trim;
        this.modelYear = value.modelYear;
        this.exteriorColor = value.exteriorColor;
        this.interiorColor = value.interiorColor;
        this.transmission = value.transmission;
        this.fuelType = value.fuelType;
        this.drivetrain = value.drivetrain;
        this.bodyType = value.bodyType;
        this.doors = value.doors;
        this.seats = value.seats;
        this.odometerKm = value.odometerKm;
        this.condition = value.condition;
        this.status = value.status;
        this.costPrice = value.costPrice;
        this.listPrice = value.listPrice;
        this.createdAt = value.createdAt;
        this.updatedAt = value.updatedAt;
    }

    public Vehicles(
        String vin,
        String stockCode,
        Models model,
        Trims trim,
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
    ) {
        this.vin = vin;
        this.stockCode = stockCode;
        this.model = model;
        this.trim = trim;
        this.modelYear = modelYear;
        this.exteriorColor = exteriorColor;
        this.interiorColor = interiorColor;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.drivetrain = drivetrain;
        this.bodyType = bodyType;
        this.doors = doors;
        this.seats = seats;
        this.odometerKm = odometerKm;
        this.condition = condition;
        this.status = status;
        this.costPrice = costPrice;
        this.listPrice = listPrice;
        this.createdAt = OffsetDateTime.now();
        this.updatedAt = OffsetDateTime.now();
    }

    /**
     * Getter for <code>car_dealership.vehicles.vin</code>.
     */
    public String getVin() {
        return this.vin;
    }

    /**
     * Setter for <code>car_dealership.vehicles.vin</code>.
     */
    public Vehicles setVin(String vin) {
        this.vin = vin;
        return this;
    }

    /**
     * Getter for <code>car_dealership.vehicles.stock_code</code>.
     */
    public String getStockCode() {
        return this.stockCode;
    }

    /**
     * Setter for <code>car_dealership.vehicles.stock_code</code>.
     */
    public Vehicles setStockCode(String stockCode) {
        this.stockCode = stockCode;
        return this;
    }

    public Models getModel() {
        return this.model;
    }

    public Vehicles setModel(Models model) {
        this.model = model;
        return this;
    }

    public Trims getTrim() {
        return this.trim;
    }

    public Vehicles setTrim(Trims trim) {
        this.trim = trim;
        return this;
    }

    /**
     * Getter for <code>car_dealership.vehicles.model_year</code>.
     */
    public Integer getModelYear() {
        return this.modelYear;
    }

    /**
     * Setter for <code>car_dealership.vehicles.model_year</code>.
     */
    public Vehicles setModelYear(Integer modelYear) {
        this.modelYear = modelYear;
        return this;
    }

    /**
     * Getter for <code>car_dealership.vehicles.exterior_color</code>.
     */
    public String getExteriorColor() {
        return this.exteriorColor;
    }

    /**
     * Setter for <code>car_dealership.vehicles.exterior_color</code>.
     */
    public Vehicles setExteriorColor(String exteriorColor) {
        this.exteriorColor = exteriorColor;
        return this;
    }

    /**
     * Getter for <code>car_dealership.vehicles.interior_color</code>.
     */
    public String getInteriorColor() {
        return this.interiorColor;
    }

    /**
     * Setter for <code>car_dealership.vehicles.interior_color</code>.
     */
    public Vehicles setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
        return this;
    }

    /**
     * Getter for <code>car_dealership.vehicles.transmission</code>.
     */
    public String getTransmission() {
        return this.transmission;
    }

    /**
     * Setter for <code>car_dealership.vehicles.transmission</code>.
     */
    public Vehicles setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    /**
     * Getter for <code>car_dealership.vehicles.fuel_type</code>.
     */
    public String getFuelType() {
        return this.fuelType;
    }

    /**
     * Setter for <code>car_dealership.vehicles.fuel_type</code>.
     */
    public Vehicles setFuelType(String fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    /**
     * Getter for <code>car_dealership.vehicles.drivetrain</code>.
     */
    public String getDrivetrain() {
        return this.drivetrain;
    }

    /**
     * Setter for <code>car_dealership.vehicles.drivetrain</code>.
     */
    public Vehicles setDrivetrain(String drivetrain) {
        this.drivetrain = drivetrain;
        return this;
    }

    /**
     * Getter for <code>car_dealership.vehicles.body_type</code>.
     */
    public String getBodyType() {
        return this.bodyType;
    }

    /**
     * Setter for <code>car_dealership.vehicles.body_type</code>.
     */
    public Vehicles setBodyType(String bodyType) {
        this.bodyType = bodyType;
        return this;
    }

    /**
     * Getter for <code>car_dealership.vehicles.doors</code>.
     */
    public Short getDoors() {
        return this.doors;
    }

    /**
     * Setter for <code>car_dealership.vehicles.doors</code>.
     */
    public Vehicles setDoors(Short doors) {
        this.doors = doors;
        return this;
    }

    /**
     * Getter for <code>car_dealership.vehicles.seats</code>.
     */
    public Short getSeats() {
        return this.seats;
    }

    /**
     * Setter for <code>car_dealership.vehicles.seats</code>.
     */
    public Vehicles setSeats(Short seats) {
        this.seats = seats;
        return this;
    }

    /**
     * Getter for <code>car_dealership.vehicles.odometer_km</code>.
     */
    public BigDecimal getOdometerKm() {
        return this.odometerKm;
    }

    /**
     * Setter for <code>car_dealership.vehicles.odometer_km</code>.
     */
    public Vehicles setOdometerKm(BigDecimal odometerKm) {
        this.odometerKm = odometerKm;
        return this;
    }

    /**
     * Getter for <code>car_dealership.vehicles.condition</code>.
     */
    public String getCondition() {
        return this.condition;
    }

    /**
     * Setter for <code>car_dealership.vehicles.condition</code>.
     */
    public Vehicles setCondition(String condition) {
        this.condition = condition;
        return this;
    }

    /**
     * Getter for <code>car_dealership.vehicles.status</code>.
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Setter for <code>car_dealership.vehicles.status</code>.
     */
    public Vehicles setStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * Getter for <code>car_dealership.vehicles.cost_price</code>.
     */
    public BigDecimal getCostPrice() {
        return this.costPrice;
    }

    /**
     * Setter for <code>car_dealership.vehicles.cost_price</code>.
     */
    public Vehicles setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
        return this;
    }

    /**
     * Getter for <code>car_dealership.vehicles.list_price</code>.
     */
    public BigDecimal getListPrice() {
        return this.listPrice;
    }

    /**
     * Setter for <code>car_dealership.vehicles.list_price</code>.
     */
    public Vehicles setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
        return this;
    }

    /**
     * Getter for <code>car_dealership.vehicles.created_at</code>.
     */
    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Setter for <code>car_dealership.vehicles.created_at</code>.
     */
    public Vehicles setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Getter for <code>car_dealership.vehicles.updated_at</code>.
     */
    public OffsetDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Setter for <code>car_dealership.vehicles.updated_at</code>.
     */
    public Vehicles setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        if (!super.equals(obj))
            return false;
        final Vehicles other = (Vehicles) obj;
        if (this.vin == null) {
            if (other.vin != null)
                return false;
        }
        else if (!this.vin.equals(other.vin))
            return false;
        if (this.stockCode == null) {
            if (other.stockCode != null)
                return false;
        }
        else if (!this.stockCode.equals(other.stockCode))
            return false;
        if (this.model == null) {
            if (other.model != null)
                return false;
        }
        else if (!this.model.equals(other.model))
            return false;
        if (this.trim == null) {
            if (other.trim != null)
                return false;
        }
        else if (!this.trim.equals(other.trim))
            return false;
        // ... resto de las comparaciones
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.vin == null) ? 0 : this.vin.hashCode());
        result = prime * result + ((this.stockCode == null) ? 0 : this.stockCode.hashCode());
        result = prime * result + ((this.model == null) ? 0 : this.model.hashCode());
        result = prime * result + ((this.trim == null) ? 0 : this.trim.hashCode());
        result = prime * result + ((this.modelYear == null) ? 0 : this.modelYear.hashCode());
        // ... resto de los campos
        return result;
    }

    @Override
    public String toString() {
        return "Vehicle [id=" + getId() + 
               ", vin=" + vin + 
               ", stockCode=" + stockCode + 
               ", model=" + (model != null ? model.getName() : "null") + 
               ", trim=" + (trim != null ? trim.getName() : "null") + 
               ", modelYear=" + modelYear + 
               ", status=" + status + 
               "]";
    }
}
