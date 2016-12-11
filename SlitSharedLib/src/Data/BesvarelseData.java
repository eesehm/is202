/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.Date;

/**
 *
 * @author Edvin
 */
public class BesvarelseData implements java.io.Serializable{
    
    private int besvarelseID;
    
    private int modulnummer;
    
    private Boolean opplastetFil;
    
    private String kommentar;
    
    private Boolean vurderingsvarsel;
    
    private Date dato;

    public int getBesvarelseID() {
        return besvarelseID;
    }

    public void setBesvarelseID(int besvarelseID) {
        this.besvarelseID = besvarelseID;
    }

    public int getModulnummer() {
        return modulnummer;
    }

    public void setModulnummer(int modulnummer) {
        this.modulnummer = modulnummer;
    }

    public Boolean getOpplastetFil() {
        return opplastetFil;
    }

    public void setOpplastetFil(Boolean opplastetFil) {
        this.opplastetFil = opplastetFil;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public Boolean getVurderingsvarsel() {
        return vurderingsvarsel;
    }

    public void setVurderingsvarsel(Boolean vurderingsvarsel) {
        this.vurderingsvarsel = vurderingsvarsel;
    }

    public Date getDato() {
        return dato;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }
    
    
    
}
