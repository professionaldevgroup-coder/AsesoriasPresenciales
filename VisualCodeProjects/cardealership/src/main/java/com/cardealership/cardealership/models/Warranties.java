package com.cardealership.cardealership.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "warranties", schema = "car_dealership")
public class Warranties extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_order_id", nullable = false)
    private SalesOrders salesOrder;

    @Column(name = "provider", length = 100, nullable = false)
    private String provider;

    @Column(name = "warranty_type", length = 50, nullable = false)
    private String warrantyType;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    public Warranties() {
        this.price = BigDecimal.ZERO;
        this.startDate = LocalDate.now();
    }

    public Warranties(SalesOrders salesOrder, String provider, String warrantyType, 
                     LocalDate startDate, LocalDate endDate, BigDecimal price) {
        this.salesOrder = salesOrder;
        this.provider = provider;
        this.warrantyType = warrantyType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public Warranties(Warranties value) {
        this.setId(value.getId());
        this.salesOrder = value.salesOrder;
        this.provider = value.provider;
        this.warrantyType = value.warrantyType;
        this.startDate = value.startDate;
        this.endDate = value.endDate;
        this.price = value.price;
    }

    public SalesOrders getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrders salesOrder) {
        this.salesOrder = salesOrder;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(String warrantyType) {
        this.warrantyType = warrantyType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Warranties that = (Warranties) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }

    @Override
    public String toString() {
        return "Warranties{" +
                "id=" + getId() +
                ", salesOrder=" + (salesOrder != null ? salesOrder.getId() : null) +
                ", provider='" + provider + '\'' +
                ", warrantyType='" + warrantyType + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                '}';
    }
}
