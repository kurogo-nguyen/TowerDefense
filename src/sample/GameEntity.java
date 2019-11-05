package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public interface GameEntity {


    abstract void render(GraphicsContext gc);
    abstract void update();
//    Canvas draw();
//    int getPosX();
//    int getPosY();

}
