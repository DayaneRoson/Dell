
package com.residencia.dell.services;

import com.residencia.dell.VO.ItemOrderLinesVO;
import com.residencia.dell.VO.NotaFiscalVO;
import com.residencia.dell.VO.OrderLinesVO;
import com.residencia.dell.VO.OrdersVO;
import com.residencia.dell.entities.OrderLines;
import com.residencia.dell.entities.Orders;
import com.residencia.dell.repositories.CustomersRepository;
import com.residencia.dell.repositories.OrderLinesRepository;
import com.residencia.dell.repositories.OrdersRepository;
import com.residencia.dell.repositories.ProductsRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dayane
 */
@Service
public class OrdersService {
    
    @Autowired
    public OrdersRepository ordersRepository;
    
    @Autowired
    public CustomersRepository customerRepository;
    
    @Autowired
    public ProductsRepository productsRepository;
    
    @Autowired
    public OrderLinesRepository orderlineRepository;
    
    
    public OrdersVO findById (Integer id) {
       Orders orders =  ordersRepository.findById (id).get();
       OrdersVO ordersVO = converteEntidadeVO (orders);
       return ordersVO;
    }
    
    public List <OrdersVO> findAll (Pageable page) {
        List <OrdersVO> listOrdersVO = new ArrayList <> ();
        List <Orders> listOrders = null;
        
        listOrders = ordersRepository.findAll(page).getContent();
        
        for (Orders orders : listOrders) {
            OrdersVO ordersVO = converteEntidadeVO (orders);
            listOrdersVO.add(ordersVO);
        }
        return listOrdersVO;
    }
    
    public Long count () {
        return ordersRepository.count();
    }
    
    public OrdersVO save (OrdersVO ordersVO) {
        Orders newOrders = converteVOEntidade (ordersVO, null);
        return converteEntidadeVO (newOrders);
    }
    
    public void delete (Integer id) {
        ordersRepository.deleteById(id);
    }
    
    //melhorar o update
    public OrdersVO update (Integer id, OrdersVO ordersVO) {
        Orders Orders = converteVOEntidade (ordersVO, id);
        Orders newOrders = ordersRepository.save(Orders);
        
        return converteEntidadeVO (newOrders);
    }

     private OrdersVO converteEntidadeVO(Orders orders) {
        OrdersVO ordersVO = new OrdersVO ();
        List <OrderLines> listOrderLines = orders.getListOrderLines();
        List<OrderLinesVO> listOrderLinesVO = new ArrayList<>();
        
        ordersVO.setOrderId(orders.getOrderId());
        ordersVO.setOrderDate(orders.getOrderDate());
        ordersVO.setNetAmount(orders.getNetAmount());
        ordersVO.setTax(orders.getTax());
        ordersVO.setTotalAmount(orders.getTotalAmount());
        ordersVO.setCustomerId(orders.getCustomer().getCustomerId());
        ordersVO.setFirstName(orders.getCustomer().getFirstName());  //resolver o possivel null pointer
        ordersVO.setUsername(orders.getCustomer().getUsername());
        if (orders.getCustomer().getAddress1() != null) {
            ordersVO.setAddress(orders.getCustomer().getAddress1());
        } else {
            ordersVO.setAddress(orders.getCustomer().getAddress2());
        }
        ordersVO.setCity(orders.getCustomer().getCity());
        ordersVO.setState(orders.getCustomer().getState());
        ordersVO.setZipCode(orders.getCustomer().getZipCode());
        ordersVO.setPhone(orders.getCustomer().getPhone());
        ordersVO.setCreditCardType(orders.getCustomer().getCreditCardType());
        ordersVO.setCreditCard(orders.getCustomer().getCreditCard());
        ordersVO.setCreditCardExpiration(orders.getCustomer().getCreditCardExpiration());
        
        for (OrderLines listinhaOrderLines : listOrderLines) {
            OrderLinesVO orderLinesVO = new OrderLinesVO (listinhaOrderLines.getOrderLinesId(), 
                    listinhaOrderLines.getProdId(), listinhaOrderLines.getQuantity(),
                    listinhaOrderLines.getOrderDate());
            
            listOrderLinesVO.add(orderLinesVO);
        }
        ordersVO.setListOrderLinesVO(listOrderLinesVO);
        return ordersVO;
    }
     
