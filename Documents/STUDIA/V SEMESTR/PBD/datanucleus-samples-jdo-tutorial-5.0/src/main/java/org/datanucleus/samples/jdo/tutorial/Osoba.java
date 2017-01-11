/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datanucleus.samples.jdo.tutorial;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 *
 * @author Anna Hnatkowska
 */

@PersistenceCapable 
public class Osoba {

    @PrimaryKey @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT) 
    int osobaId;
    String email;
    String telefon;
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Osoba(String email) {
        this.email = email;
    }

    public Osoba(String email, String telefon) {
        this.email = email;
        this.telefon = telefon;
    }

    public Osoba() {
    }

    
}