package freezemonsters.sprite;

import freezemonsters.FreezeMonsterCommons;
import spriteframework.Commons;
import spriteframework.sprite.BadSprite;
import spriteframework.sprite.BadnessBoxSprite;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class FreezeMonsterMonster extends BadnessBoxSprite {
    private FreezeMonsterSlime slime;
    private int directionX = 0;
    private int directionY = 0;

    public FreezeMonsterMonster(int x, int y){
        initFreezeMonster(x,y);
        getImageDimensions();
    }

    private void initFreezeMonster(int x, int y){
        Random generator = new Random();
        this.x = x;
        this.y = y;

        int monsterDirectionX = generator.nextInt(2);
        int monsterDirectionY = generator.nextInt(2);
        if(monsterDirectionX == 1) this.directionX = 1; else this.directionX = -1;
        if(monsterDirectionY == 1) this.directionY = 1; else this.directionY = -1;

        slime = new FreezeMonsterSlime(x,y);

        int monsterNumber = generator.nextInt(9) + 1;

        ImageIcon ii = new ImageIcon(this.getClass().getResource("/images/monster" + monsterNumber + ".png"));
        Image scaledImage = ii.getImage().getScaledInstance(FreezeMonsterCommons.MONSTER_WIDTH, FreezeMonsterCommons.MONSTER_HEIGHT, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        setImage(scaledIcon.getImage());
    }

    public FreezeMonsterSlime getSlime(){
        return slime;
    }

    @Override
    public LinkedList<BadSprite> getBadnesses() {
        LinkedList<BadSprite> slimes = new LinkedList<BadSprite>();
        slimes.add(slime);
        return slimes;
    }

    @Override
    public void act() {
        moveX(directionX);
        moveY(directionY);

        if (x <= 2) {

            x = 2;
            directionX = directionX * (-1);
        }

        if (y <= 2) {

            y = 2;
            directionY = directionY * (-1);
        }

        if (x >= Commons.BOARD_WIDTH - 2 * getImageWidth()) {
            x = Commons.BOARD_WIDTH - 2 * getImageWidth();
            directionX = directionX * (-1);
        }
        if (y >= Commons.BOARD_HEIGHT - 2 * getImageHeight()) {
            y = Commons.BOARD_HEIGHT - 2 * getImageHeight();
            directionY = directionY * (-1);
        }
    }

    @Override
    public void moveX(int direction) {
        this.setX(this.x + (direction * FreezeMonsterCommons.MONSTER_SPEED));
    }

    @Override
    public void moveY(int direction) {
        this.setY(this.y + (direction * FreezeMonsterCommons.MONSTER_SPEED));
    }
}
