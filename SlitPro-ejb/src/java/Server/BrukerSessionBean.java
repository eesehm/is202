/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Data.BrukerData;
import Database.Bruker;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.jms.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Edvin
 */
@Stateless
public class BrukerSessionBean implements BrukerSessionBeanRemote {

    @PersistenceContext
    private EntityManager em;

    
    @Override
    public String getBrukerNavnFromId( int id) {
        Bruker bruker = em.find(Bruker.class, id);
        return bruker.getFornavn();
    }

    public void persist(Object object) {
        em.persist(object);
    }
    
    @Override
        public BrukerData getBruker(int id) {
        Bruker bruker = em.find(Bruker.class, id);
        
        return this.convertBruker(bruker);
    }
    
        @Override
        public List<BrukerData> getBrukere() {
            
            List<BrukerData> brukerListe = new ArrayList<BrukerData>();
            
             try {
             Query q = em.createNamedQuery("Bruker.findAll", Bruker.class);
            
            List <Bruker> b = q.getResultList();
            
            for(Bruker bruker : b) {
                brukerListe.add(this.convertBruker(bruker));
            }
            
             }
            catch (Exception e)
            {
                 e.printStackTrace();
            }
                 return brukerListe;
                
        }
        
    private BrukerData convertBruker(Bruker brukerEn) {
        
        BrukerData brukerData = new BrukerData();
        
        brukerData.setID(brukerEn.getId());
        brukerData.setFornavn(brukerEn.getFornavn());
        brukerData.setEtternavn(brukerEn.getEtternavn());
        brukerData.setEpost(brukerEn.getEpost());
        brukerData.setPassword(brukerEn.getPassword());
        
        return brukerData;
    }
    
    private Bruker convertToEntity(BrukerData brukerEn) {
        
        Bruker brukerData = new Bruker();
        
        brukerData.setId(brukerEn.getID());
        brukerData.setFornavn(brukerEn.getFornavn());
        brukerData.setEtternavn(brukerEn.getEtternavn());
        brukerData.setEpost(brukerEn.getEpost());
        brukerData.setPassword(brukerEn.getPassword());
        
        return brukerData;
    }
        @Override
      public boolean storeBruker(BrukerData brukerEn) {
          Bruker bruker = this.convertToEntity(brukerEn);
          
          try {
          em.persist(bruker);
          }
          catch (Exception e) {
              e.printStackTrace();
              return false;
          }
          return true;

      }
      
      @Override
      public BrukerData logInnBruker(String epost, String password) {
          BrukerData bd = new BrukerData();
          
          try {
              Query q = em.createNamedQuery("Bruker.login", Bruker.class);
              
              q.setParameter("epost", epost);   
              q.setParameter("password", password);
              
              Bruker b = (Bruker)q.getSingleResult();
              
              bd = this.convertBruker(b);
          }
          catch(Exception e) {
              e.printStackTrace();
          }
            return bd;
 
              
          }

                    
}

     
    

