
package com.residencia.dell.entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Dayane
 */
@Entity
@Table (name = "reorder")
public class Reorder implements Serializable {
    
    @Id @GeneratedValue long id;

    @OneToOne
    @JoinColumn (name = "prod_id", referencedColumnName = "prod_id")
    private Products product;

    @Column (name = "date_low")
    private Calendar dateLow;

    @Column (name = "quan_low")
    private Integer quanLow;

    @Column (name = "date_reordered")
    private Calendar dateReordered;

    @Column (name = "quan_reordered")
    private Integer quanReordered;

    @Column (name = "dateexpected")
    private Calendar dateExpected;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Calendar getDateLow() {
        return dateLow;
    }

    public void setDateLow(Calendar dateLow) {
        this.dateLow = dateLow;
    }

    public Integer getQuanLow() {
        return quanLow;
    }

    public void setQuanLow(Integer quanLow) {
        this.quanLow = quanLow;
    }

    public Calendar getDateReordered() {
        return dateReordered;
    }

    public void setDateReordered(Calendar dateReordered) {
        this.dateReordered = dateReordered;
    }

    public Integer getQuanReordered() {
        return quanReordered;
    }

    public void setQuanReordered(Integer quanReordered) {
        this.quanReordered = quanReordered;
    }

    public Calendar getDateExpected() {
        return dateExpected;
    }

    public void setDateExpected(Calendar dateExpected) {
        this.dateExpected = dateExpected;
    }

    
}
