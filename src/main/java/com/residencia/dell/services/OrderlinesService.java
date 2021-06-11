
package com.residencia.dell.services;

import com.residencia.dell.VO.OrderLinesVO;
import com.residencia.dell.entities.OrderLines;
import com.residencia.dell.entities.OrderLinesId;
import com.residencia.dell.entities.Orders;
import com.residencia.dell.repositories.OrderLinesRepository;
import com.residencia.dell.repositories.OrdersRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dayane
 */
@Service
public class OrderlinesService {
    
    @Autowired //acabei de descobrir que nao pode ter injecoes de dependencia que voce nao ta usando no negocio
    public OrderLinesRepository orderlinesRepository;
    
    public OrderLines findById (OrderLinesId orderlineid) {
       return orderlinesRepository.findById(orderlineid).get();
      
    }
    
    public List <OrderLines> findAll (Pageable page) {
        return orderlinesRepository.findAll(page).getContent();
    }
    
    public Long count () {
        return orderlinesRepository.count();
    }
    
    public OrderLines save (OrderLines orderlines) {
        OrderLines newOrderLine = orderlinesRepository.save (orderlines);
        return newOrderLine;
    }
    
    /*public OrderLinesVO saveVO (OrderLinesVO orderlinesVO) {
       OrderLines newOrderLines = converteVOEntidade (orderlinesVO, null);
       orderlinesRepository.save(newOrderLines);
       return converteEntidadeVO (newOrderLines);
    }*/
    
    public void delete (OrderLinesId orderlineid) {
        orderlinesRepository.deleteById(orderlineid);
    }
    
    public OrderLines update (OrderLinesId orderlineid, OrderLines orderline) {
        OrderLines newOrderLine = orderlinesRepository.findById(orderlineid).get();
        updateDados (newOrderLine, orderline);
        return orderlinesRepository.save(newOrderLine);
    }

    private void updateDados(OrderLines newOrderLine, OrderLines orderline) {
        
        newOrderLine.setOrderDate(orderline.getOrderDate());
        newOrderLine.setOrders(orderline.getOrders());
        newOrderLine.setProdId(orderline.getProdId());
        newOrderLine.setQuantity(orderline.getQuantity());
    }

    /*public OrderLines converteVOEntidade(OrderLinesVO orderlinesVO, Integer id) {
        OrderLines orderlines = new OrderLines ();
        
        orderlines.setOrderLineId((null == id) ? orderlinesVO.getOrderLineId() : id);
        orderlines.setProdId(orderlinesVO.getProdId());
        orderlines.setQuantity(orderlinesVO.getQuantity());
        orderlines.setOrderDate(orderlinesVO.getOrderDate());
       
        return orderlines;
    }

    public OrderLinesVO converteEntidadeVO(OrderLines orderLines) {
        
        OrderLinesVO orderlinesVO = new OrderLinesVO ();
        
        orderlinesVO.setProdId(orderLines.getProdId());
        orderlinesVO.setQuantity(orderLines.getQuantity());
        orderlinesVO.setOrderDate(orderLines.getOrderDate());
        
        return orderlinesVO;
    }*/
}
