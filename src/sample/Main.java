package sample;//package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import sample.Enemy.NormalEnemy;
import sample.Field.GameField;

import java.io.File;


public class Main extends Application {
    Scene scene1, scene2;
    @Override
    public void start(Stage stage){

        //menu
        //tao Button
        Button play = new Button();
        play.setGraphic(new ImageView(new Image("file:resources/AssetsKit_1/buttons/DefineButton2_19/1.png")));
        Button quit = new Button("", new ImageView(new Image("file:resources/AssetsKit_1/shapes/16.png")));

        //set Action Button
        play.setOnAction(actionEvent -> {
            stage.setScene(scene2);
        });

        //tao vBox
        VBox vBox=new VBox();
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(100, 200, 200, 200));// top, right, bottom, left
        vBox.getChildren().addAll(play,quit);

        scene1=new Scene(vBox, 64*10,64*7);

        //Play Game
        // Tao Canvas
        Canvas canvas = new Canvas(88 * 15, 66 * 10);
        GraphicsContext gc = canvas.getGraphicsContext2D();

//        //tao am thanh
//        File m = new File("file:resources/AssetsKit_1/sounds/8_music.mp3");
//        Media music = new Media(m.toURI().toString());
//        music.play();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        scene2 = new Scene(root);

        // Them scene vao stage
        stage.setTitle("Tower Defense");
        stage.setScene(scene2);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                GameField.render(gc);
                GameField.update();
//                if (GameField.entities.size()<=5)
//                    GameField.entities.add(NormalEnemy.createNormalEnemy());
            }
        };
        timer.start();
    }



    public static void main(String[] args) {
        launch(args);
    }
}