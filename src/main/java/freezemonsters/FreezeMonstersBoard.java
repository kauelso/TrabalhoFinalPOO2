package freezemonsters;

import freezemonsters.sprite.FreezeMonsterMonster;
import freezemonsters.sprite.FreezeMonsterPlayer;
import freezemonsters.sprite.FreezeMonsterSlime;
import freezemonsters.FreezeMonsterCommons;
import spriteframework.AbstractBoard;
import spriteframework.Commons;
import spriteframework.sprite.BadSprite;
import spriteframework.sprite.Player;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;

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
            if (y <= 10) y = 11;
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

        if (deaths == FreezeMonsterCommons.MONSTER_AMOUNT) {

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
        
        //Slime
        updateOtherSprites();
    }
    
    @Override
    protected void processOtherSprites(Player player, KeyEvent e) {
    	
    }


    protected void updateOtherSprites() {
    	Random generator = new Random();
    	
        for (BadSprite alien : badSprites) {

            int shot = generator.nextInt(15);
            FreezeMonsterSlime bomb = ((FreezeMonsterMonster)alien).getSlime();
            
            if (shot == Commons.CHANCE && alien.isVisible() && bomb.isDestroyed()) {

                bomb.setDestroyed(false);
                bomb.setX(alien.getX());
                bomb.setY(alien.getY());
            }

            int bombX = bomb.getX();
            int bombY = bomb.getY();
            int playerX = players.get(0).getX();
            int playerY = players.get(0).getY();

            if (players.get(0).isVisible() && !bomb.isDestroyed()) {

                if (bombX >= (playerX)
                        && bombX <= (playerX + FreezeMonsterCommons.PLAYER_WIDTH)
                        && bombY >= (playerY)
                        && bombY <= (playerY + FreezeMonsterCommons.PLAYER_HEIGHT)) {

                    players.get(0).setDying(true);
                    bomb.setDestroyed(true);
                }
            }
            
            updateBadSpriteShot(bomb);

//            if (!bomb.isDestroyed()) {
//
//                bomb.setY(bomb.getY() + 1);
//
//                if (bomb.getY() >= Commons.GROUND - Commons.BOMB_HEIGHT) {
//
//                    bomb.setDestroyed(true);
//                }
//            }
        }
	}
    
    
    //HomeGui
    protected void updateBadSpriteShot(FreezeMonsterSlime bomb) {
    	if (!bomb.isDestroyed()) {
    		int shotDirection = bomb.getShotDirection();
    		
    		if(shotDirection == 1) {
    			bomb.setY(bomb.getY() - 1);
    			bomb.setX(bomb.getX() - 1);
    		}
    		if(shotDirection == 2) {
    			bomb.setY(bomb.getY() - 1);
    		}
    		if(shotDirection == 3) {
    			bomb.setY(bomb.getY() - 1);
    			bomb.setX(bomb.getX() + 1);
    		}
    		if(shotDirection == 4) {
    			bomb.setX(bomb.getX() - 1);
    		}
    		if(shotDirection == 5) {
    			bomb.setX(bomb.getX() + 1);
    		}
    		if(shotDirection == 6) {
    			bomb.setY(bomb.getY() + 1);
    			bomb.setX(bomb.getX() - 1);
    		}
    		if(shotDirection == 7) {
    			bomb.setY(bomb.getY() + 1);
    		}
    		if(shotDirection == 8) {
    			bomb.setY(bomb.getY() + 1);
    			bomb.setX(bomb.getX() + 1);
    		}

            if (bomb.getY() >= FreezeMonsterCommons.GROUND - FreezeMonsterCommons.SLIME_HEIGHT && bomb.getX() >= FreezeMonsterCommons.GROUND - FreezeMonsterCommons.SLIME_WIDTH) {
                bomb.setDestroyed(true);
            }
        }
    }
    @Override
    protected Player createPlayer() {
        return new FreezeMonsterPlayer();
    }
}
