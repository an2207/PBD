/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datanucleus.samples.jdo.tutorial;

import java.util.ArrayList;
import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 *
 * @author Anna Hnatkowska
 */

@PersistenceCapable
public class Zlecenie {
    
    @PrimaryKey @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
    int zlecenieId;
    Date dataRozp;
    Date dataZak;
    OsobaFizyczna pracownik;
    ArrayList<Kwatera> kwatery;
    Usluga usluga;
    Osoba zleceniodawca;
    
    public Zlecenie(Date dataRozp, Date dataZak, OsobaFizyczna pracownik, ArrayList<Kwatera> kwatery, Usluga usluga, Osoba zleceniodawca) {
        this.dataRozp = dataRozp;
        this.dataZak = dataZak;
        this.pracownik = pracownik;
        this.kwatery = kwatery;
        this.usluga = usluga;
        this.zleceniodawca = zleceniodawca;
    }
    
    public Zlecenie()
    {
    
    }

    public Date getDataRozp() {
        return dataRozp;
    }

    public void setDataRozp(Date dataRozp) {
        this.dataRozp = dataRozp;
    }

    public Date getDataZak() {
        return dataZak;
    }

    public void setDataZak(Date dataZak) {
        this.dataZak = dataZak;
    }

    public OsobaFizyczna getPracownik() {
        return pracownik;
    }

    public void setPracownik(OsobaFizyczna pracownik) {
        this.pracownik = pracownik;
    }

    public ArrayList<Kwatera> getKwatery() {
        return kwatery;
    }

    public void setKwatery(ArrayList<Kwatera> kwatery) {
        this.kwatery = kwatery;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    public Osoba getZleceniodawca() {
        return zleceniodawca;
    }

    public void setZleceniodawca(Osoba zleceniodawca) {
        this.zleceniodawca = zleceniodawca;
    }



}

