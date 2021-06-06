
package com.residencia.dell.repositories;

import com.residencia.dell.entities.Cust_Hist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dayane
 */
@Repository
public interface CustHistRepository extends JpaRepository <Cust_Hist, Long>{
    
}
