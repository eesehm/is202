
package slitclient.view;

import java.io.IOException;
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
           Parent root = FXMLLoader.load(getClass().getResource("studentMV.fxml"));
           
           Scene scene3 = new Scene(root);
           stage3.setScene(scene3);
           stage3.show();
        }
        }
        @FXML
        public void tilLogInn(ActionEvent e) throws IOException {
            if(e.getSource() == tilbakeLogInn) {
           Stage stage3 = (Stage) tilbakeLogInn.getScene().getWindow();
           Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
           
           Scene scene3 = new Scene(root);
           stage3.setScene(scene3);
           stage3.show();
        
    
            }
}
}
