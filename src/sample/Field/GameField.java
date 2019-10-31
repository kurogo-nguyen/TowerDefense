package sample.Field;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.GameEntity;

import java.util.ArrayList;
import java.util.List;

public class GameField {
    private List<GameEntity> entities = new ArrayList<>();
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
    public static void drawMap(GraphicsContext gc) {
        for (int i = 0; i < MAP_SPRITES.length; i++) {
            for (int j = 0; j < MAP_SPRITES[i].length; j++) {
                if(Integer.parseInt(MAP_SPRITES[i][j])>=40){
                    gc.drawImage(new Image("file:resources/AssetKit4/PNG/Landscape/landscape_" + MAP_SPRITES[i][j] + ".png"), MAP_SPRITES.length*65+j*65-65-i*65, 60-16+(j+i) * 32.5);
                }else
                    gc.drawImage(new Image("file:resources/AssetKit4/PNG/Landscape/landscape_" + MAP_SPRITES[i][j] + ".png"), MAP_SPRITES.length*65+j*65-65-i*65, 60+(j+i) * 32.5);
            }
        }
    }


}
