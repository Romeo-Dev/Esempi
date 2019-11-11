/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author romeo
 */
public class Rubrica {
    
    private List<Contatto> contatti;

    public Rubrica() {
        contatti = new LinkedList<>();
    }

    public List<Contatto> getContatti() {
        return contatti;
    }

    public void setContatti(List<Contatto> contatti) {
        this.contatti = contatti;
    }
    
    
    public boolean addContatto(String nome, String cognome,String tel){
        Contatto nuovo = new Contatto(nome,cognome,tel);
        if(!this.contatti.contains(nuovo)) {
         this.contatti.add(nuovo);
         return true;
        }
        
        for(Contatto c: this.contatti){
            if(c.equals(nuovo) && c.checkOneNumber(nuovo) == false){
                c.addNumber(tel);
                return true;
            }
        }
        return false;
    }
    
    public boolean removeContatto(String nome, String cognome){
        Contatto rim = new Contatto(nome, cognome);
        if(!this.contatti.contains(rim)) return false;
        
        Contatto match;
        Iterator<Contatto> itr = this.contatti.iterator();
        while(itr.hasNext()){
            match = itr.next();
            
           if(match.equals(rim)){
               itr.remove();
               return true;
           }
        }
        return false;
    }
    
    
    public List<String> cerca (String nome, String cognome){
        Contatto cercato = new Contatto(nome, cognome);
        if(!this.contatti.contains(cercato)){
            System.out.println("Utente non presente nella rubrica");
            return null;
        }
        for(Contatto c: this.contatti){
            if(c.equals(cercato)){
                if(!c.getNumeri().isEmpty()){
                    System.out.println("Numeri trovati dalla ricerca");
                    return c.getNumeri();
                }else{
                    System.out.println("Nessun numero associato al contatto");
                    return null;
                }
            }
        }
        return null;
    }
    
    public void sortBySurname(){
        Collections.sort(contatti);
        this.print();
    }
    
    public void print(){
        if(this.contatti.isEmpty()){
            System.out.println("Rubrica vuota");
        }else{
            this.contatti.forEach((c) -> {
                System.out.println(c);
            });
        }
    }
}
