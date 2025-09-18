package com.cardealership.cardealership.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "quotes", schema = "car_dealership")
public class Quotes extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicles vehicle;

    @Column(name = "quote_date", nullable = false)
    private LocalDate quoteDate;

    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name = "validity_date", nullable = false)
    private LocalDate validityDate;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    public Quotes() {
        this.quoteDate = LocalDate.now();
        this.validityDate = LocalDate.now().plusDays(30);
        this.price = BigDecimal.ZERO;
        this.status = "PENDING";
    }

    public Quotes(Customers customer, Vehicles vehicle, BigDecimal price, 
                 LocalDate validityDate, String status) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.quoteDate = LocalDate.now();
        this.price = price;
        this.validityDate = validityDate;
        this.status = status;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Vehicles getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getQuoteDate() {
        return quoteDate;
    }

    public void setQuoteDate(LocalDate quoteDate) {
        this.quoteDate = quoteDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(LocalDate validityDate) {
        this.validityDate = validityDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Quotes quotes = (Quotes) o;
        return Objects.equals(getId(), quotes.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }

    @Override
    public String toString() {
        return "Quotes{" +
                "id=" + getId() +
                ", customer=" + (customer != null ? customer.getId() : null) +
                ", vehicle=" + (vehicle != null ? vehicle.getId() : null) +
                ", quoteDate=" + quoteDate +
                ", price=" + price +
                ", validityDate=" + validityDate +
                ", status='" + status + '\'' +
                '}';
    }
}
