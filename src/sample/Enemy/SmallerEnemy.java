package sample.Enemy;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SmallerEnemy implements Enemy {
    public Canvas draw() {
        Canvas canvas = new Canvas(500, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image image= new Image("src/TowerDefense/AssetsKit_3/Isometric/detail_crystal_E.png/enemy_ufoGreen_S");
        gc.drawImage(image, getPosX(), getPosY());
        canvas.setScaleX(0.2);

        return canvas;
    }


    public int getPosX() {
        return 0;
    }


    public int getPosY() {
        return 0;
    }

    public void move() {

    }
}
