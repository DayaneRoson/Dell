
package com.residencia.dell.entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Dayane
 */
@Entity
@Table (name = "orderlines")
public class OrderLines implements Serializable {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderlineid_seq")
    @SequenceGenerator (name = "orderlineid_seq", sequenceName = "sequence_orderlineid" )
    @Column (name = "orderlineid")
    private Integer orderLineId;

    @ManyToOne
    @JoinColumn (name = "orderid", referencedColumnName  = "orderid")
    private Orders orders;

    @Column (name = "prod_id")
    private Integer prodId;

    @Column (name = "quantity")
    private Integer quantity;

    @Column (name = "orderdate")
    private Calendar orderDate;

    public Integer getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(Integer orderLineId) {
        this.orderLineId = orderLineId;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Calendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }
    
    
}
