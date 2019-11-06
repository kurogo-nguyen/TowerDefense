package sample.Field;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.GameEntity;

import java.util.ArrayList;
import java.util.List;

public class GameField{
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
            { "28", "28", "28", "33", "28", "28", "28", "28", "28", "28", "28", "28" ,"28"},
            { "28", "38", "32", "04", "32", "03", "28", "28", "31", "32", "03", "28", "28"},
            { "28", "29", "28", "33", "28", "29", "28", "28", "29", "28", "29", "28", "28"},
            { "28", "29", "28", "33", "28", "29", "28", "28", "29", "28", "29", "28", "28"},
            { "28", "29", "28", "33", "28", "02", "32", "32", "07", "28", "29", "28", "28"},
            { "37", "09", "37", "05", "28", "28", "28", "28", "28", "28", "29", "28", "28"},
            { "28", "29", "28", "28", "28", "28", "28", "28", "28", "28", "29", "28", "28"},
            { "28", "29", "28", "28", "28", "28", "38", "32", "32", "32", "39", "28", "28"},
            { "28", "29", "28", "28", "28", "28", "29", "28", "28", "28", "28", "28", "28"},
            { "28", "29", "28", "28", "28", "28", "29", "28", "28", "28", "28", "28", "28"},
    };

    public static void render(GraphicsContext gc) {
        drawMap(gc);
        entities.forEach(g -> g.render(gc));
    }

    public static final Point[] wayPoints = new Point[] {
            new Point(0 * 64 + 32, 6 * 64 + 00),
            new Point(0 * 64 + 32, 3 * 64 + 32),
            new Point(2 * 64 + 32, 3 * 64 + 32),
            new Point(2 * 64 + 32, 0 * 64 + 32),
            new Point(5 * 64 + 32, 0 * 64 + 32),
            new Point(5 * 64 + 32, 5 * 64 - 32),
            new Point(9 * 64 + 32, 5 * 64 - 32),
    };

    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static int getPosX(int i, int j){
        return (MAP_SPRITES.length+j-i)*44;
    }

    public static int getPosY(int i, int j){
        return (j+i+5) * 22;
    }

    public static void drawMap(GraphicsContext gc) {
        for (int i = 0; i < MAP_SPRITES.length; i++) {
            for (int j = 0; j < MAP_SPRITES[i].length; j++) {
                    gc.drawImage(new Image("file:resources/AssetKit4/PNG/Landscape/landscape_" + MAP_SPRITES[i][j] + ".png"), getPosX(i,j), getPosY(i,j), 90 , 68 );
            }
        }
    }


    public static void update() {
        entities.forEach(GameEntity::update);
    }
}
