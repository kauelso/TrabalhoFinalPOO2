package freezemonsters.sprite;

import spriteframework.sprite.BadSprite;

import javax.swing.*;
import java.awt.*;

public class FreezeMonsterSlime extends BadSprite {
    private boolean isDestroyed;

    public FreezeMonsterSlime(int x, int y){
        initSlime(x,y);
    }

    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    private void initSlime(int x, int y){
        setDestroyed(true);

        this.x = x;
        this.y = y;

        ImageIcon ii = new ImageIcon(this.getClass().getResource("/images/gosma.png"));
        Image scaledImage = ii.getImage().getScaledInstance(30, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        setImage(scaledIcon.getImage());
    }
}
