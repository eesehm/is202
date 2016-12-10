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
public class BeskjedData implements java.io.Serializable {
    
    
    private int beskjed_id;
    
    private String beskjed_melding;
    
    private Date beskjed_date;

    public int getBeskjed_id() {
        return beskjed_id;
    }

    public void setBeskjed_id(int beskjed_id) {
        this.beskjed_id = beskjed_id;
    }

    public String getBeskjed_melding() {
        return beskjed_melding;
    }

    public void setBeskjed_melding(String beskjed_melding) {
        this.beskjed_melding = beskjed_melding;
    }

    public Date getBeskjed_date() {
        return beskjed_date;
    }

    public void setBeskjed_date(Date beskjed_date) {
        this.beskjed_date = beskjed_date;
    }
    
    
}
