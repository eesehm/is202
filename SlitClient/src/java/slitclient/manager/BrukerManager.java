
package slitclient.manager;

import Data.BrukerData;
import Server.BrukerSessionBeanRemote;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TableView;
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
    
    private static BrukerData bruker; 
    
    public static int getLoggedInUserId() 
    {
        return bruker.getID(); 
    }
    
    public static String getUserFirstName() 
        {
            return bruker.getFornavn();
        }
    
    public static BrukerData getLoggedInUser() 
    {
        return bruker; 
    }
    
   
    public BrukerData getBruker(int id) {
        return this.lookupBrukerSessionBeanRemote().getBruker(id);
    }
    public String getBrukerNavnFromId(int id) {
        return this.lookupBrukerSessionBeanRemote().getBrukerNavnFromId(id);
    }
    
    public List<BrukerData> getBrukere() {
        return this.lookupBrukerSessionBeanRemote().getBrukere();
    }
    
    public boolean storeBruker(BrukerData dataBruker) {
        
        return this.lookupBrukerSessionBeanRemote().storeBruker(dataBruker);
    }
    
    public BrukerData logInnBruker(String epost, String password) {
        
        BrukerData loggedInBruker = this.lookupBrukerSessionBeanRemote().logInnBruker(epost, password);
        
        bruker = loggedInBruker; 
        
      //  Authenticator.setBruker(bruker);
        
        return loggedInBruker; 
        
       //return this.lookupBrukerSessionBeanRemote().logInnBruker(epost, password);
    }
 
    public BrukerData deleteBruker(int brukerId){
        return this.lookupBrukerSessionBeanRemote().deleteBruker(brukerId);
    }
    public BrukerData deleteBrukere() {
        return this.lookupBrukerSessionBeanRemote().deleteBrukere();
    }
  
}
