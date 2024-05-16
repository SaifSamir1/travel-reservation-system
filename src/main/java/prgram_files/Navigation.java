package prgram_files;

import com.example.travelreservationsystem.MainClass;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
//This class provides a static method navigateToNewStage that
// facilitates the navigation to a new JavaFX stage by loading an FXML file
public class Navigation {
    public static void navigateToNewStage(String path) throws IOException {

        // this method use to navigate to the new stage
        FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource(path));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Traveling");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
