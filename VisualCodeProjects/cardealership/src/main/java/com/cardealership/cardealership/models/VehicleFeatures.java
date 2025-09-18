package com.cardealership.cardealership.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "vehicle_features", schema = "car_dealership")
public class VehicleFeatures extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "name", nullable = false, length = 100)
    private String name;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @OneToMany(mappedBy = "feature", fetch = FetchType.LAZY)
    private Set<VehicleFeatureMap> vehicleFeatureMaps = new HashSet<>();

    public VehicleFeatures() {
    }

    public VehicleFeatures(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<VehicleFeatureMap> getVehicleFeatureMaps() {
        return vehicleFeatureMaps;
    }

    public void setVehicleFeatureMaps(Set<VehicleFeatureMap> vehicleFeatureMaps) {
        this.vehicleFeatureMaps = vehicleFeatureMaps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VehicleFeatures that = (VehicleFeatures) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "VehicleFeatures{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
