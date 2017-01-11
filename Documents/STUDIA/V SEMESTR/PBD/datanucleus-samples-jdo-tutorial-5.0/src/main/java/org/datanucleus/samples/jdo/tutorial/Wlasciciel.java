/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datanucleus.samples.jdo.tutorial;

import java.util.ArrayList;
import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.ForeignKeyAction;
import javax.jdo.annotations.PersistenceCapable;

/**
 *
 * @author Anna Hnatkowska
 */

@PersistenceCapable
public class Wlasciciel extends OsobaFizyczna {

    @ForeignKey(name="ADRES_FK", deleteAction = ForeignKeyAction.RESTRICT)
    Adres adres;
    @ForeignKey(name="OPLATA_FK", deleteAction = ForeignKeyAction.RESTRICT)
    ArrayList<Oplata> oplaty;

    public Wlasciciel(String imie, String drugieImie, String nazwisko, String drugieNazwisko, String pesel, String email) {
        super(imie, drugieImie, nazwisko, drugieNazwisko, pesel, email);
    }
    
    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public ArrayList<Oplata> getOplaty() {
        return oplaty;
    }

    public void setOplaty(ArrayList<Oplata> oplaty) {
        this.oplaty = oplaty;
    }

    @Override
    public String getImie() {
        return imie;
    }

    @Override
    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getDrugieImie() {
        return drugieImie;
    }

    @Override
    public void setDrugieImie(String drugieImie) {
        this.drugieImie = drugieImie;
    }

    @Override
    public String getNazwisko() {
        return nazwisko;
    }

    @Override
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public String getDrugieNazwisko() {
        return drugieNazwisko;
    }

    @Override
    public void setDrugieNazwisko(String drugieNazwisko) {
        this.drugieNazwisko = drugieNazwisko;
    }

    @Override
    public String getPesel() {
        return pesel;
    }

    @Override
    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getTelefon() {
        return telefon;
    }

    @Override
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    //sunday metoda - Wypisuje kwatery, które są własnością danego właściela
    @Override 
    public ArrayList<Kwatera> queryKwatery(){ 
		 ArrayList<Kwatera> kwatery = new ArrayList<Kwatera>();
         ListIterator litr=this.oplaty.listIterator();
		 while(litr.hasNext()){ 
		    Kwatera kw=(Kwatera)litr.next();
		    kwatery.add(kw);
		 }
		 return kwatery;
    }

}
