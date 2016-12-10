/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Data.BeskjedData;
import javax.ejb.Remote;

/**
 *
 * @author Edvin
 */
@Remote
public interface BeskjedSessionBeanRemote {
    
    public boolean storeBeskjed(BeskjedData beskjedEn);
    
     public String getBeskjedFromId(int beskjedId);
     
     public BeskjedData deleteBeskjed();
}
