package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

  public static final int WIDTH = 1280; // sets our games window width
  public static final int HEIGHT = 720; // sets the games window height
  final int FPS = 60;
  Thread gameThread; // threads are necessary for games
  PlayManager pm;

  public GamePanel() {


    // PANEL SETTINGS
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    this.setBackground(Color.BLACK); // sets background to black
    this.setLayout(null);

    pm = new PlayManager();
  }

  public void launchGame() {
    gameThread = new Thread(this);
    gameThread.start(); // calls upon the run() method, to start the loop
  }

  @Override
  public void run() {

    // GAME LOOP
    double drawInterval = 1000000000 / FPS; // nanoseconds (1 second in reality) divided by our desired frame per second
    double delta = 0;
    long lastTime = System.nanoTime(); // returns accurate of the system timer, basically always counts our nanoseconds
    long currentTime;

    while (gameThread != null) {
      currentTime = System.nanoTime();

      delta += (currentTime - lastTime) / drawInterval;
      lastTime = currentTime;
      if (delta >= 1) {
        update(); // calls the update method
        repaint(); // despite not being the same name, is actually using the paintComponent() method to repaint the contents for each frame
        delta--;
      }
    }


  }

  public void update() { // method being called every frame to update the current game context

    pm.update();
  }

  public void paintComponent(Graphics g) { // Is used to get and draw the images we need for our game
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D)g;
    pm.draw(g2);
  }
}
