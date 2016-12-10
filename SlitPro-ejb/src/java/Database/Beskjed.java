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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "beskjed")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Beskjed.findAll", query = "SELECT b FROM Beskjed b"),
    @NamedQuery(name = "Beskjed.findByBeskjedMelding", query = "SELECT b FROM Beskjed b WHERE b.beskjedMelding = :beskjedMelding"),
    @NamedQuery(name = "Beskjed.findByBeskjedDato", query = "SELECT b FROM Beskjed b WHERE b.beskjedDato = :beskjedDato"),
    @NamedQuery(name = "Beskjed.delete", query = "DELETE FROM Beskjed b WHERE b.beskjedId > 1"),
   
    @NamedQuery(name = "Beskjed.findByBeskjedId", query = "SELECT b FROM Beskjed b WHERE b.beskjedId = :beskjedId")})
public class Beskjed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "beskjed_melding")
    private String beskjedMelding;
    @Column(name = "beskjed_dato")
    @Temporal(TemporalType.DATE)
    private Date beskjedDato;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "beskjed_id")
    private Integer beskjedId;

    public Beskjed() {
    }

    public Beskjed(Integer beskjedId) {
        this.beskjedId = beskjedId;
    }

    public Beskjed(Integer beskjedId, String beskjedMelding) {
        this.beskjedId = beskjedId;
        this.beskjedMelding = beskjedMelding;
    }

    public String getBeskjedMelding() {
        return beskjedMelding;
    }

    public void setBeskjedMelding(String beskjedMelding) {
        this.beskjedMelding = beskjedMelding;
    }

    public Date getBeskjedDato() {
        return beskjedDato;
    }

    public void setBeskjedDato(Date beskjedDato) {
        this.beskjedDato = beskjedDato;
    }

    public Integer getBeskjedId() {
        return beskjedId;
    }

    public void setBeskjedId(Integer beskjedId) {
        this.beskjedId = beskjedId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (beskjedId != null ? beskjedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beskjed)) {
            return false;
        }
        Beskjed other = (Beskjed) object;
        if ((this.beskjedId == null && other.beskjedId != null) || (this.beskjedId != null && !this.beskjedId.equals(other.beskjedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Beskjed[ beskjedId=" + beskjedId + " ]";
    }
    
}
