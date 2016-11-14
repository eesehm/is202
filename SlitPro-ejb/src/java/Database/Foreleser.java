/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "foreleser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Foreleser.findAll", query = "SELECT f FROM Foreleser f"),
    @NamedQuery(name = "Foreleser.findByAnsattID", query = "SELECT f FROM Foreleser f WHERE f.ansattID = :ansattID"),
    @NamedQuery(name = "Foreleser.findByModuler", query = "SELECT f FROM Foreleser f WHERE f.moduler = :moduler"),
    @NamedQuery(name = "Foreleser.findByTilganger", query = "SELECT f FROM Foreleser f WHERE f.tilganger = :tilganger"),
    @NamedQuery(name = "Foreleser.findByVarslinger", query = "SELECT f FROM Foreleser f WHERE f.varslinger = :varslinger")})
public class Foreleser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ansattID")
    private Integer ansattID;
    @Size(max = 50)
    @Column(name = "moduler")
    private String moduler;
    @Column(name = "tilganger")
    private Boolean tilganger;
    @Size(max = 30)
    @Column(name = "varslinger")
    private String varslinger;
    @JoinColumn(name = "ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Bruker id;

    public Foreleser() {
    }

    public Foreleser(Integer ansattID) {
        this.ansattID = ansattID;
    }

    public Integer getAnsattID() {
        return ansattID;
    }

    public void setAnsattID(Integer ansattID) {
        this.ansattID = ansattID;
    }

    public String getModuler() {
        return moduler;
    }

    public void setModuler(String moduler) {
        this.moduler = moduler;
    }

    public Boolean getTilganger() {
        return tilganger;
    }

    public void setTilganger(Boolean tilganger) {
        this.tilganger = tilganger;
    }

    public String getVarslinger() {
        return varslinger;
    }

    public void setVarslinger(String varslinger) {
        this.varslinger = varslinger;
    }

    public Bruker getId() {
        return id;
    }

    public void setId(Bruker id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ansattID != null ? ansattID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Foreleser)) {
            return false;
        }
        Foreleser other = (Foreleser) object;
        if ((this.ansattID == null && other.ansattID != null) || (this.ansattID != null && !this.ansattID.equals(other.ansattID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Foreleser[ ansattID=" + ansattID + " ]";
    }
    
}
