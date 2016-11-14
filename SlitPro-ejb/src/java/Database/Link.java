/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edvin
 */
@Entity
@Table(name = "link")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Link.findAll", query = "SELECT l FROM Link l"),
    @NamedQuery(name = "Link.findByLinkId", query = "SELECT l FROM Link l WHERE l.linkId = :linkId"),
    @NamedQuery(name = "Link.findByBeskrivelse", query = "SELECT l FROM Link l WHERE l.beskrivelse = :beskrivelse"),
    @NamedQuery(name = "Link.findByRessurser", query = "SELECT l FROM Link l WHERE l.ressurser = :ressurser")})
public class Link implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "link_id")
    private Integer linkId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "beskrivelse")
    private String beskrivelse;
    @Size(max = 50)
    @Column(name = "ressurser")
    private String ressurser;
    @OneToMany(mappedBy = "linkId")
    private List<Modul> modulList;

    public Link() {
    }

    public Link(Integer linkId) {
        this.linkId = linkId;
    }

    public Link(Integer linkId, String beskrivelse) {
        this.linkId = linkId;
        this.beskrivelse = beskrivelse;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public String getRessurser() {
        return ressurser;
    }

    public void setRessurser(String ressurser) {
        this.ressurser = ressurser;
    }

    @XmlTransient
    public List<Modul> getModulList() {
        return modulList;
    }

    public void setModulList(List<Modul> modulList) {
        this.modulList = modulList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (linkId != null ? linkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Link)) {
            return false;
        }
        Link other = (Link) object;
        if ((this.linkId == null && other.linkId != null) || (this.linkId != null && !this.linkId.equals(other.linkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Link[ linkId=" + linkId + " ]";
    }
    
}
