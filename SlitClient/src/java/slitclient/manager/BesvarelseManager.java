/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient.manager;

import Data.BesvarelseData;
import Server.BesvarelseSessionBeanRemote;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class BesvarelseManager {

    private BesvarelseSessionBeanRemote lookupBesvarelseSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            return (BesvarelseSessionBeanRemote) c.lookup("java:comp/env/BesvarelseSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
        public List<BesvarelseData> getBesvarelser() {
            return this.lookupBesvarelseSessionBeanRemote().getBesvarelser();
        }
        public List<BesvarelseData> getBesvarelser2() {
            return this.lookupBesvarelseSessionBeanRemote().getBesvarelser2();
        }
    
    
}
