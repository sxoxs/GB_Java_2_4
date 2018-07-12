package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Чат");
        primaryStage.getIcons().add(new Image("/sample/css/icon.jpg"));

        Scene scene = new Scene(root, 300, 275);
        scene.getStylesheets().add(getClass().getResource("/sample/css/style.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

//        new WindowLauncher().launch();
    }


}
