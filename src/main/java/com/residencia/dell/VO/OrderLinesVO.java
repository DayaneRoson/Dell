
package com.residencia.dell.VO;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Dayane
 */
public class OrderLinesVO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer orderLineId;
    private Integer prodId;
    private Integer quantity;
    private Calendar orderDate;

    //ainda não sei onde usar o construtor completo, mas vai me facilitar em algum momento, então tá aqui

    public OrderLinesVO(Integer orderLineId, Integer prodId, Integer quantity, Calendar orderDate) {
        this.orderLineId = orderLineId;
        this.prodId = prodId;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }
    
    
    public OrderLinesVO () {
        
    }

    
    public Calendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }
    
    public Integer getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(Integer orderLineId) {
        this.orderLineId = orderLineId;
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
	
    
}
