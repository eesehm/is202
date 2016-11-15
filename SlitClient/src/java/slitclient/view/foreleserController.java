
package slitclient.view;

import Data.BrukerData;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import slitclient.manager.BrukerManager;


public class foreleserController {
    
    @FXML
    private Button leggTilModulBtn;
    
    @FXML
    private TextField modulNavn;
    
    @FXML
    private Button submitModulBtn;
    @FXML
    public Label labelModulNavn;
    @FXML
    public Button tilStudentButton;
    @FXML
    public ListView deltakereList;
    @FXML
    private Button tilbakeLogInn;
    @FXML
    private ListView<String> MainListView;
    
    @FXML
    public void leggTilModul(ActionEvent e) throws IOException { //åpner vindu for å legge til ny modul
        
        if(e.getSource() == leggTilModulBtn) {
           
        FXMLLoader modulLoader = new FXMLLoader();
        modulLoader.setLocation(getClass().getResource("foreleserLeggTilModul.fxml"));
        modulLoader.load();
        Parent modulroot = modulLoader.getRoot();
        
        Stage modul = new Stage();
        modul.setTitle("Legg til modul");
        Scene scene = new Scene(modulroot);
        
        modul.initModality(Modality.APPLICATION_MODAL);
        modul.setScene(scene);
        modul.showAndWait();
            
           
    }
 }   
        @FXML //laster opp modul - sjekker om textfield har innhold
        public void submitModul(ActionEvent e) {
            if(e.getSource() == submitModulBtn && modulNavn.getText() != null) {
            
              
            }
            
        }
        
        @FXML
        public void tilStudentUI(ActionEvent e) throws IOException {
            if(e.getSource() == tilStudentButton) {
           Stage stage3 = (Stage) tilStudentButton.getScene().getWindow();
           Parent root = FXMLLoader.load(getClass().getResource("studentUI.fxml"));
           
           Scene scene3 = new Scene(root);
           stage3.setScene(scene3);
           stage3.show();
        }
        }
        @FXML
        public void tilLogInn(ActionEvent e) throws IOException {
            if(e.getSource() == tilbakeLogInn) {
           Stage stage3 = (Stage) tilbakeLogInn.getScene().getWindow();
           Parent root = FXMLLoader.load(getClass().getResource("logInn.fxml"));
           
           Scene scene3 = new Scene(root);
           stage3.setScene(scene3);
           stage3.show();
        
    
            }
}
       /* @Override
        public void initialize(URL url, ResourceBundle rb) {
            BrukerManager bm = new BrukerManager();
            
            ObservableList<String> items = FXCollections.observableArrayList();
            
            for(BrukerData b : bm.getAllUsers())
                 items.add(b.getEpost());
        }
        */
        
        
}
