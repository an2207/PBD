/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datanucleus.samples.jdo.tutorial;

import java.util.ArrayList;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 *
 * @author Anna Hnatkowska
 */

@PersistenceCapable
public class RodzajKwatery {

    @PrimaryKey @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
    int rodzajId;
    String nazwa;
    ArrayList<Cennik> cenniki;
    
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public ArrayList<Cennik> getCenniki() {
        return cenniki;
    }

    public void setCenniki(ArrayList<Cennik> cenniki) {
        this.cenniki = cenniki;
    }

    
    public RodzajKwatery()
    {
    
    }
    public RodzajKwatery(String nazwa) {
        this.nazwa = nazwa;
    }

    public RodzajKwatery(String nazwa, ArrayList<Cennik> cenniki) {
        this.nazwa = nazwa;
        this.cenniki = cenniki;
    }
    
    public void addCennik(Cennik c){
        cenniki.add(c);
    }

}

