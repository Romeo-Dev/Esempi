/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;



/**
 *
 * @author romeo
 */
public class Test {
    
    public static void main(String args[]){
        //inserisco contatti
        Rubrica rubrica = new Rubrica();
      Contatto c2 = new Contatto("Romeo", "Dev", "3938115015");
      
      // Opero con rubrica
      
      rubrica.addContatto("Romeo", "Debian","3938115015");
      rubrica.addContatto("Master", "Dev","15015");
      rubrica.addContatto("Romeo", "Debian","393811681");
      rubrica.addContatto("Romeo", "Debian","393811681");
      rubrica.addContatto("Romeo", "Debian","34890245181");
      rubrica.addContatto("Alexa", "Bringham","9873215181");
      rubrica.print();
       System.out.println(rubrica.cerca("Romeo", "Debian")+"\n");
      rubrica.cerca("Romeo", "Mint");
      
        System.out.println("\tOrdiniamo per cognome\n");
      rubrica.sortBySurname();
      
    }
    
}
