
package com.residencia.dell.services;

import com.residencia.dell.entities.Categories;
import com.residencia.dell.exception.RegistryNotFoundException;
import com.residencia.dell.repositories.CategoriesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dayane
 */
@Service
public class CategoriesService {
    
    @Autowired
    public CategoriesRepository categoriesRepository;
    
    public Categories findById (Integer id) throws RegistryNotFoundException {
        Optional <Categories> categoria = categoriesRepository.findById(id);
        return categoria.orElseThrow(() -> new RegistryNotFoundException (id));
    }
    
    public List <Categories> findAll (Pageable pagina) {
        return categoriesRepository.findAll(pagina).getContent ();
    }
    
}
