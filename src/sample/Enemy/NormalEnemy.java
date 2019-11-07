package sample.Enemy;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import sample.Field.GameField;
import sample.Field.Point;
import sample.GameEntity;

import static sample.Field.GameField.*;

public class NormalEnemy extends EnemyObj implements Enemy, GameEntity {

    public static NormalEnemy createNormalEnemy() {
        NormalEnemy tank = new NormalEnemy();
        tank.i = 9;
        tank.j = 1;
        tank.x = getPosX(tank.i, tank.j);
        tank.y = getPosY(tank.i, tank.j);
        tank.speed = 6;
        tank.direction = Direction.UP;
        tank.img = new Image("file:resources/AssetsKit_3/Isometric/enemy_ufoYellowWeapon_E.png");
//        tank.gunImg = new Image("file:resources/AssetsKit_2/PNG/Retina/towerDefense_tile291.png");
        return tank;
    }

    int wayPointIndex = 0;
    public Point getNextWayPoint() {
        if (wayPointIndex < wayPoints.length - 1)
            return GameField.wayPoints[++wayPointIndex];
        return null;
    }

    @Override
    public void render(GraphicsContext gc) {
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);

        ImageView iv = new ImageView(img);
        iv.setRotate(this.direction.getDegree());
        Image base = iv.snapshot(params, null);

        gc.drawImage(base, x, y-30, 90 , 90);

        gc.setFill(Color.RED);
        gc.fillOval(GameField.wayPoints[wayPointIndex].x,GameField.wayPoints[wayPointIndex].y,10, 10);

        gc.setFill(Color.BLUE);
        gc.fillOval(x, y,10, 10);
    }

    void calculateDirection() {
        // Tinh huong di tiep theo cho Object
        if (wayPointIndex >= GameField.wayPoints.length) {
            // Enemy den way point cuoi
            return;
        }

        Point currentWP = GameField.wayPoints[wayPointIndex];
        if (GameField.distance(x, y, currentWP.x, currentWP.y) <= speed) {
            x = currentWP.x;
            y = currentWP.y;
            Point nextWayPoint = getNextWayPoint();
            if (nextWayPoint == null) return;
            double deltaX = nextWayPoint.x - x;
            double deltaY = nextWayPoint.y - y;
            if (deltaX > speed && deltaY > speed/2) direction = Direction.RIGHT;
            else if (deltaX < -speed && deltaY < -speed/2) direction = Direction.LEFT;
            else if (deltaX < -speed && deltaY > speed/2) direction = Direction.DOWN;
            else if (deltaX > speed && deltaY <= -speed) direction = Direction.UP;
        }
    }

    @Override
    public void update() {

        calculateDirection();

        switch (direction) {
            case UP:
                y -= speed/2;
                x += speed;
                break;
            case DOWN:
                y += speed/2;
                x -= speed;
                break;
            case LEFT:
                y -= speed/2;
                x -= speed;
                break;
            case RIGHT:
                y += speed/2;
                x += speed;
                break;
        }
    }
}


