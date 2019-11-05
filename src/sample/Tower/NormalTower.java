package sample.Tower;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class NormalTower {
    private final int rateOfFire = 10;
    private final int damage = 50;
    private final int shootingRange = 10;
    private int x=0;
    private int y=0;
    private final Image image = new Image("towerSquare_sampleA_E.png", 100, 100, false, false);

    public NormalTower() {
    }

//    public Canvas draw() {
//        Canvas canvas = new Canvas(100, 100);
//        GraphicsContext gc = canvas.getGraphicsContext2D();
//        gc.drawImage(image, getPosX(), getPosY());
//        return canvas;
//    }

    public int getRateOfFire() {
        return rateOfFire;
    }

    public int getDamage() {
        return damage;
    }

    public int getShootingRange() {
        return shootingRange;
    }

//    @Override
//    public int getPosX() {
//        return x;
//    }
//
//    @Override
//    public int getPosY() {
//        return y;
//    }
}
