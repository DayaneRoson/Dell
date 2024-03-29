
package com.residencia.dell.controllers;

import com.residencia.dell.entities.Customers;
import com.residencia.dell.entities.Products;
import com.residencia.dell.services.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
@RequestMapping ("/customers")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @GetMapping ("/{id}")
    public ResponseEntity <Customers> findById (@PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders (); 
        return new ResponseEntity <> (customerService.findById(id), headers, HttpStatus.OK);
    }
    
    @GetMapping //Paginacao com parametro, passa os parametros na requisicao
	public ResponseEntity <List <Customers>> findAll (Pageable pagina) {
            List <Customers> listCustomers = customerService.findAll(pagina);
            return ResponseEntity.ok().body(listCustomers);
        }
        
    @GetMapping ("/count")
        public Long count() {
            return customerService.count();
        }
        
    @PostMapping
        public ResponseEntity <Customers> save (@RequestBody Customers customer) {
           HttpHeaders headers = new HttpHeaders();
           Customers customers = customerService.save(customer);
            if(null != customers)
		return ResponseEntity.ok().body(customers);
            else
		return new ResponseEntity<>(customerService.save(customers), headers, HttpStatus.BAD_REQUEST); 
        }
        
    @PutMapping ("/{id}")
        public ResponseEntity <Customers> update (@PathVariable Integer id, @RequestBody Customers customer) {
            HttpHeaders headers = new HttpHeaders ();
            return new ResponseEntity <> (customerService.update(id, customer), headers, HttpStatus.OK);
        }
        
    
    @DeleteMapping ("/{id}")
        public ResponseEntity<Products> delete(@PathVariable Integer id) {
            try {
                customerService.delete(id);
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().build();
        }
}
