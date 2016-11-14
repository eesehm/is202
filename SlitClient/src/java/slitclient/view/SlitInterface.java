package slitclient.view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SlitInterface extends Application {
   
     private Stage primaryStage;
     
     private AnchorPane mainLayout;
     
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Slit v1.0");
        showMainView();
        
            
    }
    public void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(SlitInterface.class.getResource("MainView.fxml"));
        mainLayout = loader.load();
        Scene scene1 = new Scene(mainLayout);
        primaryStage.setScene(scene1);
        primaryStage.show();
    
    }
    
}
