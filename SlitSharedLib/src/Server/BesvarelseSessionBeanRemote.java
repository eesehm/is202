/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Data.BesvarelseData;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Edvin
 */
@Remote
public interface BesvarelseSessionBeanRemote {
    
    public List<BesvarelseData> getBesvarelser();
    
    public List<BesvarelseData> getBesvarelser2();
}
