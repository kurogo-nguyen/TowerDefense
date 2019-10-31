package sample;//package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.Enemy.NormalEnemy;
import sample.Field.GameField;
import sample.Tower.NormalTower;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        Canvas canvas = new Canvas(130 * 10, 61 * 14);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        GameField.drawMap(gc);
        NormalEnemy.drawTank(gc);

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setTitle("Tower Defense");
        stage.setScene(scene);
        stage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }
}