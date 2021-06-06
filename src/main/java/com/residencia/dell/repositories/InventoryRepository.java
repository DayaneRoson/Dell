
package com.residencia.dell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dayane
 */
@Repository
public interface InventoryRepository extends JpaRepository <InventoryRepository, Integer>{
    
}
