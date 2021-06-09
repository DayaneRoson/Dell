
package com.residencia.dell.repositories;

import com.residencia.dell.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dayane
 */
@Repository
public interface InventoryRepository extends JpaRepository <Inventory, Integer>{
    
}
