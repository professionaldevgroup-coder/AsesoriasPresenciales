package com.cardealership.cardealership.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "trade_ins", schema = "car_dealership")
public class TradeIns extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_order_id", nullable = false)
    private SalesOrders salesOrder;

    @Column(name = "vin", length = 17, nullable = false)
    private String vin;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "offer_amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal offerAmount;

    public TradeIns() {
        this.offerAmount = BigDecimal.ZERO;
    }

    public TradeIns(SalesOrders salesOrder, String vin, String description, BigDecimal offerAmount) {
        this.salesOrder = salesOrder;
        this.vin = vin;
        this.description = description;
        this.offerAmount = offerAmount;
    }

    public SalesOrders getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrders salesOrder) {
        this.salesOrder = salesOrder;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getOfferAmount() {
        return offerAmount;
    }

    public void setOfferAmount(BigDecimal offerAmount) {
        this.offerAmount = offerAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TradeIns tradeIn = (TradeIns) o;
        return Objects.equals(getId(), tradeIn.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }

    @Override
    public String toString() {
        return "TradeIns{" +
                "id=" + getId() +
                ", salesOrder=" + (salesOrder != null ? salesOrder.getId() : null) +
                ", vin='" + vin + '\'' +
                ", description='" + description + '\'' +
                ", offerAmount=" + offerAmount +
                '}';
    }
}
