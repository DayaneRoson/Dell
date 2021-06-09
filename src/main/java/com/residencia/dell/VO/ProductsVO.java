
package com.residencia.dell.VO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Dayane
 */
public class ProductsVO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer prodId;
    private String title;
    private BigDecimal price;

    public ProductsVO(Integer prodId, String title, BigDecimal price) {
        this.prodId = prodId;
        this.title = title;
        this.price = price;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
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
    
    
}
