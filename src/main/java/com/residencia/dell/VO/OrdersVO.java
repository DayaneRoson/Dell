
package com.residencia.dell.VO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Dayane
 */
public class OrdersVO implements Serializable {
    
     private static final long serialVersionUID = 1L;
     
     private Integer orderId;
     private Calendar orderDate;
     private BigDecimal netAmount;
     private BigDecimal tax;
     private BigDecimal totalAmount;
     private Integer customerId;
     private String firstName;
     private String username;
     private String address;
     private String city;
     private String state;
     private Integer zipCode;
     private String phone;
     private Integer creditCardType;
     private String creditCard;
     private String creditCardExpiration;
     private List <OrderLinesVO> listOrderLinesVO;
     
     public OrdersVO () {
         
     }
     
     //ainda não sei onde usar o construtor completo, mas vai me facilitar em algum momento, então tá aqui
    public OrdersVO(Integer orderId, Calendar orderDate, BigDecimal netAmount, BigDecimal tax, BigDecimal totalAmount, Integer customerId, String firstName, String username, String address, String city, String state, Integer zipCode, String phone, Integer creditCardType, String creditCard, String creditCardExpiration) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.netAmount = netAmount;
        this.tax = tax;
        this.totalAmount = totalAmount;
        this.customerId = customerId;
        this.firstName = firstName;
        this.username = username;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phone = phone;
        this.creditCardType = creditCardType;
        this.creditCard = creditCard;
        this.creditCardExpiration = creditCardExpiration;
    }

    public List<OrderLinesVO> getListOrderLinesVO() {
        return listOrderLinesVO;
    }

    public void setListOrderLinesVO(List<OrderLinesVO> listOrderLinesVO) {
        this.listOrderLinesVO = listOrderLinesVO;
    }
    
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

}
