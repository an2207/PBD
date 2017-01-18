/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datanucleus.samples.jdo.tutorial;

import javax.jdo.annotations.PersistenceCapable;

/**
 *
 * @author Anna Hnatkowska
 */

@PersistenceCapable
public class ZakladPogrzebowy extends OsobaPrawna{
    
    String osobaKontImie;
    String osobaKontNazw;

    public ZakladPogrzebowy(String nip, String nazwa, String email, String telefon) {
        super(nip, nazwa, email, telefon);
    }
    
        public ZakladPogrzebowy() {
        super();
    }

    public String getOsobaKontImie() {
        return osobaKontImie;
    }

    public void setOsobaKontImie(String osobaKontImie) {
        this.osobaKontImie = osobaKontImie;
    }

    public String getOsobaKontNazw() {
        return osobaKontNazw;
    }

    public void setOsobaKontNazw(String osobaKontNazw) {
        this.osobaKontNazw = osobaKontNazw;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
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


}
