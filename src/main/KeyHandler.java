package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener { // implementing KeyListener requires 3 methods to be added see @Override in this class;

  public static boolean upPressed, downPressed, leftPressed, rightPressed;

  @Override
  public void keyTyped(KeyEvent e) { // idk man, not used in this game

  }

  @Override
  public void keyPressed(KeyEvent e) { // checks when key is pressed

    int code = e.getKeyCode(); // e.getkeycode() detects when a key is pressed, but need keyevent.___ to assign a key usage

    if (code == KeyEvent.VK_W) { // assigns W key for up
      upPressed = true;
    }
    if (code == KeyEvent.VK_A) { // assigns A key for left
      leftPressed = true;
    }
    if (code == KeyEvent.VK_S) { // assigns S key for down
      downPressed = true;
    }
    if (code == KeyEvent.VK_D) { // assigns D key for right
      rightPressed = true;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) { // checks when key is released

  }
}
