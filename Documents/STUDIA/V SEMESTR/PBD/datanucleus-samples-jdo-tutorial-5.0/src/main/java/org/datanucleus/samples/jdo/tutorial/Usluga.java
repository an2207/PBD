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
public class Usluga {
    
    @PrimaryKey @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
    int uslugaId;
    String nazwa;
    @Column(scale = 2)
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
        if(cena > 0)
            {
                this.cena = cena;
            }
        else
            {
                System.out.println("Cena nie moze byc ujemna!");
            }
    }

    public Integer getSzacCzas() {
        return szacCzas;
    }

    public void setSzacCzas(Integer szacCzas) {
        if(szacCzas > 0)
            {
                this.szacCzas = szacCzas;
            }
        else
            {
                System.out.println("Podano bledny czas uslugi!");
            }
    }

    public Usluga()
    {
    
    }
    
    public Usluga(String nazwa, Double cena, Integer szacCzas) {
        this.nazwa = nazwa;
        if(cena > 0)
            {
                this.cena = cena;
            }
        else
            {
                System.out.println("Cena nie moze byc ujemna!");
                this.cena = 0.0;
            }
        if(szacCzas > 0)
            {
                this.szacCzas = szacCzas;
            }
        else
            {
                System.out.println("Podano bledny czas uslugi!");
                this.szacCzas = 0;
            }
    }

}

