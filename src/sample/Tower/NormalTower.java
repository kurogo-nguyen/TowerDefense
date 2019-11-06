package sample.Tower;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.GameEntity;

public class NormalTower extends TowerObj implements GameEntity {

    public NormalTower createNormalTower(){
        NormalTower tower = new NormalTower();
        tower.rateOfFire=10;
        tower.damage=2;
        tower.shootingRange=5;
        tower.x=getPosX();
        tower.y=getPosY();
        tower.img=new Image("towerSquare_sampleA_E.png", 100, 100, false, false);
        return tower;
    }

    int getPosX(){
        //TODO
        return 1;
    }

    int getPosY(){
        //TODO
        return 0;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(img, x , y);
    }

    @Override
    public void update() {

    }
}
