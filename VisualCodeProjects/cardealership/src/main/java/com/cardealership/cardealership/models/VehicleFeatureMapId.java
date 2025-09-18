package com.cardealership.cardealership.models;

import java.io.Serializable;
import java.util.Objects;

public class VehicleFeatureMapId implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long vehicle;
    private Long feature;

    public VehicleFeatureMapId() {
    }

    public VehicleFeatureMapId(Long vehicle, Long feature) {
        this.vehicle = vehicle;
        this.feature = feature;
    }

    public Long getVehicle() {
        return vehicle;
    }

    public void setVehicle(Long vehicle) {
        this.vehicle = vehicle;
    }

    public Long getFeature() {
        return feature;
    }

    public void setFeature(Long feature) {
        this.feature = feature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleFeatureMapId that = (VehicleFeatureMapId) o;
        return Objects.equals(vehicle, that.vehicle) &&
                Objects.equals(feature, that.feature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicle, feature);
    }

    @Override
    public String toString() {
        return "VehicleFeatureMapId{" +
                "vehicle=" + vehicle +
                ", feature=" + feature +
                '}';
    }
}
