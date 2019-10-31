package sample.Enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.Field.GameField;

public class NormalEnemy implements Enemy {
    static int x=0;
    static int y=0;

    public static void drawTank(GraphicsContext gc) {
        gc.drawImage(new Image("file:resources/AssetKit4/PNG/Landscape/landscape_29.png"),0,0);
        gc.drawImage(new Image("file:resources/AssetsKit_3/Isometric/enemy_ufoYellow_N.png",132, 99, false,false), 0,0);
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
