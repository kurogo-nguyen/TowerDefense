package sample.Enemy;

import javafx.scene.canvas.GraphicsContext;
import sample.GameEntity;

public interface Enemy extends GameEntity {

    enum Direction {
        LEFT(0), UP(0), RIGHT(0), DOWN(0);

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
}
