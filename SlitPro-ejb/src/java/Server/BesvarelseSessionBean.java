package Server;

import Data.BesvarelseData;
import Data.BrukerData;
import Database.Besvarelse;
import Database.Bruker;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class BesvarelseSessionBean implements BesvarelseSessionBeanRemote {

    @PersistenceContext
    private EntityManager em;
    
    private BesvarelseData convertBesvarelse (Besvarelse besvarelseEn) {
        
        BesvarelseData bd = new BesvarelseData();
        
        bd.setBesvarelseID(besvarelseEn.getBesvarelseID());
        bd.setModulnummer(besvarelseEn.getModulNummer());
        bd.setOpplastetFil(besvarelseEn.getOpplastetFil());
        bd.setKommentar(besvarelseEn.getKommentar());
        bd.setDato(besvarelseEn.getDato());
        bd.setVurderingsvarsel(besvarelseEn.getVurderingsvarsel());
        
        return bd;
    }
    
    private Besvarelse convertToEntity(BesvarelseData besvarelseEn) {
        
        Besvarelse b = new Besvarelse();
        
        b.setBesvarelseID(besvarelseEn.getBesvarelseID());
        b.setModulNummer(besvarelseEn.getModulnummer());
        b.setOpplastetFil(besvarelseEn.getOpplastetFil());
        b.setKommentar(besvarelseEn.getKommentar());
        b.setDato(besvarelseEn.getDato());
        b.setVurderingsvarsel(besvarelseEn.getVurderingsvarsel());
        
        return b;
    }
    
        @Override
        public List<BesvarelseData> getBesvarelser() {
            
            List<BesvarelseData> besvarelseListe = new ArrayList<BesvarelseData>();
            
             try {
                 
                 Query q = em.createNamedQuery("Besvarelse.modulEn", Besvarelse.class);
                
            
              //q2.executeUpdate();
              List <Besvarelse> b = q.getResultList();
              
            
            for(Besvarelse besvarelse : b) {
                besvarelseListe.add(this.convertBesvarelse(besvarelse));
            }
            
             }
            catch (Exception e)
            {
                 e.printStackTrace();
            }
                 return besvarelseListe;
                
        }
        @Override
        public List<BesvarelseData> getBesvarelser2() {
            
            List<BesvarelseData> besvarelseListe2 = new ArrayList<BesvarelseData>();
            
             try {
                 
                 Query q = em.createNamedQuery("Besvarelse.modulTo", Besvarelse.class);
                
            
              //q2.executeUpdate();
              List <Besvarelse> b = q.getResultList();
              
            
            for(Besvarelse besvarelse : b) {
                besvarelseListe2.add(this.convertBesvarelse(besvarelse));
            }
            
             }
            catch (Exception e)
            {
                 e.printStackTrace();
            }
                 return besvarelseListe2;
                
        }
}
