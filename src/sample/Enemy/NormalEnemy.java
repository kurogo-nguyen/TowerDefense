package sample.Enemy;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import sample.Field.GameField;
import sample.Field.Point;
import sample.GameEntity;

import static sample.Field.GameField.wayPoints;

public class NormalEnemy implements Enemy, GameEntity {
    int i, j;
    int x;
    int y;
    Image img;

    double speed;
    Direction direction;
    Image gunImg;

    public static NormalEnemy createNormalEnemy() {
        NormalEnemy tank = new NormalEnemy();
        tank.i = 0;
        tank.j = 6;
        tank.x = tank.i * 64 + 32;
        tank.y = tank.j * 64;
        tank.speed = 5;
        tank.direction = Direction.UP;
        tank.img = new Image("file:resources/AssetsKit_2/PNG/Retina/towerDefense_tile268.png");
        tank.gunImg = new Image("file:resources/AssetsKit_2/PNG/Retina/towerDefense_tile291.png");
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

        ImageView iv2 = new ImageView(gunImg);
        iv2.setRotate(this.direction.getDegree());
        Image gun = iv2.snapshot(params, null);

        gc.drawImage(base, x, y, 64,64);
        gc.drawImage(gun, x, y,64,64);

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
            if (deltaX > speed) direction = Direction.RIGHT;
            else if (deltaX < -speed) direction = Direction.LEFT;
            else if (deltaY > speed) direction = Direction.DOWN;
            else if (deltaY <= -speed) direction = Direction.UP;
        }
    }

    @Override
    public void update() {

        calculateDirection();

        switch (direction) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
        }
    }
}


