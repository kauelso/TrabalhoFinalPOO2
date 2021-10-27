package freezemonsters.sprite;

import freezemonsters.FreezeMonsterCommons;
import spriteframework.sprite.BadSprite;

import javax.swing.*;
import java.awt.*;

public class FreezeMonsterShot extends BadSprite {
    public FreezeMonsterShot(){}
    public FreezeMonsterShot(int x, int y){
        initShot(x,y);
    }

    private void initShot(int x, int y){
        ImageIcon ii = new ImageIcon("images/ray.png");
        Image scaledImage = ii.getImage().getScaledInstance(FreezeMonsterCommons.SHOT_WIDTH, FreezeMonsterCommons.SHOT_HEIGHT, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        setImage(scaledIcon.getImage());

        int H_SPACE = 6;
        setX(x + H_SPACE);

        int V_SPACE = 1;
        setY(y - V_SPACE);
    }
}
