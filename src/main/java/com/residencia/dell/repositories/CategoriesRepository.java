
package com.residencia.dell.repositories;

import com.residencia.dell.entities.Categories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dayane
 */
@Repository
public interface CategoriesRepository extends PagingAndSortingRepository <Categories, Integer> {
    
}