     private Orders converteVOEntidade(OrdersVO ordersVO, Integer id) {
        Orders orders = new Orders ();
        List <OrderLinesVO> listOrderLinesVO = ordersVO.getListOrderLinesVO();
        List <OrderLines> listOrderLines = new ArrayList <> (); 
        orders.setOrderId((null == id) ? ordersVO.getOrderId() : id);
        orders.setOrderDate(ordersVO.getOrderDate());
        orders.setCustomer(customerRepository.findById(ordersVO.getCustomerId()).get());
        orders.setNetAmount(ordersVO.getNetAmount());
        orders.setTax(ordersVO.getTax());
        orders.setTotalAmount(ordersVO.getTotalAmount());
        
        ordersRepository.save(orders);
        
        Integer contador = 1;
        for (OrderLinesVO orderlinesVO: listOrderLinesVO) {
            
            OrderLines orderlines = new OrderLines(contador, 
            		orders.getOrderId(),
            		orderlinesVO.getProdId(),
            		orderlinesVO.getQuantity(),
            		orderlinesVO.getOrderDate()
            		);
            
            orderlineRepository.save(orderlines);
            listOrderLines.add(orderlines);
            contador++;
        }
        orders.setListOrderLines(listOrderLines);
        return orders;
    }
     
    public NotaFiscalVO emitirNotaFiscal (Integer orderId) {
        
        Orders orders = ordersRepository.findById(orderId).get();
        List <OrderLines> listOrderlines = orders.getListOrderLines();
        
        NotaFiscalVO notafiscalVO = new NotaFiscalVO ();
        
        notafiscalVO.setOrderId(orders.getOrderId());
        notafiscalVO.setOrderDate(orders.getOrderDate());
        notafiscalVO.setNetAmount(orders.getNetAmount());
        notafiscalVO.setTax(orders.getTax());
        notafiscalVO.setTotalAmount(orders.getTotalAmount());
        
        if (orders.getCustomer() != null) {
            notafiscalVO.setCustomerId(orders.getCustomer().getCustomerId());
            notafiscalVO.setCustomerFirstName(orders.getCustomer().getFirstName());
            notafiscalVO.setCustomerLastName(orders.getCustomer().getLastName());
            notafiscalVO.setUsername(orders.getCustomer().getUsername());
            if (orders.getCustomer().getAddress1() != null) {
                notafiscalVO.setAddress(orders.getCustomer().getAddress1());
            } else {
                notafiscalVO.setAddress(orders.getCustomer().getAddress2());
            }
            notafiscalVO.setCity(orders.getCustomer().getCity());
            notafiscalVO.setState(orders.getCustomer().getState());
            notafiscalVO.setZipCode(orders.getCustomer().getZipCode());
            notafiscalVO.setPhone(orders.getCustomer().getPhone());
            notafiscalVO.setCreditCardType(orders.getCustomer().getCreditCardType());
            notafiscalVO.setCreditCard(orders.getCustomer().getCreditCard());
            notafiscalVO.setCreditCardExpiration(orders.getCustomer().getCreditCardExpiration());
        
        
        List <ItemOrderLinesVO> listItemOrderLinesVO = new ArrayList <> ();
        //List <ProductsVO> listProductsVO = new ArrayList <> ();
        for (OrderLines orderLines : listOrderlines) {
            ItemOrderLinesVO itemOrderLinesVO = new ItemOrderLinesVO (orderLines.getProdId(), 
                    orderLines.getQuantity(), orderLines.getOrderDate());
            if (productsRepository.findById(orderLines.getProdId()).get() != null) {
                 itemOrderLinesVO.setPrice(productsRepository.findById(orderLines.getProdId()).get().getPrice());
                 itemOrderLinesVO.setTitle(productsRepository.findById(orderLines.getProdId()).get().getTitle());
            } else {
                 itemOrderLinesVO.setPrice(null);
                 itemOrderLinesVO.setTitle(null);
            }
            //listProductsVO.add(productsService.findByIdVO(orderLines.getProdId()));
            listItemOrderLinesVO.add(itemOrderLinesVO);
            //notafiscalVO.setProductsVO(listProductsVO);
            //notafiscalVO.setProductsVO(productsService.findByIdVO(orderLines.getProdId()));
        }
        //notafiscalVO.setProductsVO(listProductsVO);
        notafiscalVO.setListItemOrderLinesVO(listItemOrderLinesVO);
        
        }
        return notafiscalVO;
    }
    
    //(null == id) ? ordersVO.getOrderId() : idnull == idOrderLine) ? orderlinesVO.getOrderLineId() : idOrderLine
            
            //EntityManagerFactory factory = Persistence.createEntityManagerFactory("OrderLines"); ACHAR O PERSISTENCE.XML
            //EntityManager entityManager = factory.createEntityManager();
     
    /*OrderLines orderlines = new OrderLines ();
            
            orderlines.setOrderLineId((orderlinesVO.getOrderLineId()));
            orderlines.setProdId(orderlinesVO.getProdId());
            orderlines.setQuantity(orderlinesVO.getQuantity());
            orderlines.setOrderDate(orderlinesVO.getOrderDate());*/
            
            //entityManager.getTransaction().begin();
            //entityManager.persist(orderlines);
            //entityManager.getTransaction().commit();
            //entityManager.close();
            //factory.close();
}
