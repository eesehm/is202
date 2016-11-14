/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edvin
 */
@Entity
@Table(name = "vurdering")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vurdering.findAll", query = "SELECT v FROM Vurdering v"),
    @NamedQuery(name = "Vurdering.findByBesvarelseID", query = "SELECT v FROM Vurdering v WHERE v.vurderingPK.besvarelseID = :besvarelseID"),
    @NamedQuery(name = "Vurdering.findByStudentID", query = "SELECT v FROM Vurdering v WHERE v.vurderingPK.studentID = :studentID"),
    @NamedQuery(name = "Vurdering.findByVurdertAv", query = "SELECT v FROM Vurdering v WHERE v.vurdertAv = :vurdertAv"),
    @NamedQuery(name = "Vurdering.findByKarakter", query = "SELECT v FROM Vurdering v WHERE v.karakter = :karakter"),
    @NamedQuery(name = "Vurdering.findByKommentar", query = "SELECT v FROM Vurdering v WHERE v.kommentar = :kommentar")})
public class Vurdering implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VurderingPK vurderingPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "vurdert_av")
    private String vurdertAv;
    @Size(max = 2)
    @Column(name = "karakter")
    private String karakter;
    @Size(max = 120)
    @Column(name = "kommentar")
    private String kommentar;
    @JoinColumn(name = "student_ID", referencedColumnName = "student_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;
    @JoinColumn(name = "besvarelse_ID", referencedColumnName = "besvarelse_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Besvarelse besvarelse;

    public Vurdering() {
    }

    public Vurdering(VurderingPK vurderingPK) {
        this.vurderingPK = vurderingPK;
    }

    public Vurdering(VurderingPK vurderingPK, String vurdertAv) {
        this.vurderingPK = vurderingPK;
        this.vurdertAv = vurdertAv;
    }

    public Vurdering(int besvarelseID, int studentID) {
        this.vurderingPK = new VurderingPK(besvarelseID, studentID);
    }

    public VurderingPK getVurderingPK() {
        return vurderingPK;
    }

    public void setVurderingPK(VurderingPK vurderingPK) {
        this.vurderingPK = vurderingPK;
    }

    public String getVurdertAv() {
        return vurdertAv;
    }

    public void setVurdertAv(String vurdertAv) {
        this.vurdertAv = vurdertAv;
    }

    public String getKarakter() {
        return karakter;
    }

    public void setKarakter(String karakter) {
        this.karakter = karakter;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Besvarelse getBesvarelse() {
        return besvarelse;
    }

    public void setBesvarelse(Besvarelse besvarelse) {
        this.besvarelse = besvarelse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vurderingPK != null ? vurderingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vurdering)) {
            return false;
        }
        Vurdering other = (Vurdering) object;
        if ((this.vurderingPK == null && other.vurderingPK != null) || (this.vurderingPK != null && !this.vurderingPK.equals(other.vurderingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Vurdering[ vurderingPK=" + vurderingPK + " ]";
    }
    
}
