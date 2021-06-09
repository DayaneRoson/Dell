
package com.residencia.dell.controllers;

import com.residencia.dell.VO.NotaFiscalVO;
import com.residencia.dell.VO.OrdersVO;
import com.residencia.dell.services.OrdersService;
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
@RequestMapping ("/orders")
public class OrdersController {
    
    @Autowired
    private OrdersService ordersService;
    
    @GetMapping ("/{id}")
    public ResponseEntity <OrdersVO> findById (@PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders (); 
        return new ResponseEntity <> (ordersService.findById(id), headers, HttpStatus.OK);
    }
    
    @GetMapping("/notafiscal/{id}")
	public ResponseEntity<NotaFiscalVO> emitirNotaFiscal(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(ordersService.emitirNotaFiscal(id), headers, HttpStatus.OK);
	}
    
    @GetMapping //Paginacao com parametro, passa os parametros na requisicao
	public ResponseEntity <List <OrdersVO>> findAll (Pageable pagina) {
            List <OrdersVO> listOrdersVO = ordersService.findAll(pagina);
            return ResponseEntity.ok().body(listOrdersVO);
        }
        
    @GetMapping ("/count")
        public Long count() {
            return ordersService.count();
        }
        
    @PostMapping
        public ResponseEntity <OrdersVO> save (@RequestBody OrdersVO orderVO) {
           HttpHeaders headers = new HttpHeaders();
           OrdersVO ordersVO = ordersService.save(orderVO);
            if(null != ordersVO)
		return ResponseEntity.ok().body(ordersVO);
            else
		return new ResponseEntity<>(ordersService.save(ordersVO), headers, HttpStatus.BAD_REQUEST); 
        }
        
    @PutMapping ("/{id}")
        public ResponseEntity <OrdersVO> update (@PathVariable Integer id, @PathVariable Integer idOrderLine, 
                @RequestBody OrdersVO ordersVO) {
            HttpHeaders headers = new HttpHeaders ();
            return new ResponseEntity <> (ordersService.update(id, idOrderLine, ordersVO), headers, HttpStatus.OK);
        }
        
    
    @DeleteMapping ("/{id}")
        public ResponseEntity<OrdersVO> delete(@PathVariable Integer id) {
            try {
                ordersService.delete(id);
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().build();
        }
}
