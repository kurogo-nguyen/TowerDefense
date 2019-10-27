package sample;//package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Tower.NormalTower;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        NormalTower a = new NormalTower();
        Pane layout = new Pane();
        layout.getChildren().add(a.draw());
        primaryStage.setTitle("Tower Defense");
        primaryStage.setScene(new Scene(layout, 1000, 800));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}