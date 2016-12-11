
package Database;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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


@Entity
@Table(name = "bruker")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bruker.findAll", query = "SELECT b FROM Bruker b"),
    @NamedQuery(name = "Bruker.findById", query = "SELECT b FROM Bruker b WHERE b.id = :id"),
    @NamedQuery(name = "Bruker.findByFornavn", query = "SELECT b FROM Bruker b WHERE b.fornavn = :fornavn"),
    @NamedQuery(name = "Bruker.findByEtternavn", query = "SELECT b FROM Bruker b WHERE b.etternavn = :etternavn"),
    @NamedQuery(name = "Bruker.findByEpost", query = "SELECT b FROM Bruker b WHERE b.epost = :epost"),
    @NamedQuery(name = "Bruker.findByPassword", query = "SELECT b FROM Bruker b WHERE b.password = :password"),
    @NamedQuery(name = "Bruker.deleteAll", query = "DELETE FROM Bruker b WHERE b.id >= 0"),
    @NamedQuery(name = "Bruker.login", query = "SELECT b FROM Bruker b WHERE b.epost = :epost AND b.password = :password"), //brukes for å logge inn brukere
    @NamedQuery(name = "Bruker.delete", query = "DELETE FROM Bruker b WHERE b.id = :id ")}) //slette bruker

public class Bruker implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "fornavn")
    private String fornavn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "etternavn")
    private String etternavn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "epost")
    private String epost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<Foreleser> foreleserList;

    public Bruker() {
    }

    public Bruker(Integer id) {
        this.id = id;
    }

    public Bruker(Integer id, String fornavn, String etternavn, String epost, String password) {
        this.id = id;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.epost = epost;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<Foreleser> getForeleserList() {
        return foreleserList;
    }

    public void setForeleserList(List<Foreleser> foreleserList) {
        this.foreleserList = foreleserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bruker)) {
            return false;
        }
        Bruker other = (Bruker) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Bruker[ id=" + id + " ]";
    }
    
}
