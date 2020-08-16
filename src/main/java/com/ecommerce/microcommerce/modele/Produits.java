/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.microcommerce.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author AYISSI NKE JOEL NARC
 */
@Entity
public class Produits {
    
    @Id
    @GeneratedValue
    private int id ;
    @Length(min=3,max=50)
    private String nom;
    @Min(value=10)
    private int  prix ;
    
    @JsonIgnore 
    private int unitprice ;

    public Produits() {
    }

    public int getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(int unitprice) {
        this.unitprice = unitprice;
    }

    public Produits(int id, String nom, int prix ,int unitprice) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.unitprice = unitprice ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produits{" + "id=" + id + ", nom=" + nom + ", prix=" + prix + '}';
    }
    
    
}
