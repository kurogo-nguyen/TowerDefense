package sample.Field;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.GameEntity;

import java.util.ArrayList;
import java.util.List;

public class GameField extends GameStage{
    public static List<GameEntity> entities = new ArrayList<>();

//    public static final String[][] MAP_SPRITES = new String[][] {
//            { "024", "024", "003", "047", "047", "047", "004", "024", "024", "024" },
//            { "024", "024", "025", "299", "001", "002", "023", "024", "024", "024" },
//            { "024", "024", "025", "023", "024", "025", "023", "024", "024", "024" },
//            { "003", "047", "048", "023", "024", "025", "023", "024", "024", "024" },
//            { "025", "299", "001", "027", "024", "025", "046", "047", "047", "047" },
//            { "025", "023", "024", "024", "024", "026", "001", "001", "001", "001" },
//            { "025", "023", "024", "024", "024", "024", "024", "024", "024", "024" },
//    };


//map 3D
    private static final String[][] MAP_SPRITES = new String[][] {
            {"28", "28", "28", "33", "28", "28", "28", "28", "28", "28", "28", "28" ,"28"},
            {"28", "38", "32", "04", "32", "03", "28", "28", "31", "32", "03", "28", "28"},
            {"28", "29", "28", "33", "28", "29", "28", "28", "29", "28", "29", "28", "28"},
            {"28", "29", "28", "33", "28", "29", "28", "28", "29", "28", "29", "28", "28"},
            {"28", "29", "28", "33", "28", "02", "32", "32", "07", "28", "29", "28", "28"},
            {"37", "09", "37", "05", "28", "28", "28", "28", "28", "28", "29", "28", "28"},
            {"28", "29", "28", "28", "28", "28", "28", "28", "28", "28", "29", "28", "28"},
            {"28", "29", "28", "28", "28", "28", "38", "32", "32", "32", "39", "28", "28"},
            {"28", "29", "28", "28", "28", "28", "29", "28", "28", "28", "28", "28", "28"},
            {"28", "29", "28", "28", "28", "28", "29", "28", "28", "28", "28", "28", "28"},
    };

    public static void render(GraphicsContext gc) {
        drawMap(gc);
        entities.forEach(g -> g.render(gc));
    }

    //diem dinh huong
    public static final Point[] wayPoints = new Point[] {
            new Point(getPosX(1,1), getPosY(1,1)),
            new Point(getPosX(1,5), getPosY(1,5)),
            new Point(getPosX(4,5), getPosY(4,5)),
            new Point(getPosX(4,8), getPosY(4,8)),
            new Point(getPosX(1,8), getPosY(1,8)),
            new Point(getPosX(1,10), getPosY(1,10)),
            new Point(getPosX(7,10), getPosY(7,10)),
            new Point(getPosX(7,6), getPosY(7,6)),
            new Point(getPosX(9,6), getPosY(9,6)),
    };

    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    //lay vi tri x tren screen
    public static int getPosX(int i, int j){
        return (MAP_SPRITES.length+j-i)*44;
    }

    //lay vi tri y tren screen
    public static int getPosY(int i, int j){
        return (j+i+5) * 22;
    }

    //ve map
    public static void drawMap(GraphicsContext gc) {
        for (int i = 0; i < MAP_SPRITES.length; i++) {
            for (int j = 0; j < MAP_SPRITES[i].length; j++) {
                    gc.drawImage(new Image("file:resources/AssetKit4/PNG/Landscape/landscape_" + MAP_SPRITES[i][j] + ".png"), getPosX(i,j), getPosY(i,j), 90 , 68 );
            }
        }
        //ve bang xay thap
        gc.drawImage(new Image("file:resources/AssetsKit_1/sprites/DefineSprite_230/1.png"), screenWidth-230, 0,230, screenHeight);
    }

    //update vi tri enemy
    public static void update() {
        entities.forEach(GameEntity::update);
    }
}
