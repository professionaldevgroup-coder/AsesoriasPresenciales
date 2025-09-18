package com.cardealership.cardealership.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.io.Serializable;

@Entity
@Table(name = "models", schema = "car_dealership")
public class Models extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brands brand;

    @Column(name = "name")
    private String name;

    public Models() {}

    public Models(Brands brand, String name) {
        this.brand = brand;
        this.name = name;
    }

    public Models(Models value) {
        this.brand = value.brand;
        this.name = value.name;
    }

    public Brands getBrand() {
        return this.brand;
    }

    public Models setBrand(Brands brand) {
        this.brand = brand;
        return this;
    }

    /**
     * Getter for <code>car_dealership.models.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>car_dealership.models.name</code>.
     */
    public Models setName(String name) {
        this.name = name;
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
        final Models other = (Models) obj;
        if (this.brand == null) {
            if (other.brand != null)
                return false;
        }
        else if (!this.brand.equals(other.brand))
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        }
        else if (!this.name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.brand == null) ? 0 : this.brand.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Models [id=" + getId() + ", brand=" + (brand != null ? brand.getName() : "null") + ", name=" + name + "]";
    }
}
