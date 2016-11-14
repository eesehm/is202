
package slitclient;


import Data.BrukerData;
import Server.BrukerSessionBeanRemote;
import java.util.List;
import javafx.application.Application;
import javax.ejb.EJB;
import slitclient.manager.BrukerManager;
import slitclient.view.SlitInterface;


public class Main {

     public static void main(String[] args) {
      Application.launch(SlitInterface.class, args);
      BrukerManager bm = new BrukerManager();
      
      BrukerData bruker = bm.getBruker(1);
     
       System.out.println(bruker.getID());
       System.out.println(bruker.getFornavn());
       System.out.println(bruker.getEtternavn());
     
       System.out.println();
    
     List<BrukerData> brukere = bm.getUsers();
      for(BrukerData bd : brukere) {
          System.out.println(bd.getID());
          System.out.println(bd.getFornavn());
      }
      
      BrukerData dataBruker = new BrukerData();
      
      dataBruker.setID(7);
      dataBruker.setEpost("edvin888@hotmail.com");
      dataBruker.setFornavn("Edvin");
      dataBruker.setEtternavn("Sehm");
      dataBruker.setPassword("root");
      
      
      bm.storeBruker(dataBruker);
    }
    
}
