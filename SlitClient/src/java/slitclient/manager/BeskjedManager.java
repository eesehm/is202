/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient.manager;

import Data.BeskjedData;
import Server.BeskjedSessionBeanRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class BeskjedManager {

    private BeskjedSessionBeanRemote lookupBeskjedSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            return (BeskjedSessionBeanRemote) c.lookup("java:comp/env/BeskjedSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    public boolean storeBeskjed(BeskjedData beskjedEn) {
        return this.lookupBeskjedSessionBeanRemote().storeBeskjed(beskjedEn);
    }
     public String getBeskjedFromId(int beskjedId) {
         return this.lookupBeskjedSessionBeanRemote().getBeskjedFromId(beskjedId);
     }
     public BeskjedData deleteBeskjed() {
         return this.lookupBeskjedSessionBeanRemote().deleteBeskjed();
     }
}
