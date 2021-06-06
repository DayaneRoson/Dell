
package com.residencia.dell.services;

import com.residencia.dell.VO.OrdersVO;
import com.residencia.dell.entities.Orders;
import com.residencia.dell.repositories.CustomersRepository;
import com.residencia.dell.repositories.OrderLinesRepository;
import com.residencia.dell.repositories.OrdersRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dayane
 */
@Service
public class OrdersService {
    
    @Autowired
    public OrdersRepository ordersRepository;
    
    @Autowired
    public CustomersRepository customerRepository;
    
    
    public OrdersVO findById (Integer id) {
       Orders orders =  ordersRepository.findById (id).get();
       OrdersVO ordersVO = converteEntidadeVO (orders);
       return ordersVO;
    }
    
    public List <OrdersVO> findAll (Pageable page) {
        List <Orders> listOrders = ordersRepository.findAll(page).getContent(); //qual é a diferença entre getContent() e toList ()
        List <OrdersVO> listOrdersVO = new ArrayList <> ();
        
        for (Orders orders : listOrders) {
            OrdersVO ordersVO = converteEntidadeVO (orders);
            listOrdersVO.add(ordersVO);
        }
        return listOrdersVO;
    }
    
    public Long count () {
        return ordersRepository.count();
    }
    
    public OrdersVO save (OrdersVO ordersVO) {
        Orders newOrders = converteVOEntidade (ordersVO, null);
        ordersRepository.save(newOrders);
        return converteEntidadeVO (newOrders);
    }
    
    public void delete (Integer id) {
        ordersRepository.deleteById(id);
    }
    
    //melhorar o update
    public OrdersVO update (Integer id, OrdersVO ordersVO) {
        Orders Orders = converteVOEntidade (ordersVO, id);
        Orders newOrders = ordersRepository.save(Orders);
        
        return converteEntidadeVO (newOrders);
    }

     private OrdersVO converteEntidadeVO(Orders orders) {
        OrdersVO ordersVO = new OrdersVO ();
        
        ordersVO.setOrderId(orders.getOrderId());
        ordersVO.setOrderDate(orders.getOrderDate());
        ordersVO.setNetAmount(orders.getNetAmount());
        ordersVO.setTax(orders.getTax());
        ordersVO.setTotalAmount(orders.getTotalAmount());
        ordersVO.setCustomerId(orders.getCustomer().getCustomerId());
        ordersVO.setFirstName(orders.getCustomer().getFirstName());  //resolver o possivel null pointer
        ordersVO.setUsername(orders.getCustomer().getUsername());
        if (orders.getCustomer().getAddress1() != null) {
            ordersVO.setAddress(orders.getCustomer().getAddress1());
        } else {
            ordersVO.setAddress(orders.getCustomer().getAddress2());
        }
        ordersVO.setCity(orders.getCustomer().getCity());
        ordersVO.setState(orders.getCustomer().getState());
        ordersVO.setZipCode(orders.getCustomer().getZipCode());
        ordersVO.setPhone(orders.getCustomer().getPhone());
        ordersVO.setCreditCardType(orders.getCustomer().getCreditCardType());
        ordersVO.setCreditCard(orders.getCustomer().getCreditCard());
        ordersVO.setCreditCardExpiration(orders.getCustomer().getCreditCardExpiration());
        
        return ordersVO;
    }
     
     private Orders converteVOEntidade(OrdersVO ordersVO, Integer id) {
        Orders orders = new Orders ();
        
        orders.setOrderId((null == id) ? ordersVO.getOrderId() : id);
        orders.setOrderDate(orders.getOrderDate());
        orders.setCustomer(customerRepository.findById(ordersVO.getCustomerId()).get());
        orders.setNetAmount(orders.getNetAmount());
        orders.setTax(orders.getTax());
        orders.setTotalAmount(orders.getTotalAmount());
        
        return orders;
    }
}
