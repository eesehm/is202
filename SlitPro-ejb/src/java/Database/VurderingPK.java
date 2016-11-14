/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Edvin
 */
@Embeddable
public class VurderingPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "besvarelse_ID")
    private int besvarelseID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "student_ID")
    private int studentID;

    public VurderingPK() {
    }

    public VurderingPK(int besvarelseID, int studentID) {
        this.besvarelseID = besvarelseID;
        this.studentID = studentID;
    }

    public int getBesvarelseID() {
        return besvarelseID;
    }

    public void setBesvarelseID(int besvarelseID) {
        this.besvarelseID = besvarelseID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) besvarelseID;
        hash += (int) studentID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VurderingPK)) {
            return false;
        }
        VurderingPK other = (VurderingPK) object;
        if (this.besvarelseID != other.besvarelseID) {
            return false;
        }
        if (this.studentID != other.studentID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.VurderingPK[ besvarelseID=" + besvarelseID + ", studentID=" + studentID + " ]";
    }
    
}
