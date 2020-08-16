/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.microcommerce.controller;


import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.modele.Produits     ;
import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.URI;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author AYISSI NKE JOEL NARC
 */
@RestController 
public class ProductController {
    @Autowired
    public ProductDao productDao ;
    
    @RequestMapping(value="/produits", method=RequestMethod.GET)
    
    public MappingJacksonValue listeProduits() {
        
        Iterable<Produits> product = productDao.findAll();
        SimpleBeanPropertyFilter monfiltre = SimpleBeanPropertyFilter.serializeAllExcept("unitprice") ;
        FilterProvider ListeDeFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monfiltre) ;
        MappingJacksonValue produitsFiltres = new MappingJacksonValue(product);
        produitsFiltres.setFilters(ListeDeFiltres);
        
        return produitsFiltres ;
    }
    @GetMapping(value="/test/{prix}")
     public List<Produits> test(@PathVariable int prix ){
    
    return productDao.findByPrixGreaterThan(prix) ;
     
     }
   @GetMapping(value="/produits/{id}") 
   public Produits afficherUnProduit(@PathVariable int id){
       Produits produit = productDao.findById(id) ;
       if(produit == null)
           throw new ProduitNotFoundExecption("le produit avec id"+id +"existe pas"); 
       
   return  produit;
   } 
   @PostMapping(value="/produit")
   public ResponseEntity<Void>  addproduct(@Valid @RequestBody Produits product){
        Produits productAdded = productDao.save(product) ;

        if(productAdded == null) {

        return ResponseEntity.noContent().build() ;
        }
         URI location = ServletUriComponentsBuilder
                 .fromCurrentRequest()
                 .path("/{id}")
                 .buildAndExpand(productAdded.getId())
                 .toUri() ;
        return ResponseEntity.created(location).build() ;
    }
   
   @DeleteMapping(value="/produits/{id}")
   
   public void supprimer(@PathVariable int id){
    
   productDao.delete(productDao.findById(id));
    
   }

}
