package sample.Enemy;

import javafx.scene.image.Image;
import sample.GameObj;

abstract class EnemyObj extends GameObj {
    double speed;
    Enemy.Direction direction;
    Image gunImg;
}
