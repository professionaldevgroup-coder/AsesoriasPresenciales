package com.cardealership.cardealership.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "test_drives", schema = "car_dealership")
public class TestDrives extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicles vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customer;

    @Column(name = "scheduled_at", nullable = false)
    private OffsetDateTime scheduledAt;

    @Column(name = "returned_at")
    private OffsetDateTime returnedAt;

    @Column(name = "notes", length = 1000)
    private String notes;

    public TestDrives() {
    }

    public TestDrives(Vehicles vehicle, Customers customer, OffsetDateTime scheduledAt) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.scheduledAt = scheduledAt;
    }

    public Vehicles getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public OffsetDateTime getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(OffsetDateTime scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    public OffsetDateTime getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(OffsetDateTime returnedAt) {
        this.returnedAt = returnedAt;
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
        TestDrives that = (TestDrives) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }

    @Override
    public String toString() {
        return "TestDrives{" +
                "id=" + getId() +
                ", vehicle=" + (vehicle != null ? vehicle.getId() : null) +
                ", customer=" + (customer != null ? customer.getId() : null) +
                ", scheduledAt=" + scheduledAt +
                ", returnedAt=" + returnedAt +
                ", notes='" + notes + '\'' +
                '}';
    }
}
