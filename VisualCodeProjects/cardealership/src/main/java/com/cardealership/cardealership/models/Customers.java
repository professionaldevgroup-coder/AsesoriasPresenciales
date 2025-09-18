package com.cardealership.cardealership.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers", schema = "car_dealership")
public class Customers extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "driver_license_no", unique = true, length = 20)
    private String driverLicenseNo;

    @Column(name = "tax_id", unique = true, length = 20)
    private String taxId;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SalesOrders> salesOrders = new ArrayList<>();

    public Customers() {
    }

    public Customers(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.createdAt = OffsetDateTime.now();
        this.salesOrders = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getDriverLicenseNo() {
        return driverLicenseNo;
    }

    public void setDriverLicenseNo(String driverLicenseNo) {
        this.driverLicenseNo = driverLicenseNo;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    protected void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<SalesOrders> getSalesOrders() {
        return salesOrders;
    }

    public void addSalesOrder(SalesOrders salesOrder) {
        salesOrders.add(salesOrder);
        salesOrder.setCustomer(this);
    }

    public void removeSalesOrder(SalesOrders salesOrder) {
        salesOrders.remove(salesOrder);
        salesOrder.setCustomer(null);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        final Customers other = (Customers) obj;
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
        return "Customers [id=" + getId() +
               ", name=" + firstName + " " + lastName +
               ", email=" + email +
               ", phone=" + phone +
               ", birthDate=" + birthDate +
               ", driverLicenseNo=" + driverLicenseNo +
               ", taxId=" + taxId +
               ", createdAt=" + createdAt +
               ", salesOrders=" + salesOrders.size() + "]";
    }
}
