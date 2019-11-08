package sample.Enemy;

import javafx.scene.canvas.GraphicsContext;
import sample.GameEntity;

public interface Enemy extends GameEntity {

    enum Direction {
        LEFT, UP, RIGHT, DOWN;
    }

    void render(GraphicsContext gc);

    void update();
}
