/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentID", query = "SELECT s FROM Student s WHERE s.studentID = :studentID"),
    @NamedQuery(name = "Student.findByInnleveringer", query = "SELECT s FROM Student s WHERE s.innleveringer = :innleveringer"),
    @NamedQuery(name = "Student.findByVarslinger", query = "SELECT s FROM Student s WHERE s.varslinger = :varslinger")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "student_ID")
    private Integer studentID;
    @Size(max = 30)
    @Column(name = "innleveringer")
    private String innleveringer;
    @Size(max = 30)
    @Column(name = "varslinger")
    private String varslinger;
    @JoinTable(name = "innlevering", joinColumns = {
        @JoinColumn(name = "student_ID", referencedColumnName = "student_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "besvarelse_ID", referencedColumnName = "besvarelse_ID")})
    @ManyToMany
    private List<Besvarelse> besvarelseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Vurdering> vurderingList;

    public Student() {
    }

    public Student(Integer studentID) {
        this.studentID = studentID;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getInnleveringer() {
        return innleveringer;
    }

    public void setInnleveringer(String innleveringer) {
        this.innleveringer = innleveringer;
    }

    public String getVarslinger() {
        return varslinger;
    }

    public void setVarslinger(String varslinger) {
        this.varslinger = varslinger;
    }

    @XmlTransient
    public List<Besvarelse> getBesvarelseList() {
        return besvarelseList;
    }

    public void setBesvarelseList(List<Besvarelse> besvarelseList) {
        this.besvarelseList = besvarelseList;
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
        hash += (studentID != null ? studentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentID == null && other.studentID != null) || (this.studentID != null && !this.studentID.equals(other.studentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Student[ studentID=" + studentID + " ]";
    }
    
}
