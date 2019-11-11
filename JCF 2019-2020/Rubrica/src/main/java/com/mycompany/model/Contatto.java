/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author romeo
 */
public class Contatto implements Comparable<Contatto>{
    
    private String nome;
    private String cognome;
    List<String> numeri;
    
    

    public Contatto(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }
    
    public Contatto(String nome, String cognome,String tel) {
        this.nome = nome;
        this.cognome = cognome;
        numeri = new ArrayList<>();
        numeri.add(tel);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public List<String> getNumeri() {
        return numeri;
    }

    public void setNumeri(List<String> numeri) {
        this.numeri = numeri;
    }
    
    public boolean addNumber(String tel){
        if(numeri.contains(tel)) return false;
        numeri.add(tel);
        System.out.println("Numero aggiunto");
        return true;
    }

    @Override
    public String toString() {
        return "Nome: "+nome+"\t Cognome: "+cognome+"\n"+
               "Numeri: "+numeri;
    }

    @Override
    public boolean equals(Object obj) {
       if( obj == null) return false;
       if(!(obj instanceof Contatto)) return false;
       Contatto c = (Contatto) obj;
       
       return (this.nome.equalsIgnoreCase(c.nome) && this.cognome.equalsIgnoreCase(c.cognome));
    }
    
    
    public boolean checkOneNumber(Contatto c){
        boolean match = false;
        for(String find: this.numeri){
            if(c.numeri.contains(find)){
                match = true;
            }
        }
        return match;
    }

    @Override
    public int compareTo(Contatto o) {
       if(!(this.cognome.compareTo(o.cognome) == 0)){
           if(this.cognome.compareTo(o.cognome) > 0) return 1;
           if(this.cognome.compareTo(o.cognome) < 0) return -1;
       }
     return 0;   
    }
    
}
