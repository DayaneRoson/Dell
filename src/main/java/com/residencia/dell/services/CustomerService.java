
package com.residencia.dell.services;

import com.residencia.dell.entities.Customers;
import com.residencia.dell.entities.Products;
import com.residencia.dell.repositories.CustomersRepository;
import com.residencia.dell.repositories.ProductsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dayane
 */
@Service
public class CustomerService {
    
     @Autowired
    public CustomersRepository customerRepository;
    
    public Customers findById (Integer id) {
       return customerRepository.findById (id).get();
    }
    
    public List <Customers> findAll (Pageable page) {
        return customerRepository.findAll(page).getContent();
    }
    
    public Long count () {
        return customerRepository.count();
    }
    
    public Customers save (Customers customer) {
        Customers newCustomer = customerRepository.save (customer);
        return newCustomer;
    }
    
    public void delete (Integer id) {
        customerRepository.deleteById(id);
    }
    
    public Customers update (Integer id, Customers customer) {
        Customers newCustomer = customerRepository.findById (id).get();
        updateDados (newCustomer, customer);
        return customerRepository.save(newCustomer);
    }

    private void updateDados(Customers newCustomer, Customers customer) {
        newCustomer.setFirstName(customer.getFirstName());
        newCustomer.setLastName(customer.getLastName());
        newCustomer.setAddress1(customer.getAddress1());
        newCustomer.setAddress2(customer.getAddress2());
        newCustomer.setCity(customer.getCity());
        newCustomer.setState(customer.getState());
        newCustomer.setZipCode(customer.getZipCode());
        newCustomer.setCountry(customer.getCountry());
        newCustomer.setRegion(customer.getRegion());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setCreditCardType(customer.getCreditCardType());
        newCustomer.setCreditCard(customer.getCreditCard());
        newCustomer.setCreditCardExpiration(customer.getCreditCardExpiration());
        newCustomer.setUsername(customer.getUsername());
        newCustomer.setPassword(customer.getPassword());
        newCustomer.setAge(customer.getAge());
        newCustomer.setIncome(customer.getIncome());
        newCustomer.setGender(customer.getGender());
        newCustomer.setListCustomerHistory(customer.getListCustomerHistory());
        newCustomer.setListOrders(customer.getListOrders());
    }
}
