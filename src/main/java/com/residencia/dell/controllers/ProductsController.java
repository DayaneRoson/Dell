
package com.residencia.dell.controllers;

import com.residencia.dell.entities.Products;
import com.residencia.dell.services.ProductsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dayane
 */
@RestController
@RequestMapping ("/products")
public class ProductsController {
    
    @Autowired
    private ProductsService productsService;
    
    @GetMapping ("/{id}")
    public ResponseEntity <Products> findById (@PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders (); 
        return new ResponseEntity <> (productsService.findById(id), headers, HttpStatus.OK);
    }
    
    @GetMapping
	public ResponseEntity <List <Products>> findAll () {
            List <Products> listProducts = productsService.findAll();
            return ResponseEntity.ok().body(listProducts);
        }
        
    @GetMapping ("/count")
        public Long count() {
            return productsService.count();
        }
        
    @PostMapping
        public ResponseEntity <Products> save (@RequestBody Products product) {
           HttpHeaders headers = new HttpHeaders();
           Products products = productsService.save(product);
            if(null != products)
		return ResponseEntity.ok().body(products);
            else
		return new ResponseEntity<>(productsService.save(products), headers, HttpStatus.BAD_REQUEST); 
        }
        
    @PutMapping ("/{id}")
        public ResponseEntity <Products> update (@PathVariable Integer id, @RequestBody Products product) {
            HttpHeaders headers = new HttpHeaders ();
            return new ResponseEntity <> (productsService.update(id, product), headers, HttpStatus.OK);
        }
        
    
    @DeleteMapping ("/{id}")
        public ResponseEntity<Products> delete(@PathVariable Integer id) {
            try {
                productsService.delete(id);
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().build();
        }
}
