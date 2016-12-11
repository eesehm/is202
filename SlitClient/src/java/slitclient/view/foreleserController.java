
package slitclient.view;


import Data.BesvarelseData;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import slitclient.manager.BeskjedManager;
import slitclient.manager.BesvarelseManager;
import slitclient.manager.BrukerManager;



public class foreleserController implements Initializable {
    
    @FXML
    public Button leggTilModulBtn;
    @FXML
    private Button tilStudentButton;
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
    @FXML
    private Button deleteAllStudents;
    @FXML
    private Button fjernBeskjedButton;
    @FXML
    private TextField brukerIDfelt;
    @FXML
    private TextField fornavnFelt;
    @FXML
    private TextField etternavnFelt;
    @FXML
    private TextField epostFelt;
    @FXML
    private Button submitBrukerBtn;
    @FXML
    private Button leggTilBeskjedBtn;
    @FXML
    private TableView<BesvarelseData> besvarelseTable;
    @FXML
    private TableColumn<BesvarelseData, String> columnBesvarelseId;
    @FXML
    private TableColumn<BesvarelseData, String> columnBesvarelseDato;
    @FXML
    private TableColumn<BesvarelseData, String> columnFil;
    @FXML
    private Label antallBesvarelserLabel;
    @FXML
    private Label antallBesvarelserLabel2;
    @FXML
    private TableView<BesvarelseData> besvarelseTable2;
    @FXML
    private TableColumn<BesvarelseData, String> columnBesvarelseId2;
    @FXML
    private TableColumn<BesvarelseData, String> columnBesvarelseDato2;
    @FXML
    private TableColumn<BesvarelseData, String> columnFil2;
   
    public ObservableList<BrukerData> studentData;
    
    public ObservableList<BesvarelseData> besvarelseData;
    
    public ObservableList<BesvarelseData> besvarelseData2;
     
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
            
            mainTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            antallStudenterLabel.setText(""+this.mainTableView.getItems().size());
            
            //modul 1 table:
            BesvarelseManager besvarelsemanager = new BesvarelseManager();
            
            columnBesvarelseId.setCellValueFactory(new PropertyValueFactory<BesvarelseData, String> ("besvarelseID"));
            
            columnBesvarelseDato.setCellValueFactory(new PropertyValueFactory<BesvarelseData, String> ("dato"));
            columnFil.setCellValueFactory(new PropertyValueFactory<BesvarelseData, String> ("opplastet_fil"));
            
            this.besvarelseData = FXCollections.observableArrayList();
            this.besvarelseData.addAll(besvarelsemanager.getBesvarelser());
            this.besvarelseTable.setItems(besvarelseData);
            
            besvarelseTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            antallBesvarelserLabel.setText(""+this.besvarelseTable.getItems().size()+"/"+this.mainTableView.getItems().size());
            
            //modul 2 table:
            
            
            columnBesvarelseId2.setCellValueFactory(new PropertyValueFactory<BesvarelseData, String> ("besvarelseID"));
            
            columnBesvarelseDato2.setCellValueFactory(new PropertyValueFactory<BesvarelseData, String> ("dato"));
            columnFil2.setCellValueFactory(new PropertyValueFactory<BesvarelseData, String> ("opplastet_fil"));
            
            this.besvarelseData2 = FXCollections.observableArrayList();
            this.besvarelseData2.addAll(besvarelsemanager.getBesvarelser2());
            this.besvarelseTable2.setItems(besvarelseData2);
            
            besvarelseTable2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            antallBesvarelserLabel2.setText(""+this.besvarelseTable2.getItems().size()+"/"+this.mainTableView.getItems().size());
            
        }
        @FXML
        public void deleteBruker(ActionEvent e) throws IOException { //sletter valgt bruker
            if(e.getSource() == deleteButton) {
                
                BrukerManager bm = new BrukerManager();
                BrukerData bruker = mainTableView.getSelectionModel().getSelectedItem();
               
                    
                    bm.deleteBruker(bruker.getID());
                    this.studentData.remove(bruker);
                    
                    antallStudenterLabel.setText(""+this.mainTableView.getItems().size());
                }
            }
        @FXML
        public void leggTilBeskjed(ActionEvent e) throws IOException { //åpner vindu for å legge til ny beskjed
        
        if(e.getSource() == leggTilBeskjedBtn) {
           
        FXMLLoader beskjedLoader = new FXMLLoader();
        beskjedLoader.setLocation(getClass().getResource("beskjedUI.fxml"));
        beskjedLoader.load();
        Parent beskjedroot = beskjedLoader.getRoot();
        
        Stage beskjedStage = new Stage();
        beskjedStage.setTitle("Beskjed");
        Scene scene = new Scene(beskjedroot);
        
        beskjedStage.initModality(Modality.APPLICATION_MODAL);
        beskjedStage.initOwner(leggTilBeskjedBtn.getScene().getWindow());
        beskjedStage.setScene(scene);
        beskjedStage.showAndWait();
        
        }  
}
        @FXML
        public void fjernBeskjed(ActionEvent e) {
            if(e.getSource() == fjernBeskjedButton) {
                BeskjedManager bm = new BeskjedManager();
                
                bm.deleteBeskjed();
            }
        }
        @FXML
        public void deleteAllStudents(ActionEvent e) {
            if(e.getSource() == deleteAllStudents) {
                BrukerManager bm = new BrukerManager();
                
                bm.deleteBrukere();
                
                
                this.studentData.removeAll(studentData);
                    
                antallStudenterLabel.setText(""+this.mainTableView.getItems().size());
            }
        }
         @FXML
         private void SubmitBruker(ActionEvent e) {
            if(e.getSource() == submitBrukerBtn && fornavnFelt.getText() != null && etternavnFelt.getText() != null)
        {
         BrukerData brukerEn = new BrukerData ();
              brukerEn.setID(Integer.valueOf(brukerIDfelt.getText()));
              brukerEn.setFornavn(fornavnFelt.getText());
              brukerEn.setEtternavn(etternavnFelt.getText());
              brukerEn.setEpost(epostFelt.getText());
              brukerEn.setPassword(fornavnFelt.getText() + "123");
              BrukerManager bm = new BrukerManager();
              bm.storeBruker(brukerEn);   
              
              this.studentData.add(brukerEn);
               
              mainTableView.refresh();
              this.antallStudenterLabel.setText(""+this.mainTableView.getItems().size());
        }
          else    {
    
    }
}   
        
        
    
            
       
       
         
       
}

         
