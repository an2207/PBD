/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datanucleus.samples.jdo.tutorial;

import java.sql.Time;
import java.util.Date;
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
public class Pogrzeb {

    @PrimaryKey @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
    int pogrzebId;
    Date dzienPogrzebu;
    Time godzPogrzebu;
    @ForeignKey(name="fk_Pogrzeb_Zaklad", deleteAction = ForeignKeyAction.CASCADE, updateAction=ForeignKeyAction.RESTRICT)
    @Column(name="OSOBAID")
    ZakladPogrzebowy zaklad;
    
    public Date getDzienPogrzebu() {
        return dzienPogrzebu;
    }

    public void setDzienPogrzebu(Date dzienPogrzebu) {
        this.dzienPogrzebu = dzienPogrzebu;
    }

    public Time getGodzPogrzebu() {
        return godzPogrzebu;
    }

    public void setGodzPogrzebu(Time godzPogrzebu) {
        this.godzPogrzebu = godzPogrzebu;
    }

    public ZakladPogrzebowy getZaklad() {
        return zaklad;
    }

    public void setZaklad(ZakladPogrzebowy zaklad) {
        this.zaklad = zaklad;
    }

    public Pogrzeb(Date dzienPogrzebu, Time godzPogrzebu, ZakladPogrzebowy zaklad) {
        this.dzienPogrzebu = dzienPogrzebu;
        this.godzPogrzebu = godzPogrzebu;
        this.zaklad = zaklad;
    }

}

