package mino;

import main.KeyHandler;
import main.PlayManager;

import java.awt.*;

public class Mino {

  public Block b[] = new Block[4];
  public Block tempB[] = new Block[4];
public int direction = 1; // there are 4 direction (1/2/3/4)

  // COUNTER
  int autoDropCounter = 0;

  public void create(Color c) {

    b[0] = new Block(c);
    b[1] = new Block(c);
    b[2] = new Block(c);
    b[3] = new Block(c);
    tempB[0] = new Block(c);
    tempB[1] = new Block(c);
    tempB[2] = new Block(c);
    tempB[3] = new Block(c);
  }

  public void setXY(int x, int y) {}
  public void updateXY(int direction) {

    this.direction = direction;
    b[0].x = tempB[0].x;
    b[0].y = tempB[0].y;
    b[1].x = tempB[1].x;
    b[1].y = tempB[1].y;
    b[2].x = tempB[2].x;
    b[2].y = tempB[2].y;
    b[3].x = tempB[3].x;
    b[3].y = tempB[3].y;
  }
  public getDirection1() {}
  public getDirection2() {}
  public getDirection3() {}
  public getDirection4() {}

  public void update() {

    // CONTROL THE MINO
    if (KeyHandler.upPressed) {

    }
    if (KeyHandler.downPressed) {
      b[0].y += Block.SIZE;
      b[1].y += Block.SIZE;
      b[2].y += Block.SIZE;
      b[3].y += Block.SIZE;

      // When moved down, reset the autodropcounter
      autoDropCounter = 0;

      KeyHandler.downPressed = false;
    }
    if (KeyHandler.leftPressed) {

      b[0].x -= Block.SIZE;
      b[1].x -= Block.SIZE;
      b[2].x -= Block.SIZE;
      b[3].x -= Block.SIZE;

      KeyHandler.leftPressed = false;
    }
    if (KeyHandler.rightPressed) {
      b[0].x += Block.SIZE;
      b[1].x += Block.SIZE;
      b[2].x += Block.SIZE;
      b[3].x += Block.SIZE;

      KeyHandler.rightPressed = false;
    }

    autoDropCounter++; // increases this integer every update
    if (autoDropCounter == PlayManager.dropInterval) { // when drop counter is equal to the drop interval
      // mino goes down a notch
      b[0].y += Block.SIZE;
      b[1].y += Block.SIZE;
      b[2].y += Block.SIZE;
      b[3].y += Block.SIZE; // Moves blocks down the y-axis;
      autoDropCounter = 0; // resets the drop counter back to zero, to reach the next interval

    }

  }

  public void draw(Graphics2D g2) {

    int margin = 1; // variable used make the blocks slightly smaller to create visible seams between each block in a mino
    g2.setColor(b[0].c);
    g2.fillRect(b[0].x, b[0].y, Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
    g2.fillRect(b[1].x, b[1].y, Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
    g2.fillRect(b[2].x, b[2].y, Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
    g2.fillRect(b[3].x, b[3].y, Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
  }
}
