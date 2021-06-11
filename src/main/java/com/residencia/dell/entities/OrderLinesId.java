
package com.residencia.dell.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author Dayane
 */
@Embeddable
public class OrderLinesId implements Serializable {
    
    private static final long serialVersionUID = 1L;

	private Integer orderlineid;
	private Integer orderid;

	public OrderLinesId() {
	}

	public OrderLinesId(Integer orderlineid, Integer orderid) {
		this.orderlineid = orderlineid;
		this.orderid = orderid;
	}

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.orderlineid);
        hash = 53 * hash + Objects.hashCode(this.orderid);
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
        final OrderLinesId other = (OrderLinesId) obj;
        if (!Objects.equals(this.orderlineid, other.orderlineid)) {
            return false;
        }
        if (!Objects.equals(this.orderid, other.orderid)) {
            return false;
        }
        return true;
    }
        
        
        
}
