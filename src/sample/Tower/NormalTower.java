package sample.Tower;

import sample.Tower.Bullet;
import sample.Tower.Tower;

public class NormalTower implements Tower, Bullet {
    private final int rateOfFire = 10;
    private final int damage = 50;
    private final int shootingRange = 10;

    public NormalTower() {
    }

    public int getRateOfFire() {
        return rateOfFire;
    }

    public int getDamage() {
        return damage;
    }

    public int getShootingRange() {
        return shootingRange;
    }
}
