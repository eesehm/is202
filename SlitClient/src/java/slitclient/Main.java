    
package slitclient;

import Data.BrukerData;
import javafx.application.Application;
import slitclient.manager.BrukerManager;
import slitclient.view.SlitInterfaceMainController;


public class Main {

     public static void main(String[] args) {
      Application.launch(SlitInterfaceMainController.class, args);
      
      BrukerManager bm = new BrukerManager();
  
      BrukerData bruker = bm.getBruker(1);
      /*
       System.out.println(bruker.getID());
       System.out.println(bruker.getFornavn());
       System.out.println(bruker.getEtternavn());
     
       
      BrukerData dataBruker = new BrukerData();
      
      dataBruker.setID(2);
      dataBruker.setEpost("Borgny@hgmail");
      dataBruker.setFornavn("Borgny");
      dataBruker.setEtternavn("Hansen");
      dataBruker.setPassword("root");
      
      dataBruker.setID(3);
      dataBruker.setEpost("Nils@hgmail");
      dataBruker.setFornavn("Nils");
      dataBruker.setEtternavn("Toresen");
      dataBruker.setPassword("root");
      
      dataBruker.setID(4);
      dataBruker.setEpost("Per@hgmail");
      dataBruker.setFornavn("Per");
      dataBruker.setEtternavn("Jotunheim");
      dataBruker.setPassword("root");
      bm.storeBruker(dataBruker);
    
    */
     }

}
