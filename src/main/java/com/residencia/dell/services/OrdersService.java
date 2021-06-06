
package com.residencia.dell.services;

import com.residencia.dell.entities.Orders;
import com.residencia.dell.repositories.OrdersRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dayane
 */
@Service
public class OrdersService {
    
    @Autowired
    public OrdersRepository ordersRepository;
    
    public Orders findById (Integer id) {
       // return alunosRepository.getById(id).getNome();
       return ordersRepository.findById (id).get();
    }
    
    public List <Orders> findAll () {
        return ordersRepository.findAll();
    }
    
    public Long count () {
        return ordersRepository.count();
    }
    
    public Orders save (Orders orders) {
        Orders newOrders = ordersRepository.save (orders);
        return newOrders;
    }
    
    public void delete (Integer id) {
        ordersRepository.deleteById(id);
    }
    
    public Orders update (Integer id, Orders orders) {
        Orders newOrders = ordersRepository.findById (id).get();
        updateDados (newOrders, orders);
        return ordersRepository.save(newOrders);
    }

    private void updateDados(Orders newOrders, Orders orders) {
        newOrders.setOrderDate(orders.getOrderDate());
        newOrders.setCustomer(orders.getCustomer());
        newOrders.setNetAmount(orders.getNetAmount());
        newOrders.setTax(orders.getTax());
        newOrders.setTotalAmount(orders.getTotalAmount());
    }
}
