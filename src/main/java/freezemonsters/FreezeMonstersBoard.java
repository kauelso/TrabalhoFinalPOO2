package freezemonsters;

import freezemonsters.sprite.FreezeMonsterMonster;
import freezemonsters.sprite.FreezeMonsterPlayer;
import spaceinvaders.Commons;
import spriteframework.AbstractBoard;
import spriteframework.sprite.BadSprite;
import spriteframework.sprite.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class FreezeMonstersBoard extends AbstractBoard {
    private int deaths = 0;

    public FreezeMonstersBoard() {
        super(FreezeMonsterCommons.BOARD_WIDTH, FreezeMonsterCommons.BOARD_HEIGHT, Color.CYAN);
    }


    @Override
    protected void createBadSprites() {
        Random generator = new Random();
        int x;
        int y;
        for(int i = 0; i<FreezeMonsterCommons.MONSTER_AMOUNT; i++){
            x = generator.nextInt(FreezeMonsterCommons.BOARD_WIDTH - FreezeMonsterCommons.MONSTER_WIDTH);
            y = generator.nextInt(FreezeMonsterCommons.BOARD_HEIGHT - FreezeMonsterCommons.MONSTER_HEIGHT);
            if (x <= 10) x = 11;
            if (y<= 10) y = 11;
            FreezeMonsterMonster monster = new FreezeMonsterMonster(x,y);
            badSprites.add(monster);
        }

    }

    @Override
    protected void createOtherSprites() {

    }

    @Override
    protected void drawOtherSprites(Graphics g) {

    }

    @Override
    protected void update() {

        if (deaths == Commons.NUMBER_OF_ALIENS_TO_DESTROY) {

            inGame = false;
            timer.stop();
            message = "Game won!";
        }

        // player
        for (Player player: players)
            player.act();

        //Monsters
        for(BadSprite monster: badSprites){
            monster.act();
        }

    }

    @Override
    protected void processOtherSprites(Player player, KeyEvent e) {

    }

    @Override
    protected Player createPlayer() {
        return new FreezeMonsterPlayer();
    }
}
