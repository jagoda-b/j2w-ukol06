package cz.czechitas.java2webapps.ukol6.entity;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Entita obsahující údaje zobrazené na vizitce.
 */
@Entity
public class Vizitka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cele_jmeno", length = 100)
    private String jmeno;
    @Column(length = 100)
    private String firma;
    @Column(length = 100)
    private String ulice;
    @Column(length = 100)
    private String obec;
    @Column(length = 5)
    private String psc;
    @Column(length = 100)
    private String email;
    @Column(length = 100)
    private String telefon;
    @Column(length = 100)
    private String web;

    public Vizitka() {
    }

    public Vizitka(String jmeno, String firma, String ulice, String obec, String psc, String email, String telefon, String web) {
        this.jmeno = Objects.requireNonNull(jmeno);
        this.firma = Objects.requireNonNull(firma);
        this.ulice = Objects.requireNonNull(ulice);
        this.obec = Objects.requireNonNull(obec);
        this.psc = Objects.requireNonNull(psc);
        this.email = email;
        this.telefon = telefon;
        this.web = web;
    }

    public Integer getId() {
        return id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = Objects.requireNonNull(jmeno);
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = Objects.requireNonNull(firma);
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = Objects.requireNonNull(ulice);
    }

    public String getObec() {
        return obec;
    }

    public void setObec(String obec) {
        this.obec = obec;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = Objects.requireNonNull(psc);
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

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getCelaAdresa() {
        return ulice + ", " + psc;
    }
}
