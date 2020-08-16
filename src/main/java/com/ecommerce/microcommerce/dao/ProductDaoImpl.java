/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.modele.Produits;
import java.util.List;
import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AYISSI NKE JOEL NARC
 */

/*
@Repository
public class ProductDaoImpl implements ProductDao {
    
    
    
    public static List<Produits> produits =newArrayList();
    static {
        produits.add(new Produits(1, new String("Ordinateur portable"), 350 ,1000));
        produits.add(new Produits(2, new String("Aspirateur Robot"), 500,2000)); 
        produits.add(new Produits(3, new String("Table de Ping Pong"), 750,3000));
    }

    @Override
    public List<Produits> findAll() {
      return produits ;  
    }

    @Override
    public Produits findById(int id) {
        for(Produits produits : produits){
            if(produits.getId()==id){
            return produits;
            }
            
        }
        return null ;
    }

    @Override
    public Produits saveProduits(Produits produit) {
        produits.add(produit);
        return produit ;
    }
    
}
*/