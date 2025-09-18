package com.cardealership.cardealership.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "payments", schema = "car_dealership")
public class Payments extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_order_id", nullable = false)
    private SalesOrders salesOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_method_id", nullable = false)
    private PaymentMethods paymentMethod;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "paid_at", nullable = false)
    private OffsetDateTime paidAt;

    @Column(name = "reference_code", length = 50)
    private String referenceCode;

    public Payments() {
    }

    public Payments(SalesOrders salesOrder, PaymentMethods paymentMethod, 
                   BigDecimal amount, String referenceCode) {
        this.salesOrder = salesOrder;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.paidAt = OffsetDateTime.now();
        this.referenceCode = referenceCode;
    }

    public SalesOrders getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrders salesOrder) {
        this.salesOrder = salesOrder;
    }

    public PaymentMethods getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethods paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public OffsetDateTime getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(OffsetDateTime paidAt) {
        this.paidAt = paidAt;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        final Payments other = (Payments) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        }
        else if (!getId().equals(other.getId()))
            return false;
        if (referenceCode == null) {
            if (other.referenceCode != null)
                return false;
        }
        else if (!referenceCode.equals(other.referenceCode))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((referenceCode == null) ? 0 : referenceCode.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Payments [id=" + getId() + 
               ", salesOrder=" + (salesOrder != null ? salesOrder.getId() : null) +
               ", paymentMethod=" + (paymentMethod != null ? paymentMethod.getId() : null) +
               ", amount=" + amount +
               ", paidAt=" + paidAt +
               ", referenceCode=" + referenceCode + "]";
    }
}
