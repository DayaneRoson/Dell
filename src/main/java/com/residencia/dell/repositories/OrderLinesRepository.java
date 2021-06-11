
package com.residencia.dell.repositories;

import com.residencia.dell.entities.OrderLines;
import com.residencia.dell.entities.OrderLinesId;
import com.residencia.dell.entities.Orders;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dayane
 */
@Repository
public interface OrderLinesRepository extends PagingAndSortingRepository <OrderLines, OrderLinesId> {
   
   // OrderLines findByOrderLineIdAndOrders(Integer orderlineId, Orders orders);
    //OrderLines deleteByOrderLineIdAndOrders (Integer orderlineId, Orders orders);
}
