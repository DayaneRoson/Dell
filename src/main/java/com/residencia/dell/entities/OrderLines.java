
package com.residencia.dell.entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    OrderLinesId orderLinesId;

    @ManyToOne
    @JoinColumn (name = "orderid", referencedColumnName  = "orderid",  insertable = false, updatable = false)
    private Orders orders;

    @Column (name = "prod_id")
    private Integer prodId;

    @Column (name = "quantity")
    private Integer quantity;

    @Column (name = "orderdate")
    private Calendar orderDate;

   
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

    public OrderLinesId getOrderLinesId() {
        return orderLinesId;
    }

    public void setOrderLinesId(OrderLinesId orderLinesId) {
        this.orderLinesId = orderLinesId;
    }

    public OrderLines() {
    }
    
    public OrderLines(Integer orderLinesId, Integer orderId, Integer prodId, Integer quantity, Calendar orderDate) {
        this.orderLinesId = new OrderLinesId (orderLinesId, orderId);
        this.orders = orders;
        this.prodId = prodId;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }
    
    
}
