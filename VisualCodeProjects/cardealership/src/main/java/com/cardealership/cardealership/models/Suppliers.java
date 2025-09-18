package com.cardealership.cardealership.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "suppliers", schema = "car_dealership")
public class Suppliers extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "supplier_type", nullable = false, length = 50)
    private String supplierType;

    public Suppliers() {
    }

    public Suppliers(String name, String email, String supplierType) {
        this.name = name;
        this.email = email;
        this.supplierType = supplierType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(String supplierType) {
        this.supplierType = supplierType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        final Suppliers other = (Suppliers) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        }
        else if (!getId().equals(other.getId()))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        }
        else if (!email.equals(other.email))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Suppliers [id=" + getId() + 
               ", name=" + name +
               ", phone=" + phone +
               ", email=" + email +
               ", supplierType=" + supplierType + "]";
    }
}
