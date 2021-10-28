package freezemonsters.sprite;

import freezemonsters.FreezeMonsterCommons;
import spriteframework.sprite.BadSprite;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

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
        
        Random generator = new Random();
        int direction = 1+generator.nextInt(7);
        setShotDirection(direction);
        
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/images/gosma.png"));
        Image scaledImage = ii.getImage().getScaledInstance(30, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        setImage(scaledIcon.getImage());
    }
    
    //HomeGui
    private int shotDirection;
    
    public void setShotDirection(int shotDirection) {
    	this.shotDirection = shotDirection;
    }
    
    public int getShotDirection() {
    	return this.shotDirection;
    }

    @Override
    public void act() {
        if (!this.isDestroyed()) {
            int shotDirection = this.getShotDirection();

            if(shotDirection == 1) {
                this.setY(this.getY() - 1);
                this.setX(this.getX() - 1);
            }
            if(shotDirection == 2) {
                this.setY(this.getY() - 1);
            }
            if(shotDirection == 3) {
                this.setY(this.getY() - 1);
                this.setX(this.getX() + 1);
            }
            if(shotDirection == 4) {
                this.setX(this.getX() - 1);
            }
            if(shotDirection == 5) {
                this.setX(this.getX() + 1);
            }
            if(shotDirection == 6) {
                this.setY(this.getY() + 1);
                this.setX(this.getX() - 1);
            }
            if(shotDirection == 7) {
                this.setY(this.getY() + 1);
            }
            if(shotDirection == 8) {
                this.setY(this.getY() + 1);
                this.setX(this.getX() + 1);
            }

            if (this.getY() >= FreezeMonsterCommons.GROUND - FreezeMonsterCommons.SLIME_HEIGHT && this.getX() >= FreezeMonsterCommons.GROUND - FreezeMonsterCommons.SLIME_WIDTH) {
                this.setDestroyed(true);
            }
        }
    }
    
    
    
}
