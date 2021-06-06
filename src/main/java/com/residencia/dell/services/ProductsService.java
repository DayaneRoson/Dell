
package com.residencia.dell.services;

import com.residencia.dell.entities.Products;
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
public class ProductsService {
    
     @Autowired
    public ProductsRepository productsRepository;
    
    public Products findById (Integer id) {
       return productsRepository.findById (id).get();
    }
    
    public List <Products> findAll (Pageable page) {
        return productsRepository.findAll(page).getContent();
    }
    
    public Long count () {
        return productsRepository.count();
    }
    
    public Products save (Products product) {
        Products newProduct = productsRepository.save (product);
        return newProduct;
    }
    
    public void delete (Integer id) {
        productsRepository.deleteById(id);
    }
    
    public Products update (Integer id, Products product) {
        Products newProduct = productsRepository.findById (id).get();
        //Alunos novoAluno = alunosRepository.getOne(); função depreciada, poxa queria usar ela
        updateDados (newProduct, product);
        return productsRepository.save(newProduct);
    }

    private void updateDados(Products newProduct, Products product) {
        newProduct.setCategory(product.getCategory());
        newProduct.setTitle(product.getTitle());
        newProduct.setActor(product.getActor());
        newProduct.setPrice(product.getPrice());
        newProduct.setSpecial(product.getSpecial());
        newProduct.setCommonProdId(product.getCommonProdId());
    }
}
