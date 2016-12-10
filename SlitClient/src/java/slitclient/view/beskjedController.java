
package slitclient.view;

import Data.BeskjedData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import slitclient.manager.BeskjedManager;


public class beskjedController {
    
    @FXML
    private Button beskjedButton;
    @FXML
    private TextArea textArea;
    @FXML
    private DatePicker datoBeskjed;
    
        @FXML //laster opp beskjed - sjekker om textfield for beksjed har innhold
        public void submitBeskjed(ActionEvent e) {
            if(e.getSource() == beskjedButton && textArea.getText()!= null) {
              foreleserController fc = new foreleserController();
              BeskjedData beskjedEn = new BeskjedData ();
             // beskjedEn.setBeskjed_id(Integer.valueOf(beskjedNr.getText()));
              
              beskjedEn.setBeskjed_date(java.sql.Date.valueOf(datoBeskjed.getValue()));
              beskjedEn.setBeskjed_melding(textArea.getText());
              BeskjedManager bm  = new BeskjedManager();
              bm.storeBeskjed(beskjedEn);
              
              
            }
            else {
            
            }
        }
}
