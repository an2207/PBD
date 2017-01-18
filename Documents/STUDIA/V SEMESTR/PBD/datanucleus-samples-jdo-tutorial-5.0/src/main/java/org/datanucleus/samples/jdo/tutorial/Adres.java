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
public class Adres {

    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)   
    protected long adresId;
    
    @Column(jdbcType="VARCHAR", length=64)
    String ulica;
    
    @Column(jdbcType="VARCHAR", length=8)
    String nrBudynku;
    
    @Column(jdbcType="VARCHAR", length=8)
    String nrLokalu;
    
    @Column(jdbcType="VARCHAR", length=6)
    String kodPocztowy;
    
    @Column(jdbcType="VARCHAR", length=64)
    String miejscowosc;
    
    @Column(jdbcType="VARCHAR", length=64)
    String kraj;

    public long getAdresId() {
        return adresId;
    }
    
    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNrBudynku() {
        return nrBudynku;
    }

    public void setNrBudynku(String nrBudynku) {
        this.nrBudynku = nrBudynku;
    }

    public String getNrLokalu() {
        return nrLokalu;
    }

    public void setNrLokalu(String nrLokalu) {
        this.nrLokalu = nrLokalu;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public Adres(String ulica, String nrBudynku, String nrLokalu, String kodPocztowy, String miejscowosc, String kraj) {
        this.ulica = ulica;
        this.nrBudynku = nrBudynku;
        this.nrLokalu = nrLokalu;
        this.kodPocztowy = kodPocztowy;
        this.miejscowosc = miejscowosc;
        this.kraj = kraj;
    }
    
    public Adres(String ulica){
        this.ulica = ulica;
    }
    
    public Adres()
    {
    
    }

}

