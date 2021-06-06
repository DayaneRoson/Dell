
package com.residencia.dell.services;

import com.residencia.dell.entities.OrderLines;
import com.residencia.dell.entities.Orders;
import com.residencia.dell.repositories.OrderLinesRepository;
import com.residencia.dell.repositories.OrdersRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dayane
 */
@Service
public class OrderlinesService {
    
    @Autowired
    public OrderLinesRepository orderlinesRepository;
    
    @Autowired
    public OrderLines orderline;
    
    @Autowired
    public OrdersRepository ordersRepository;
    
    
    public OrderLines findById (Integer orderlineid, Integer orderid) {
       Orders order = ordersRepository.findById(orderid).get();
       return orderlinesRepository.findByOrderLineIdAndOrders(orderlineid, order);
    }
    
    public List <OrderLines> findAll () {
        return orderlinesRepository.findAll();
    }
    
    public Long count () {
        return orderlinesRepository.count();
    }
    
    public OrderLines save (OrderLines orderlines) {
        OrderLines newOrderLine = orderlinesRepository.save (orderlines);
        return newOrderLine;
    }
    
    public void delete (Integer orderlineid, Integer orderid) {
        Orders orders = ordersRepository.findById(orderid).get();
        orderlinesRepository.deleteByOrderLineIdAndOrders(orderlineid, orders);
    }
    
    public OrderLines update (Integer orderlineid, Integer orderid, OrderLines orderline) {
        Orders orders = ordersRepository.findById(orderid).get();
        OrderLines newOrderLine = orderlinesRepository.findByOrderLineIdAndOrders(orderlineid, orders);
        updateDados (newOrderLine, orderline);
        return orderlinesRepository.save(newOrderLine);
    }

    private void updateDados(OrderLines newOrderLine, OrderLines orderline) {
        newOrderLine.setOrderLineId(orderline.getOrderLineId());
        newOrderLine.setOrderDate(orderline.getOrderDate());
        newOrderLine.setOrders(orderline.getOrders());
        newOrderLine.setProdId(orderline.getProdId());
        newOrderLine.setQuantity(orderline.getQuantity());
    }
}
