
package slitclient.manager;

import Data.BrukerData;
import Server.BrukerSessionBeanRemote;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class BrukerManager {

    private BrukerSessionBeanRemote lookupBrukerSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            return (BrukerSessionBeanRemote) c.lookup("java:comp/env/BrukerSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
   
    public BrukerData getBruker(int id) {
        return this.lookupBrukerSessionBeanRemote().getBruker(id);
    }
    
    public List<BrukerData> getUsers() {
        return this.lookupBrukerSessionBeanRemote().getAllUsers();
    }
    
    public boolean storeBruker(BrukerData dataBruker) {
        
        return this.lookupBrukerSessionBeanRemote().storeBruker(dataBruker);
    }
}
