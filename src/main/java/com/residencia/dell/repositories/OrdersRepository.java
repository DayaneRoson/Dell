
package com.residencia.dell.repositories;

import com.residencia.dell.entities.Orders;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dayane
 */
@Repository
public interface OrdersRepository extends PagingAndSortingRepository <Orders, Integer>{
    
}
