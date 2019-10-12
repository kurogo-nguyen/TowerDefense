package sample.Tower;

import sample.GameEntity;

public interface Bullet extends GameEntity {
    int getRateOfFire();
    int getShootingRange();
    int getDamage();

}
