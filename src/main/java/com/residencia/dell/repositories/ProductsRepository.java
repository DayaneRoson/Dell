
package com.residencia.dell.repositories;

import com.residencia.dell.entities.Products;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dayane
 */
@Repository
public interface ProductsRepository extends PagingAndSortingRepository <Products, Integer> {
    
    
}
