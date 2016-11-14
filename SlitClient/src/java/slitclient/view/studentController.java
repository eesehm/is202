package slitclient.view;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


public class studentController {
   
   @FXML
    private Button logInn;
  
   @FXML
   private RadioButton radioStudent;
   @FXML
   private RadioButton radioForeleser;
   
   @FXML
   public void logInnNewScene(ActionEvent event) throws IOException{
     
     if(event.getSource().equals(logInn) && radioStudent.isSelected()){
        //get reference to the button's stage         
        Stage stage =(Stage) logInn.getScene().getWindow();
        //laster opp FXML dokument
        Parent studentroot = FXMLLoader.load(getClass().getResource("studentMV.fxml"));
        stage.setTitle("Slit v1.0");
        Scene scene = new Scene(studentroot);
        stage.setScene(scene);
        stage.show(); 
      
      
     } if(event.getSource() == logInn && radioForeleser.isSelected()) {
           Stage stage2 = (Stage) logInn.getScene().getWindow();
           Parent foreleserroot = FXMLLoader.load(getClass().getResource("foreleserUI.fxml"));
           stage2.setTitle("Slit v1.0");
           Scene scene2 = new Scene(foreleserroot);
           stage2.setScene(scene2);
           stage2.show();
   }
   } @FXML
     public void radioGroup (ActionEvent event) {
    ToggleGroup group = new ToggleGroup();
   
    radioStudent.setToggleGroup(group);
    radioForeleser.setToggleGroup(group);
   
     }
    
    
   
    }


