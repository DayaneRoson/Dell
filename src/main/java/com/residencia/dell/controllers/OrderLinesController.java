
package com.residencia.dell.controllers;

import com.residencia.dell.entities.OrderLines;
import com.residencia.dell.entities.OrderLinesId;
import com.residencia.dell.services.OrderlinesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
@RequestMapping ("/orderlines")
public class OrderLinesController {
    
     @Autowired
    private OrderlinesService orderlinesService;
    
    @GetMapping ("/{orderlineid}/{orderid}")
    public ResponseEntity <OrderLines> findById (@PathVariable OrderLinesId orderlineId) {
        HttpHeaders headers = new HttpHeaders (); 
        return new ResponseEntity <> (orderlinesService.findById(orderlineId), headers, HttpStatus.OK);
    }
    
    @GetMapping //paginacao com parametro, passa os parametros na requisicao 
	public ResponseEntity <List <OrderLines>> findAll (Pageable pagina) {
            List <OrderLines> listOrderLines = orderlinesService.findAll(pagina);
            return ResponseEntity.ok().body(listOrderLines);
        }
        
    @GetMapping ("/count")
          public Long count() {
            return orderlinesService.count();
          }
    
    @PostMapping
        public ResponseEntity <OrderLines> save (@RequestBody OrderLines orderlines) {
           HttpHeaders headers = new HttpHeaders();
           OrderLines orderline = orderlinesService.save(orderlines);
            if(null != orderline)
		return ResponseEntity.ok().body(orderline);
            else
		return new ResponseEntity<>(orderlinesService.save(orderline), headers, HttpStatus.BAD_REQUEST); 
        }
        
    @PutMapping ("/{orderlineid}/{orderid}")
        public ResponseEntity <OrderLines> update (@PathVariable OrderLinesId orderlinesId, @RequestBody OrderLines orderline) {
            HttpHeaders headers = new HttpHeaders ();
            return new ResponseEntity <> (orderlinesService.update(orderlinesId, orderline), 
                    headers, HttpStatus.OK);
        }
        
    
    @DeleteMapping ("/{id}/{}")
        public ResponseEntity<OrderLines> delete(@PathVariable OrderLinesId orderlinesId) {
            try {
                orderlinesService.delete(orderlinesId);
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().build();
        }
}
