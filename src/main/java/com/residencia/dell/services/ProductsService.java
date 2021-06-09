
package com.residencia.dell.services;

import com.residencia.dell.VO.ProductsVO;
import com.residencia.dell.entities.Products;
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
public class ProductsService {
    
     @Autowired
    public ProductsRepository productsRepository;
    
    public Products findById (Integer id) {
       return productsRepository.findById (id).get();
    }
    
    public ProductsVO findByIdVO (Integer id) {
        Products products = productsRepository.findById(id).get();
        ProductsVO productsVO = converteEntidadeVO (products);
        return productsVO;
    }
     
    public List <Products> findAll (Pageable page) {
        return productsRepository.findAll(page).getContent();
    }
    
    public List <ProductsVO> findAllVO (Pageable page) {
        List <ProductsVO> listProductsVO = new ArrayList <> ();
        List <Products> listProducts = null;
        
        listProducts = productsRepository.findAll(page).getContent();
        
        for (Products products : listProducts) {
            ProductsVO productsVO = converteEntidadeVO (products);
            listProductsVO.add(productsVO);
        }
        return listProductsVO;
    }

    private ProductsVO converteEntidadeVO(Products products) {
        ProductsVO productsVO = new ProductsVO (products.getProdId(), products.getTitle(),products.getPrice());
        return productsVO;
    }
    
    
    public Long count () {
        return productsRepository.count();
    }
    
    public Products save (Products product) {
        Products newProduct = productsRepository.save (product);
        return newProduct;
    }
    
    public ProductsVO saveVO (ProductsVO productsVO) {
        Products newProducts = converteVOEntidade (productsVO, null);
        productsRepository.save(newProducts);
        return converteEntidadeVO (newProducts);
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
    
    public ProductsVO updateVO (Integer id, ProductsVO productsVO) {
        Products products = converteVOEntidade (productsVO, id);
        Products newProduct = productsRepository.save(products);
        
        return converteEntidadeVO (newProduct);
    }

    private void updateDados(Products newProduct, Products product) {
        newProduct.setCategory(product.getCategory());
        newProduct.setTitle(product.getTitle());
        newProduct.setActor(product.getActor());
        newProduct.setPrice(product.getPrice());
        newProduct.setSpecial(product.getSpecial());
        newProduct.setCommonProdId(product.getCommonProdId());
    }

    private Products converteVOEntidade(ProductsVO productsVO, Integer id) {
        Products products = new Products ();
        
        products.setProdId((null == id) ? products.getProdId() : id);
        products.setTitle(productsVO.getTitle());
        products.setPrice(products.getPrice());
        
        return products;
    }

}
