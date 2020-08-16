/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.modele.Produits;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AYISSI NKE JOEL NARC
 */
@Repository
public interface ProductDao extends JpaRepository<Produits, Integer> {
    
    List<Produits> findByPrixGreaterThan(int prix);
     
    
   /* public List<Produits>findAll();*/
    public Produits findById(int id );
    public Produits save(Produits produirs);

    
    
    
}
