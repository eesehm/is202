package slitclient.view;

import Data.BrukerData;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Application;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import slitclient.manager.BrukerManager;

public class SlitInterfaceMainController extends Application {
   
     private Stage primaryStage;
     
     private AnchorPane mainLayout;
     
     @FXML
     private Button logInn;
    
     @FXML
     private Label logInnFailed;
  
     @FXML
     private TextField userNameTextField;
     
     @FXML
     private TextField passwordTextField;
     
     @FXML
     private ListView<String> listViewFX;
     
   @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Slit v1.0");
        showMainView();
        
            
    }
    public void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(SlitInterfaceMainController.class.getResource("logInn.fxml"));
        mainLayout = loader.load();
        Scene scene1 = new Scene(mainLayout);
        primaryStage.setScene(scene1);
        primaryStage.show();
    
    }
    
     
    BrukerManager bruker = new BrukerManager();
   
    @FXML
    private void logInn(ActionEvent e) throws IOException { //login bruker
        if(e.getSource().equals(logInn) && !this.passwordTextField.getText().isEmpty() 
           && !this.userNameTextField.getText().isEmpty()) { //sjekker for loing hos student
            BrukerData bd = bruker.logInnBruker(this.userNameTextField.getText(), this.passwordTextField.getText());
            
            if(bd.getEpost() != null && bd.getPassword() != null) {
            
                Stage stage =(Stage) logInn.getScene().getWindow();
       
                Parent studentroot = FXMLLoader.load(getClass().getResource("studentUI.fxml"));
                stage.setTitle("Student View");
                stage.centerOnScreen();
                Scene scene = new Scene(studentroot);
        
                stage.setScene(scene);
                stage.show(); 
        
        
            } else if ( userNameTextField.getText().contains("admin") //sjekker for login hos admin
                    && passwordTextField.getText().contains("admin") && e.getSource().equals(logInn)) {
                
                    Stage stage2 =(Stage) logInn.getScene().getWindow();
        //laster opp FXML dokument
        Parent foreleserroot = FXMLLoader.load(getClass().getResource("foreleserUI.fxml"));
        Scene scene2 = new Scene(foreleserroot);
        stage2.setTitle("Admin");
        stage2.centerOnScreen();
        stage2.setScene(scene2);
        stage2.show(); 
    }
    else { //gir beskjed om at innloggingen feilet 
        logInnFailed.setText("Innloggingen feilet. Sjekk at E-post adressen og passordet er riktig.");
    }
   }
 }
    
    
    

                
   
}
        
        
            
           
        
    
    

