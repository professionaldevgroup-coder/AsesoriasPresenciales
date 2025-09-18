package com.cardealership.cardealership.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "vehicle_feature_map", schema = "car_dealership")
@IdClass(VehicleFeatureMapId.class)
public class VehicleFeatureMap implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicles vehicle;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feature_id", nullable = false)
    private VehicleFeatures feature;

    public VehicleFeatureMap() {
    }

    public VehicleFeatureMap(Vehicles vehicle, VehicleFeatures feature) {
        this.vehicle = vehicle;
        this.feature = feature;
    }

    public Vehicles getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleFeatures getFeature() {
        return feature;
    }

    public void setFeature(VehicleFeatures feature) {
        this.feature = feature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleFeatureMap that = (VehicleFeatureMap) o;
        return Objects.equals(vehicle, that.vehicle) &&
                Objects.equals(feature, that.feature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicle, feature);
    }

    @Override
    public String toString() {
        return "VehicleFeatureMap{" +
                "vehicle=" + (vehicle != null ? vehicle.getId() : null) +
                ", feature=" + (feature != null ? feature.getId() : null) +
                '}';
    }
}
