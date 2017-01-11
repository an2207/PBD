/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datanucleus.samples.jdo.tutorial;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 *
 * @author Anna Hnatkowska
 */
@PersistenceCapable
public class Cennik  {

    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT) 
    int cennikId;
    Double cena;
    @Column(length=3)
    int liczbaLat;
    
    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public int getLiczbaLat() {
        return liczbaLat;
    }

    public void setLiczbaLat(int liczbaLat) {
        this.liczbaLat = liczbaLat;
    }

    public Cennik(Double cena, int liczbaLat) {
        this.cena = cena;
        this.liczbaLat = liczbaLat;
    }

}

