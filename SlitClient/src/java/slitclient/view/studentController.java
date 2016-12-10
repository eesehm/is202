package slitclient.view;
import Data.BrukerData;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import static slitclient.manager.Authenticator.getBruker;
import slitclient.manager.Authenticator;
import slitclient.manager.BeskjedManager;
import slitclient.manager.BrukerManager;




public class studentController implements Initializable {
   
     @FXML
    public Label textMelding;
    @FXML
    public Label beskjedDato;
    @FXML
    private Label fornavnLabel;
    
   @Override 
    public void initialize(URL u, ResourceBundle b) {
       
        String firstname = (BrukerManager.getUserFirstName());
        
        fornavnLabel.setText("Hei, "+firstname);
        
    }
    

}

