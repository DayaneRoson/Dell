
package com.residencia.dell.entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Dayane
 */
@Entity
@Table (name = "orders")
public class Orders {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "orderid")
    private Integer orderId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    
    @Column (name = "orderdate")
    private Calendar orderDate;

    public Calendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }
    
    @ManyToOne
    @JoinColumn (name = "customerid", referencedColumnName = "customerid")
    private Customers customer;

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }
    
    @Column (name = "netamount")
    private BigDecimal netAmount;

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }
    
    @Column (name = "tax")
    private BigDecimal tax;

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }
    
    @Column (name = "totalamount")
    private BigDecimal totalAmount;

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    @OneToMany (mappedBy = "orders")
    private List <OrderLines> listOrderLines;

    public List<OrderLines> getListOrderLines() {
        return listOrderLines;
    }

    public void setListOrderLines(List<OrderLines> listOrderLines) {
        this.listOrderLines = listOrderLines;
    }
}
