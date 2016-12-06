package slitclient.view;

import Data.BrukerData;
import java.io.IOException;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import slitclient.manager.BrukerManager;

public class SlitInterfaceMainController extends Application {
   
     private Stage primaryStage;
     
     private AnchorPane mainLayout;
     
     @FXML
     private Button logInnButton;
    
     @FXML
     private Label logInnFailed;
  
     @FXML
     private TextField userNameTextField;
     
     @FXML
     private TextField passwordTextField;
     
     
     
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Slit v1.0");
        primaryStage.centerOnScreen();
        showMainView();
        
            
    }
    @FXML
    public void showMainView() throws IOException { //login meny
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(SlitInterfaceMainController.class.getResource("logInn.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    
    }
    
    @FXML
    private void logInn(ActionEvent e) throws IOException { //login bruker
        if(e.getSource().equals(logInnButton) && !this.passwordTextField.getText().isEmpty() 
           && !this.userNameTextField.getText().isEmpty()) { //sjekker for loing hos student
            
            BrukerManager bm = new BrukerManager();
            
            BrukerData bd = bm.logInnBruker(this.userNameTextField.getText(), this.passwordTextField.getText());
            
           
            
             if(bd.getEpost() != null && bd.getPassword() != null) {
            
                Stage stage = (Stage) logInnButton.getScene().getWindow();
       
                Parent studentroot = FXMLLoader.load(getClass().getResource("studentUI.fxml"));
                stage.setTitle("Student");
                stage.centerOnScreen();
                Scene scene = new Scene(studentroot);
        
                stage.setScene(scene);
                stage.show(); 
             
            
        
            } else if (userNameTextField.getText().contains("admin") //sjekker for login hos admin
                    && passwordTextField.getText().contains("admin") && e.getSource().equals(logInnButton)) {
                
                    Stage stage2 =(Stage) logInnButton.getScene().getWindow();
        //laster opp FXML dokument
        Parent foreleserroot = FXMLLoader.load(getClass().getResource("foreleserUI.fxml"));
        Scene scene2 = new Scene(foreleserroot);
        stage2.setTitle("Admin");
        stage2.centerOnScreen();
        stage2.setScene(scene2);
        stage2.show(); 
    }
           
    
            else {
                logInnFailed.setText("Innloggingen feilet. Sjekk at E-post adressen \nog passordet er riktig.");
            }
   }
 
    }
}
    
    

                
   

        
        
            
           
        
    
    

