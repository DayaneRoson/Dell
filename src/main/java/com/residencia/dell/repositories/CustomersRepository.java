
package com.residencia.dell.repositories;

import com.residencia.dell.entities.Customers;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dayane
 */
@Repository
public interface CustomersRepository extends PagingAndSortingRepository <Customers, Integer>{
    
}
