/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edvin
 */
@Entity
@Table(name = "besvarelse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Besvarelse.findAll", query = "SELECT b FROM Besvarelse b"),
    @NamedQuery(name = "Besvarelse.findByBesvarelseID", query = "SELECT b FROM Besvarelse b WHERE b.besvarelseID = :besvarelseID"),
    @NamedQuery(name = "Besvarelse.findByModulNummer", query = "SELECT b FROM Besvarelse b WHERE b.modulNummer = :modulNummer"),
    @NamedQuery(name = "Besvarelse.findByOpplastetFil", query = "SELECT b FROM Besvarelse b WHERE b.opplastetFil = :opplastetFil"),
    @NamedQuery(name = "Besvarelse.findByKommentar", query = "SELECT b FROM Besvarelse b WHERE b.kommentar = :kommentar"),
    @NamedQuery(name = "Besvarelse.findByVurderingsvarsel", query = "SELECT b FROM Besvarelse b WHERE b.vurderingsvarsel = :vurderingsvarsel"),
    @NamedQuery(name = "Besvarelse.modulEn", query = "SELECT b FROM Besvarelse b WHERE b.modulNummer = 1"),
    @NamedQuery(name = "Besvarelse.modulTo", query = "SELECT b FROM Besvarelse b WHERE b.modulNummer = 2"),
    @NamedQuery(name = "Besvarelse.findByDato", query = "SELECT b FROM Besvarelse b WHERE b.dato = :dato")})
public class Besvarelse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "besvarelse_ID")
    private Integer besvarelseID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modul_nummer")
    private int modulNummer;
    @Column(name = "opplastet_fil")
    private Boolean opplastetFil;
    @Size(max = 120)
    @Column(name = "kommentar")
    private String kommentar;
    @Column(name = "vurderingsvarsel")
    private Boolean vurderingsvarsel;
    @Column(name = "dato")
    @Temporal(TemporalType.DATE)
    private Date dato;
    @ManyToMany(mappedBy = "besvarelseList")
    private List<Student> studentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "besvarelse")
    private List<Vurdering> vurderingList;

    public Besvarelse() {
    }

    public Besvarelse(Integer besvarelseID) {
        this.besvarelseID = besvarelseID;
    }

    public Besvarelse(Integer besvarelseID, int modulNummer) {
        this.besvarelseID = besvarelseID;
        this.modulNummer = modulNummer;
    }

    public Integer getBesvarelseID() {
        return besvarelseID;
    }

    public void setBesvarelseID(Integer besvarelseID) {
        this.besvarelseID = besvarelseID;
    }

    public int getModulNummer() {
        return modulNummer;
    }

    public void setModulNummer(int modulNummer) {
        this.modulNummer = modulNummer;
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

    @XmlTransient
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @XmlTransient
    public List<Vurdering> getVurderingList() {
        return vurderingList;
    }

    public void setVurderingList(List<Vurdering> vurderingList) {
        this.vurderingList = vurderingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (besvarelseID != null ? besvarelseID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Besvarelse)) {
            return false;
        }
        Besvarelse other = (Besvarelse) object;
        if ((this.besvarelseID == null && other.besvarelseID != null) || (this.besvarelseID != null && !this.besvarelseID.equals(other.besvarelseID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Besvarelse[ besvarelseID=" + besvarelseID + " ]";
    }
    
}
