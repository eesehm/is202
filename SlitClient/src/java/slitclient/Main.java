    
package slitclient;

import Data.BrukerData;
import javafx.application.Application;
import slitclient.manager.BrukerManager;
import slitclient.view.SlitInterfaceMainController;


public class Main {

     public static void main(String[] args) {
      Application.launch(SlitInterfaceMainController.class, args);
      /*
      BrukerManager bm = new BrukerManager();
      
      BrukerData bruker = bm.getBruker(1);
     
       System.out.println(bruker.getID());
       System.out.println(bruker.getFornavn());
       System.out.println(bruker.getEtternavn());
     
       
      /*BrukerData dataBruker = new BrukerData();
      
      dataBruker.setID(7);
      dataBruker.setEpost("edvin888@hotmail.com");
      dataBruker.setFornavn("Edvin");
      dataBruker.setEtternavn("Sehm");
      dataBruker.setPassword("root");
      
      
      bm.storeBruker(dataBruker);
    }
    */
     }
}
