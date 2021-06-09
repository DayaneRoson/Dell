
package com.residencia.dell.VO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 *
 * @author Dayane
 */
public class ItemOrderLinesVO implements Serializable {
    
     private static final long serialVersionUID = 1L;
     
    private Integer prodId;
    private String title;
    private BigDecimal price;
    private Integer quantity;
    private Calendar orderDate;

    public ItemOrderLinesVO(Integer prodId, Integer quantity, Calendar orderDate) {
        this.prodId = prodId;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }
    
    public ItemOrderLinesVO () {
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
