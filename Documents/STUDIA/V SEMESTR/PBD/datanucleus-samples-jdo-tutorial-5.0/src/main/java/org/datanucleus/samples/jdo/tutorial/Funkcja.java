/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datanucleus.samples.jdo.tutorial;

import java.io.Serializable;
import java.util.ArrayList;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.ForeignKeyAction;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 *
 * @author Anna Hnatkowska
 */
@PersistenceCapable
public class Funkcja implements Serializable {
    
    @PrimaryKey @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT) 
    int funkcjaId;
    @Column(jdbcType="VARCHAR", length=64)
    String nazwa;
    @ForeignKey(name="fk_Pracownicy_Funckja", deleteAction = ForeignKeyAction.RESTRICT, updateAction=ForeignKeyAction.CASCADE)
    @Column(name="OSOBAID")
    ArrayList<OsobaFizyczna> pracownicy;
    
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public ArrayList<OsobaFizyczna> getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(ArrayList<OsobaFizyczna> pracownicy) {
        this.pracownicy = pracownicy;
    }

    public Funkcja(String nazwa) {
        this.nazwa = nazwa;
    }
    
    public void addPracownik(OsobaFizyczna p){
        pracownicy.add(p);
    }
    
    public Funkcja()
    {
    
    }
}
