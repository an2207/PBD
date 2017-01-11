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
public class Usluga {
    
    @PrimaryKey @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
    int uslugaId;
    String nazwa;
    Double cena;
    Integer szacCzas;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Integer getSzacCzas() {
        return szacCzas;
    }

    public void setSzacCzas(Integer szacCzas) {
        this.szacCzas = szacCzas;
    }

    public Usluga(String nazwa, Double cena, Integer szacCzas) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.szacCzas = szacCzas;
    }

}

