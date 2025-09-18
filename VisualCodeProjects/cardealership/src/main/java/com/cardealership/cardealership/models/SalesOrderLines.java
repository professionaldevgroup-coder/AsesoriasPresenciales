package com.cardealership.cardealership.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "sales_order_lines", schema = "car_dealership")
public class SalesOrderLines extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_order_id", nullable = false)
    private SalesOrders salesOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicles vehicle;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "line_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal lineTotal;

    public SalesOrderLines() {
        this.quantity = 0;
        this.unitPrice = BigDecimal.ZERO;
        this.lineTotal = BigDecimal.ZERO;
    }

    public SalesOrderLines(SalesOrders salesOrder, Vehicles vehicle, Integer quantity, BigDecimal unitPrice) {
        this.salesOrder = salesOrder;
        this.vehicle = vehicle;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.calculateLineTotal();
    }

    public SalesOrders getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrders salesOrder) {
        this.salesOrder = salesOrder;
    }

    public Vehicles getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        calculateLineTotal();
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
        calculateLineTotal();
    }

    public BigDecimal getLineTotal() {
        return lineTotal;
    }

    protected void setLineTotal(BigDecimal lineTotal) {
        this.lineTotal = lineTotal;
    }

    private void calculateLineTotal() {
        if (this.quantity != null && this.unitPrice != null) {
            this.lineTotal = this.unitPrice.multiply(BigDecimal.valueOf(this.quantity));
        } else {
            this.lineTotal = BigDecimal.ZERO;
        }
        if (this.salesOrder != null) {
            this.salesOrder.updateTotal();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SalesOrderLines that = (SalesOrderLines) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }

    @Override
    public String toString() {
        return "SalesOrderLines{" +
                "id=" + getId() +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", lineTotal=" + lineTotal +
                '}';
    }
}
