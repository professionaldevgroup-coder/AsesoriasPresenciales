package com.cardealership.cardealership.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "vehicle_acquisitions", schema = "car_dealership")
public class VehicleAcquisitions extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicles vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Suppliers supplier;

    @Column(name = "acquisition_date", nullable = false)
    private LocalDate acquisitionDate;

    @Column(name = "acquisition_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal acquisitionPrice;

    @Column(name = "notes", length = 1000)
    private String notes;

    public VehicleAcquisitions() {
        this.acquisitionPrice = BigDecimal.ZERO;
        this.acquisitionDate = LocalDate.now();
    }

    public VehicleAcquisitions(Vehicles vehicle, Suppliers supplier, LocalDate acquisitionDate, BigDecimal acquisitionPrice) {
        this.vehicle = vehicle;
        this.supplier = supplier;
        this.acquisitionDate = acquisitionDate;
        this.acquisitionPrice = acquisitionPrice;
    }

    public Vehicles getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }

    public Suppliers getSupplier() {
        return supplier;
    }

    public void setSupplier(Suppliers supplier) {
        this.supplier = supplier;
    }

    public LocalDate getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(LocalDate acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public BigDecimal getAcquisitionPrice() {
        return acquisitionPrice;
    }

    public void setAcquisitionPrice(BigDecimal acquisitionPrice) {
        this.acquisitionPrice = acquisitionPrice;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VehicleAcquisitions that = (VehicleAcquisitions) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }

    @Override
    public String toString() {
        return "VehicleAcquisitions{" +
                "id=" + getId() +
                ", vehicle=" + (vehicle != null ? vehicle.getId() : null) +
                ", supplier=" + (supplier != null ? supplier.getId() : null) +
                ", acquisitionDate=" + acquisitionDate +
                ", acquisitionPrice=" + acquisitionPrice +
                ", notes='" + notes + '\'' +
                '}';
    }
}
