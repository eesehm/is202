/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Data.BrukerData;
import java.util.List;
import javafx.scene.control.TableView;
import javax.ejb.Remote;

/**
 *
 * @author Edvin
 */
@Remote
public interface BrukerSessionBeanRemote {
    
    
    
    String getBrukerNavnFromId(int id);
    
    BrukerData getBruker(int id);
    
    List<BrukerData> getBrukere();
    
    boolean storeBruker(BrukerData brukerEn);
    
    BrukerData logInnBruker(String epost, String password);
    
 
}
