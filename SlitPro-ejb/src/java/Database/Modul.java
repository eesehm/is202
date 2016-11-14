/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edvin
 */
@Entity
@Table(name = "modul")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modul.findAll", query = "SELECT m FROM Modul m"),
    @NamedQuery(name = "Modul.findByModulNummer", query = "SELECT m FROM Modul m WHERE m.modulNummer = :modulNummer"),
    @NamedQuery(name = "Modul.findByLagdAv", query = "SELECT m FROM Modul m WHERE m.lagdAv = :lagdAv"),
    @NamedQuery(name = "Modul.findByFrist", query = "SELECT m FROM Modul m WHERE m.frist = :frist"),
    @NamedQuery(name = "Modul.findByVarsel", query = "SELECT m FROM Modul m WHERE m.varsel = :varsel"),
    @NamedQuery(name = "Modul.findByInnhold", query = "SELECT m FROM Modul m WHERE m.innhold = :innhold")})
public class Modul implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "modul_nummer")
    private Integer modulNummer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "lagd_av")
    private String lagdAv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "frist")
    @Temporal(TemporalType.DATE)
    private Date frist;
    @Column(name = "varsel")
    private Boolean varsel;
    @Size(max = 120)
    @Column(name = "innhold")
    private String innhold;
    @JoinColumn(name = "link_id", referencedColumnName = "link_id")
    @ManyToOne
    private Link linkId;

    public Modul() {
    }

    public Modul(Integer modulNummer) {
        this.modulNummer = modulNummer;
    }

    public Modul(Integer modulNummer, String lagdAv, Date frist) {
        this.modulNummer = modulNummer;
        this.lagdAv = lagdAv;
        this.frist = frist;
    }

    public Integer getModulNummer() {
        return modulNummer;
    }

    public void setModulNummer(Integer modulNummer) {
        this.modulNummer = modulNummer;
    }

    public String getLagdAv() {
        return lagdAv;
    }

    public void setLagdAv(String lagdAv) {
        this.lagdAv = lagdAv;
    }

    public Date getFrist() {
        return frist;
    }

    public void setFrist(Date frist) {
        this.frist = frist;
    }

    public Boolean getVarsel() {
        return varsel;
    }

    public void setVarsel(Boolean varsel) {
        this.varsel = varsel;
    }

    public String getInnhold() {
        return innhold;
    }

    public void setInnhold(String innhold) {
        this.innhold = innhold;
    }

    public Link getLinkId() {
        return linkId;
    }

    public void setLinkId(Link linkId) {
        this.linkId = linkId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modulNummer != null ? modulNummer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modul)) {
            return false;
        }
        Modul other = (Modul) object;
        if ((this.modulNummer == null && other.modulNummer != null) || (this.modulNummer != null && !this.modulNummer.equals(other.modulNummer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Modul[ modulNummer=" + modulNummer + " ]";
    }
    
}
