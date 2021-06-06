
package com.residencia.dell.services;

import com.residencia.dell.entities.Categories;
import com.residencia.dell.repositories.CategoriesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dayane
 */
@Service
public class CategoriesService {
    
    @Autowired
    public CategoriesRepository categoriesRepository;
    
    public List <Categories> findAll () {
        return categoriesRepository.findAll();
    }
    
}
