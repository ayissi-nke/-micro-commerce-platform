/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.microcommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author AYISSI NKE JOEL NARC
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProduitNotFoundExecption extends RuntimeException {

    public ProduitNotFoundExecption(String s) {
        super(s);
        
    }
    
}
