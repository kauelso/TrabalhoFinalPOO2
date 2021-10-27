package freezemonsters;

import spaceinvaders.SpaceInvadersGame;
import spriteframework.AbstractBoard;
import spriteframework.MainFrame;

import java.awt.*;

public class FreezeMonsterGame extends MainFrame {
    public FreezeMonsterGame() {
        super("Freeze Monsters", FreezeMonsterCommons.BOARD_WIDTH, FreezeMonsterCommons.BOARD_HEIGHT);
    }

    @Override
    protected AbstractBoard createBoard() {
        return new FreezeMonstersBoard();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            new FreezeMonsterGame();
        });
    }
}
