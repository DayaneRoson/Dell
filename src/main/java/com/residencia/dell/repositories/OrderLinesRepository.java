
package com.residencia.dell.repositories;

import com.residencia.dell.entities.OrderLines;
import com.residencia.dell.entities.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dayane
 */
@Repository
public interface OrderLinesRepository extends JpaRepository <OrderLines, Long> {
   
    OrderLines findByOrderLineIdAndOrders(Integer orderlineId, Orders orders);
    OrderLines deleteByOrderLineIdAndOrders (Integer orderlineId, Orders orders);
}
