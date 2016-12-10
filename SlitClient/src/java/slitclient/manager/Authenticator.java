
package slitclient.manager;

import Data.BrukerData;


public class Authenticator {
    
   
    private static BrukerData bruker; 

    public static BrukerData getBruker() {
       
       
        return bruker;
        
    }

    public static void setBruker(BrukerData bruker) {
        Authenticator.bruker = bruker;
    }
        
        
    
}
