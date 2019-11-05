package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class Controller {
    public void menu(GraphicsContext gc){
        gc.drawImage(new Image("file:resources/AssetsKit_2/Sample.png"),0,0, 10*64,7*64);
        gc.drawImage(new Image("file:resources/AssetsKit_1/buttons/DefineButton2_19/1.png"), 4*64+32, 2*64);
    }
}
