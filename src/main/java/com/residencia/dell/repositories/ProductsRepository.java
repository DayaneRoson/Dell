
package com.residencia.dell.repositories;

import com.residencia.dell.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dayane
 */
@Repository
public interface ProductsRepository extends JpaRepository <Products, Integer> {
    
    
}