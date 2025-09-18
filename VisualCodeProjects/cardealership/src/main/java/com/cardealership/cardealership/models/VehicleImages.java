package com.cardealership.cardealership.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity
@Table(name = "vehicle_images", schema = "car_dealership")
public class VehicleImages extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicles vehicle;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "is_primary")
    private Boolean isPrimary;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    public VehicleImages() {
    }

    public VehicleImages(Vehicles vehicle, String url, Boolean isPrimary) {
        this.vehicle = vehicle;
        this.url = url;
        this.isPrimary = isPrimary;
        this.createdAt = OffsetDateTime.now();
    }

    public Vehicles getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        VehicleImages other = (VehicleImages) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        }
        else if (!getId().equals(other.getId()))
            return false;
        if (url == null) {
            if (other.url != null)
                return false;
        }
        else if (!url.equals(other.url))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VehicleImages [id=" + getId() + 
               ", vehicle=" + (vehicle != null ? vehicle.getId() : null) + 
               ", url=" + url + 
               ", isPrimary=" + isPrimary + 
               ", createdAt=" + createdAt + "]";
    }
}
