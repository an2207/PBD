/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datanucleus.samples.jdo.tutorial;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Unique;

/**
 *
 * @author Anna Hnatkowska
 */
@PersistenceCapable
public class OsobaFizyczna extends Osoba{
  
    @Column(jdbcType="VARCHAR", length=64)
    String imie;
    @Column(jdbcType = "VARCHAR", length = 64,allowsNull = "true")
    String drugieImie;
    @Column(jdbcType="VARCHAR", length=64)
    String nazwisko;
    @Column(jdbcType = "VARCHAR", length = 64,allowsNull = "true")
    String drugieNazwisko;
    @Column(jdbcType="VARCHAR", length=11)
    @Unique
    String pesel;
    
    
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        if(pesel.matches("\\d{11}"))
        {
            this.pesel = pesel;
        }
        else 
        {
            System.out.println("Zly pesel");
        }
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

    public OsobaFizyczna(String imie, String drugieImie, String nazwisko, String drugieNazwisko, String pesel, String email) {
        super(email);
        this.imie = imie;
        this.drugieImie = drugieImie;
        this.nazwisko = nazwisko;
        this.drugieNazwisko = drugieNazwisko;
        this.pesel = pesel;
    }

    public OsobaFizyczna(String imie, String drugieImie, String nazwisko, String drugieNazwisko, String pesel, String email, String telefon) {
        super(email, telefon);
        this.imie = imie;
        this.drugieImie = drugieImie;
        this.nazwisko = nazwisko;
        this.drugieNazwisko = drugieNazwisko;
        this.pesel = pesel;
    }

    public OsobaFizyczna(String imie, String drugieImie, String nazwisko, String drugieNazwisko, String pesel) {
        this.imie = imie;
        this.drugieImie = drugieImie;
        this.nazwisko = nazwisko;
        this.drugieNazwisko = drugieNazwisko;
        this.pesel = pesel;
    }

    
}

