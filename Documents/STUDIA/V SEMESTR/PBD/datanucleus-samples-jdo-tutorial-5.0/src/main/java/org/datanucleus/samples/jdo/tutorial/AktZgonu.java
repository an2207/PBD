/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datanucleus.samples.jdo.tutorial;

import java.sql.Time;
import java.util.Date;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

/**
 *
 * @author Anna Hnatkowska
 */
@PersistenceCapable
public class AktZgonu   {

    @PrimaryKey
    @Column(jdbcType="VARCHAR", length=64)
    String nrAktu;
    Date dataWyst;
    Time godzZgonu;
    @Column(jdbcType="VARCHAR", length=64)
    String imieOjca;
    @Column(jdbcType="VARCHAR", length=64)
    String nazwOjca;
    @Column(jdbcType="VARCHAR", length=64)
    String imieMatki;
    @Column(jdbcType="VARCHAR", length=64)
    String nazwMatki;
    
    public String getNrAktu() {
        return nrAktu;
    }

    public void setNrAktu(String nrAktu) {
        this.nrAktu = nrAktu;
    }

    public Date getDataWyst() {
        return dataWyst;
    }

    public void setDataWyst(Date dataWyst) {
        this.dataWyst = dataWyst;
    }

    public Time getGodzZgonu() {
        return godzZgonu;
    }

    public void setGodzZgonu(Time godzZgonu) {
        this.godzZgonu = godzZgonu;
    }

    public String getImieOjca() {
        return imieOjca;
    }

    public void setImieOjca(String imieOjca) {
        this.imieOjca = imieOjca;
    }

    public String getNazwOjca() {
        return nazwOjca;
    }

    public void setNazwOjca(String nazwOjca) {
        this.nazwOjca = nazwOjca;
    }

    public String getImieMatki() {
        return imieMatki;
    }

    public void setImieMatki(String imieMatki) {
        this.imieMatki = imieMatki;
    }

    public String getNazwMatki() {
        return nazwMatki;
    }

    public void setNazwMatki(String nazwMatki) {
        this.nazwMatki = nazwMatki;
    }

    public AktZgonu(String nrAktu, Date dataWyst, Time godzZgonu, String imieOjca, String nazwOjca, String imieMatki, String nazwMatki) {
        this.nrAktu = nrAktu;
        this.dataWyst = dataWyst;
        this.godzZgonu = godzZgonu;
        this.imieOjca = imieOjca;
        this.nazwOjca = nazwOjca;
        this.imieMatki = imieMatki;
        this.nazwMatki = nazwMatki;
    }

}
