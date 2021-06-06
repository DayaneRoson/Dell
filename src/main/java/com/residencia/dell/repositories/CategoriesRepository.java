
package com.residencia.dell.repositories;

import com.residencia.dell.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dayane
 */
@Repository
public interface CategoriesRepository extends JpaRepository <Categories, Integer> {
    
}
