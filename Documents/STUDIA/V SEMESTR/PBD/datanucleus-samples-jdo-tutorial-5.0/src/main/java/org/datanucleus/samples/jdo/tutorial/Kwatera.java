/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datanucleus.samples.jdo.tutorial;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.ForeignKeyAction;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

/**
 *
 * @author Anna Hnatkowska
 */

@PersistenceCapable(objectIdClass=PKKwat.class)
public class Kwatera {

    @PrimaryKey
    int nrSektora;
    @PrimaryKey
    int nrKwatery;
    
    int liczbaMsc;
    @ForeignKey(name="fk_Rodzaj_kwatera", deleteAction = ForeignKeyAction.RESTRICT, updateAction=ForeignKeyAction.CASCADE)
    @Column(name="RODZAJID")
    RodzajKwatery rodzaj;
    
    public int getNrSektora() {
        return nrSektora;
    }

    public void setNrSektora(int nrSektora) {
        this.nrSektora = nrSektora;
    }

    public int getNrKwatery() {
        return nrKwatery;
    }

    public void setNrKwatery(int nrKwatery) {
        this.nrKwatery = nrKwatery;
    }

    public int getLiczbaMsc() {
        return liczbaMsc;
    }

    public void setLiczbaMsc(int liczbaMsc) {
        this.liczbaMsc = liczbaMsc;
    }

    public RodzajKwatery getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(RodzajKwatery rodzaj) {
        this.rodzaj = rodzaj;
    }

    public Kwatera(int nrSektora, int nrKwatery, int liczbaMsc, RodzajKwatery rodzaj) {
        this.nrSektora = nrSektora;
        this.nrKwatery = nrKwatery;
        this.liczbaMsc = liczbaMsc;
        this.rodzaj = rodzaj;
    }

}



