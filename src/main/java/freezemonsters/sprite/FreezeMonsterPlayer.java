package freezemonsters.sprite;

import freezemonsters.FreezeMonsterCommons;
import spriteframework.sprite.Player;

public class FreezeMonsterPlayer extends Player {


    public FreezeMonsterPlayer() {
        super("/images/woody.png", FreezeMonsterCommons.PLAYER_WIDTH,
                FreezeMonsterCommons.PLAYER_HEIGHT, FreezeMonsterCommons.INIT_PLAYER_X,
                FreezeMonsterCommons.INIT_PLAYER_Y);
        setSpeed(FreezeMonsterCommons.PLAYER_SPEED);
        setEnableY(true);
    }
}
