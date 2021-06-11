
package com.residencia.dell.controllers;

import com.residencia.dell.entities.Categories;
import com.residencia.dell.exception.RegistryNotFoundException;
import com.residencia.dell.services.CategoriesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
     @GetMapping ("/{id}")
    public ResponseEntity <Categories> findById (@PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders (); 
        return new ResponseEntity <> (categoriesService.findById(id), headers, HttpStatus.OK);
    } 
       
    
    @GetMapping
	public ResponseEntity <List <Categories>> findAll (Pageable page ) {
            List <Categories> listCategories = categoriesService.findAll(page);
            return ResponseEntity.ok().body(listCategories);
        }
}
