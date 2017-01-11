/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datanucleus.samples.jdo.tutorial;

import java.util.ArrayList;
import java.util.Date;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.ForeignKeyAction;
import javax.jdo.annotations.PersistenceCapable;

/**
 *
 * @author Anna Hnatkowska
 */

@PersistenceCapable
public class Zmarly extends OsobaFizyczna{
 
    @Column(jdbcType = "VARCHAR", length = 64,allowsNull = "true")
    String nazwiskoPanien;
    Date dataUrodzenia;
    Date dataZgonu;
    @ForeignKey(name="fk_Zmarly_Pogrzeb", deleteAction = ForeignKeyAction.CASCADE, updateAction=ForeignKeyAction.RESTRICT)
    ArrayList<Pogrzeb> pogrzeby;
    @ForeignKey(name="fk_Zmarly_Akt", deleteAction = ForeignKeyAction.CASCADE, updateAction=ForeignKeyAction.RESTRICT)
    AktZgonu aktZgonu;

    public Zmarly(String nazwiskoPanien, Date dataUrodzenia, Date dataZgonu,ArrayList<Pogrzeb> pogrzeby, AktZgonu aktZgonu, String imie, String drugieImie, String nazwisko, String drugieNazwisko, String pesel, String email, String telefon) {
        super(imie, drugieImie, nazwisko, drugieNazwisko, pesel, email, telefon);
        this.nazwiskoPanien = nazwiskoPanien;
        this.dataUrodzenia = dataUrodzenia;
        this.dataZgonu = dataZgonu;
        this.pesel = pesel;
        this.pogrzeby = pogrzeby;
        this.aktZgonu = aktZgonu;
    }
        
    public String getNazwiskoPanien() {
        return nazwiskoPanien;
    }

    public void setNazwiskoPanien(String nazwiskoPanien) {
        this.nazwiskoPanien = nazwiskoPanien;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUr) {
        if(dataUr.before(this.dataZgonu))
        {
            this.dataUrodzenia = dataUr;
        }
        else 
        {
            System.out.println("Nie mozna urodzic sie po smierci");
        }
        
        
    }

    public Date getDataZgonu() {
        return dataZgonu;
    }

    public void setDataZgonu(Date dataZg) {
        if(dataZg.after(this.dataUrodzenia))
        {
            this.dataZgonu = dataZg;
        }
        else 
        {
            System.out.println("Nie mozna umrzec przed narodzinami");
        }
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public ArrayList<Pogrzeb> getPogrzeby() {
        return pogrzeby;
    }

    public void setPogrzeby(ArrayList<Pogrzeb> pogrzeby) {
        this.pogrzeby = pogrzeby;
    }

    public AktZgonu getAktZgonu() {
        return aktZgonu;
    }

    public void setAktZgonu(AktZgonu aktZgonu) {
       if(aktZgonu.getDataWyst().after(this.dataZgonu))
        {
            this.aktZgonu = aktZgonu;
        }
        else 
        {
            System.out.println("Nie wlasciwa data");
        }
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getDrugieImie() {
        return drugieImie;
    }

    public void setDrugieImie(String drugieImie) {
        this.drugieImie = drugieImie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getDrugieNazwisko() {
        return drugieNazwisko;
    }

    public void setDrugieNazwisko(String drugieNazwisko) {
        this.drugieNazwisko = drugieNazwisko;
    }

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
 
    //sunday-metoda - sprawdza czy dany Zmarły w wierszu jest kobietą
    public boolean isWoman(){ 
        if(this.imie.substring(this.imie.length()-1).equals("a")) return true;
        else return false;
    }
 
 
}
