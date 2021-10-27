package freezemonsters.sprite;

import freezemonsters.FreezeMonsterCommons;
import spriteframework.sprite.BadSprite;

import javax.swing.*;
import java.awt.*;

public class FreezeMonsterShot extends BadSprite {
    private int dirX;
    private int dirY;
    public FreezeMonsterShot(){}
    public FreezeMonsterShot(int x, int y, int dirX, int dirY){
        initShot(x,y);
        this.dirY = dirY;
        if(dirX == 0 && dirY == 0) this.dirX = 1;
        else this.dirX = dirX;
    }

    private void initShot(int x, int y){
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/images/ray.png"));
        Image scaledImage = ii.getImage().getScaledInstance(FreezeMonsterCommons.SHOT_WIDTH, FreezeMonsterCommons.SHOT_HEIGHT, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        setImage(scaledIcon.getImage());

        int H_SPACE = 6;
        setX(x + H_SPACE);

        int V_SPACE = 1;
        setY(y - V_SPACE);
    }

    public void act(){
        if (y <= 0 || y >= FreezeMonsterCommons.BOARD_HEIGHT) {
            this.die();
        } else {
            this.setY(y + (dirY * FreezeMonsterCommons.SHOT_SPEED));
        }
        if (x <= 0 || x >= FreezeMonsterCommons.BOARD_WIDTH) {
            this.die();
        } else {
            this.setX(x + (dirX * FreezeMonsterCommons.SHOT_SPEED));
        }
    }

}
