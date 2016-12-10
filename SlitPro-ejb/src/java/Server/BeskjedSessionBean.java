
package Server;

import Data.BeskjedData;
import Database.Beskjed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class BeskjedSessionBean implements BeskjedSessionBeanRemote {

    
    @PersistenceContext
    private EntityManager em;
    
    
    private BeskjedData convertBeskjed (Beskjed beskjedEn) {
        
        BeskjedData beskjedData = new BeskjedData();
        
        beskjedData.setBeskjed_id(beskjedEn.getBeskjedId());
        beskjedData.setBeskjed_melding(beskjedEn.getBeskjedMelding());
        beskjedData.setBeskjed_date(beskjedEn.getBeskjedDato());
        
        
        return beskjedData;
    }
        
           private Beskjed convertToEntity(BeskjedData beskjedEn) {
        
        Beskjed beskjedData = new Beskjed();
        
        
        beskjedData.setBeskjedId(beskjedEn.getBeskjed_id());
        beskjedData.setBeskjedMelding(beskjedEn.getBeskjed_melding());
        beskjedData.setBeskjedDato(beskjedEn.getBeskjed_date());
        
        return beskjedData;
    
}
    @Override
    public boolean storeBeskjed(BeskjedData beskjedEn) {
          Beskjed beskjed = this.convertToEntity(beskjedEn);
          
          try {
          em.persist(beskjed);
          }
          catch (Exception e) {
              e.printStackTrace();
              return false;
          }
          return true;

}
    @Override
    public String getBeskjedFromId(int beskjedId){
        
        Beskjed b = em.find(Beskjed.class, beskjedId);
        return b.getBeskjedMelding();
    }    
    
    @Override
    public BeskjedData deleteBeskjed() {
        BeskjedData bd = new BeskjedData();
        Query q = em.createNamedQuery("Beskjed.delete", Beskjed.class);
        
        q.executeUpdate();
       
        return bd;
    }
}
   
