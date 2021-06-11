
package com.residencia.dell.VO;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Dayane
 */
public class OrderLineIdVO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer orderlineid;
    private Integer orderid;

    public Integer getOrderlineid() {
        return orderlineid;
    }

    public void setOrderlineid(Integer orderlineid) {
        this.orderlineid = orderlineid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public OrderLineIdVO(Integer orderlineid, Integer orderid) {
        this.orderlineid = orderlineid;
        this.orderid = orderid;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.orderlineid);
        hash = 71 * hash + Objects.hashCode(this.orderid);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderLineIdVO other = (OrderLineIdVO) obj;
        if (!Objects.equals(this.orderlineid, other.orderlineid)) {
            return false;
        }
        if (!Objects.equals(this.orderid, other.orderid)) {
            return false;
        }
        return true;
    }
    
    
    
}
