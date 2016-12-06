
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
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.persistence.EntityManager;

import slitclient.manager.BrukerManager;


public class foreleserController implements Initializable {
    
    @FXML
    private Button leggTilModulBtn;
    @FXML
    private TextField modulNavn;
    @FXML
    private Button submitModulBtn;
    @FXML
    private Button tilStudentButton;
    @FXML
    public ListView deltakereList;
    @FXML
    private Button tilbakeLogInn;
    @FXML
    private TableView<BrukerData> mainTableView;
    @FXML
    private TableColumn<BrukerData, String> columnFornavn;
    @FXML
    private TableColumn<BrukerData, String> columnEtternavn;
    @FXML
    private TableColumn<BrukerData, String> columnEpost;
    @FXML
    private Label antallStudenterLabel;
    @FXML
    private Button deleteButton;
    
    
    public ObservableList<BrukerData> studentData;
    
     
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
           Stage stage = (Stage) tilStudentButton.getScene().getWindow();
           Parent root = FXMLLoader.load(getClass().getResource("studentUI.fxml"));
           
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
        }
        }
        @FXML
        public void tilLogInn(ActionEvent e) throws IOException {
            if(e.getSource() == tilbakeLogInn) {
           Stage stage = (Stage) tilbakeLogInn.getScene().getWindow();
           Parent root = FXMLLoader.load(getClass().getResource("logInn.fxml"));
           
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
        
    
            }
}
        
        @Override
        public void initialize(URL u, ResourceBundle b) {
            
            BrukerManager bm = new BrukerManager();
            
            columnFornavn.setCellValueFactory(new PropertyValueFactory<BrukerData, String> ("fornavn"));
            columnEtternavn.setCellValueFactory(new PropertyValueFactory<BrukerData, String> ("etternavn"));
            columnEpost.setCellValueFactory(new PropertyValueFactory<BrukerData, String> ("epost"));
            
            this.studentData = FXCollections.observableArrayList();
            
            this.studentData.addAll(bm.getBrukere());
            this.mainTableView.setItems(studentData);
            
            antallStudenterLabel.setText(""+this.mainTableView.getItems().size());
        }
        
        
        
    
    
       
         
       
}

         
