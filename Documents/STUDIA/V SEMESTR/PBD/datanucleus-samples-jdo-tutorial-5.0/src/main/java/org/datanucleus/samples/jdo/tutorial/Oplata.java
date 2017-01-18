/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datanucleus.samples.jdo.tutorial;

import java.util.Date;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.ForeignKeyAction;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

/**
 *
 * @author Anna Hnatkowska
 */
@PersistenceCapable
public class Oplata {

    @PrimaryKey @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT) 
    int oplataId;
    Date dzienWplaty;
    Date dataObow;
    @ForeignKey(name="fk_oplata_kwatera", deleteAction = ForeignKeyAction.RESTRICT, updateAction=ForeignKeyAction.CASCADE)
    Kwatera kwatera;
    
    Zmarly zmarly;
    Wlasciciel wlasciciel;
    Cennik cennik;
    
    
    public Date getDzienWplaty() {
        return dzienWplaty;
    }

    public void setDzienWplaty(Date dzienWplaty) {
        this.dzienWplaty = dzienWplaty;
    }

    public Date getDataObow() {
        return dataObow;
    }

    public void setDataObow(Date dataObow) {
        this.dataObow = dataObow;
    }

    public Kwatera getKwatera() {
        return kwatera;
    }

    public void setKwatera(Kwatera kwatera) {
        this.kwatera = kwatera;
    }

    public Zmarly getZmarly() {
        return zmarly;
    }

    public void setZmarly(Zmarly zmarly) {
        this.zmarly = zmarly;
    }

    public Wlasciciel getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(Wlasciciel wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    public Cennik getCennik() {
        return cennik;
    }

    public void setCennik(Cennik cennik) {
        this.cennik = cennik;
    }

    public Oplata(Date dzienWplaty, Date dataObow, Kwatera kwatera, Zmarly zmarly, Wlasciciel wlasciciel, Cennik cennik) {
        this.dzienWplaty = dzienWplaty;
        this.dataObow = dataObow;
        this.kwatera = kwatera;
        this.zmarly = zmarly;
        this.wlasciciel = wlasciciel;
        this.cennik = cennik;
    }

    public Oplata(Date dzienWplaty, Date dataObow, Kwatera kwatera, Wlasciciel wlasciciel, Cennik cennik) {
        this.dzienWplaty = dzienWplaty;
        this.dataObow = dataObow;
        this.kwatera = kwatera;
        this.wlasciciel = wlasciciel;
        this.cennik = cennik;
    }
    

}