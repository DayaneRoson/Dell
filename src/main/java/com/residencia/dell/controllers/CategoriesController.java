
package com.residencia.dell.controllers;

import com.residencia.dell.entities.Categories;
import com.residencia.dell.services.CategoriesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dayane
 */
@RestController
@RequestMapping ("/categories")
public class CategoriesController {
    
    @Autowired
    public CategoriesService categoriesService;
    
    @GetMapping
	public ResponseEntity <List <Categories>> findAll () {
            List <Categories> listCategories = categoriesService.findAll();
            return ResponseEntity.ok().body(listCategories);
        }
}
