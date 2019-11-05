package sample.Enemy;

import javafx.scene.canvas.GraphicsContext;
import sample.GameEntity;

public interface Enemy extends GameEntity {
    enum Direction {
        LEFT(180), UP(270), RIGHT(0), DOWN(90);

        int degree;

        Direction(int i) {
            degree = i;
        }

        int getDegree() {
            return degree;
        }
    }

    void render(GraphicsContext gc);

    void update();
//    int heath;
//    int moveSpeed;
//    int armor;
//    void move();
}
