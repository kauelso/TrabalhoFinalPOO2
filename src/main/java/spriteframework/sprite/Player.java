package spriteframework.sprite;

import javax.swing.ImageIcon;

import spriteframework.Commons;

import java.awt.Image;
import java.awt.event.KeyEvent;

public class Player extends Sprite {

    private String imagePath;
    private Boolean enableY;
    private int dy;

    private int speed = 2;
    private int init_x;
    private int init_y;

    public int getSpeed() {
        return speed;
    }

    public void setEnableY(Boolean enableY){this.enableY = enableY;}

    public void setSpeed(int speed) {
        this.speed = speed;
    }



    public Player(String path, int width,int height,int init_x, int init_y) {
        this.imagePath = path;
        this.init_x = init_x;
        this.init_y = init_y;
        setEnableY(false);
        loadImage(width,height);
		getImageDimensions();
		resetState();
    }

    protected void loadImage (int w, int h) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(imagePath));
        Image scaledImage = ii.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        setImage(scaledIcon.getImage());
    }

    public void act() {
        moveX(dx);
        moveY(dy);

        if (x <= 2) {

            x = 2;
        }

        if (y <= 2) {

            y = 2;
        }

        if (x >= Commons.BOARD_WIDTH - 2 * getImageWidth()) {

            x = Commons.BOARD_WIDTH - 2 * getImageWidth();
        }
        if (y >= Commons.BOARD_HEIGHT - 2 * getImageHeight()) {

            y = Commons.BOARD_HEIGHT - 2 * getImageHeight();
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = -1 * speed;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = speed;
        }

        if (key == KeyEvent.VK_UP && enableY) {

            dy = -1 * speed;
        }

        if (key == KeyEvent.VK_DOWN && enableY) {

            dy = speed;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 0;
        }
        if (key == KeyEvent.VK_UP && enableY) {

            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN && enableY) {

            dy = 0;
        }
    }
    private void resetState() {

        setX(init_x);
        setY(init_y);
    }
}
