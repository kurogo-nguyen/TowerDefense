package sample;//package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import sample.Enemy.NormalEnemy;
import sample.Field.GameField;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        Canvas canvas = new Canvas(64 * 10, 64 * 7);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setTitle("Tower Defense");
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                GameField.render(gc);
                GameField.update();
            }
        };
        timer.start();

        GameField.entities.add(NormalEnemy.createNormalEnemy());
    }



    public static void main(String[] args) {
        launch(args);
    }
}