/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.residencia.dell.VO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Dayane
 */
public class NotaFiscalVO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer orderId;
    private Calendar orderDate;
    private BigDecimal netAmount;
    private BigDecimal tax;
    private BigDecimal totalAmount;
    private Integer customerId;
    private String customerFirstName;
    private String customerLastName;
    private String username;
    private String address;
    private String city;
    private String state;
    private Integer zipCode;
    private String phone;
    private Integer creditCardType;
    private String creditCard;
    private String creditCardExpiration;
    private List<ItemOrderLinesVO> listItemOrderLinesVO;
    

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    
    

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    
    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Calendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(Integer creditCardType) {
        this.creditCardType = creditCardType;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getCreditCardExpiration() {
        return creditCardExpiration;
    }

    public void setCreditCardExpiration(String creditCardExpiration) {
        this.creditCardExpiration = creditCardExpiration;
    }

    public List<ItemOrderLinesVO> getListItemOrderLinesVO() {
        return listItemOrderLinesVO;
    }

    public void setListItemOrderLinesVO(List<ItemOrderLinesVO> listItemOrderLinesVO) {
        this.listItemOrderLinesVO = listItemOrderLinesVO;
    }
    
    public NotaFiscalVO () {
        
    }

    public NotaFiscalVO(Integer orderId, Calendar orderDate, BigDecimal netAmount, BigDecimal tax, BigDecimal totalAmount, Integer customerId, String customerFirstName, String customerLastName, String username, String address, String city, String state, Integer zipCode, String phone, Integer creditCardType, String creditCard, String creditCardExpiration, List<ItemOrderLinesVO> listItemOrderLinesVO) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.netAmount = netAmount;
        this.tax = tax;
        this.totalAmount = totalAmount;
        this.customerId = customerId;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.username = username;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phone = phone;
        this.creditCardType = creditCardType;
        this.creditCard = creditCard;
        this.creditCardExpiration = creditCardExpiration;
        this.listItemOrderLinesVO = listItemOrderLinesVO;
    }

    
}
    
    

