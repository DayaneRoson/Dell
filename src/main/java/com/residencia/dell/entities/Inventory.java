
package com.residencia.dell.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Dayane
 */
@Entity
@Table (name = "inventory")
public class Inventory {
    
    //ué, tem a mesma chave primária de products
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "prod_id")
    private Integer prodId;

    @Column (name = "quan_in_stock")
    private Integer quantInStock;

    @Column (name = "sales")
    private Integer sales;

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getQuantInStock() {
        return quantInStock;
    }

    public void setQuantInStock(Integer quantInStock) {
        this.quantInStock = quantInStock;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }
    
    
    
    
}
