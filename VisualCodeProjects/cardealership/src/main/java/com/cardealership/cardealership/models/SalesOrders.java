package com.cardealership.cardealership.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sales_orders", schema = "car_dealership")
public class SalesOrders extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customer;

    @Column(name = "order_date", nullable = false)
    private OffsetDateTime orderDate;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "subtotal", nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "discount_amount", precision = 10, scale = 2)
    private BigDecimal discountAmount;

    @Column(name = "tax_amount", precision = 10, scale = 2)
    private BigDecimal taxAmount;

    @Column(name = "total_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payments> payments = new ArrayList<>();

    @OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SalesOrderLines> orderLines = new ArrayList<>();

    public void updateTotal() {
        this.subtotal = BigDecimal.ZERO;
        for (SalesOrderLines line : orderLines) {
            if (line.getLineTotal() != null) {
                this.subtotal = this.subtotal.add(line.getLineTotal());
            }
        }
        updateTotalAmount();
    }

    public SalesOrders() {
    }

    public SalesOrders(Customers customer, String status, BigDecimal subtotal) {
        this.customer = customer;
        this.orderDate = OffsetDateTime.now();
        this.status = status;
        this.subtotal = subtotal;
        this.discountAmount = BigDecimal.ZERO;
        this.taxAmount = BigDecimal.ZERO;
        this.totalAmount = subtotal;
        this.payments = new ArrayList<>();
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public OffsetDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(OffsetDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
        this.updateTotalAmount();
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
        this.updateTotalAmount();
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
        this.updateTotalAmount();
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    protected void updateTotalAmount() {
        this.totalAmount = this.subtotal
            .subtract(this.discountAmount == null ? BigDecimal.ZERO : this.discountAmount)
            .add(this.taxAmount == null ? BigDecimal.ZERO : this.taxAmount);
    }

    public List<Payments> getPayments() {
        return payments;
    }

    public void addPayment(Payments payment) {
        payments.add(payment);
        payment.setSalesOrder(this);
    }

    public void removePayment(Payments payment) {
        payments.remove(payment);
        payment.setSalesOrder(null);
    }

    public List<SalesOrderLines> getOrderLines() {
        return orderLines;
    }

    public void addOrderLine(SalesOrderLines orderLine) {
        orderLines.add(orderLine);
        orderLine.setSalesOrder(this);
        this.subtotal = this.subtotal.add(orderLine.getLineTotal());
        this.updateTotalAmount();
    }

    public void removeOrderLine(SalesOrderLines orderLine) {
        orderLines.remove(orderLine);
        orderLine.setSalesOrder(null);
        this.subtotal = this.subtotal.subtract(orderLine.getLineTotal());
        this.updateTotalAmount();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        final SalesOrders other = (SalesOrders) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        }
        else if (!getId().equals(other.getId()))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SalesOrders [id=" + getId() + 
               ", customer=" + (customer != null ? customer.getId() : null) +
               ", orderDate=" + orderDate +
               ", status=" + status +
               ", subtotal=" + subtotal +
               ", discountAmount=" + discountAmount +
               ", taxAmount=" + taxAmount +
               ", totalAmount=" + totalAmount + 
               ", payments=" + payments.size() + "]";
    }
}
