package main;

import java.awt.*;

public class PlayManager {

  // MAIN PLAY AREA
  final int WIDTH = 360;
  final int HEIGHT = 600;
  public static int left_x;
  public static int right_x;
  public static int top_y;
  public static int bottom_y;

  public PlayManager() {

    // MAIN PLAY AREA FRAME
    left_x = (GamePanel.WIDTH / 2) - (WIDTH / 2); // 1280/2 - 360/2 = 460
    right_x = left_x + WIDTH;
    top_y = 50;
    bottom_y = top_y + HEIGHT;

  }
  public void update() {

  }
  public void draw(Graphics2D g2) {

    // DRAW PLAY AREA FRAME
    g2.setColor(Color.white); // SETS THE COLOR OF THE PLAY AREA FRAME
    g2.setStroke(new BasicStroke(4f)); // SETS THE THICKNESS OF THE STROKE
    g2.drawRect(left_x-4, top_y-4,WIDTH+8, HEIGHT+8); // DRAWS THE RECTANGLE OF OUR PLAY AREA, USING ABOVE METHODS FOR SIZE AND COLOR

    // DRAW FRAME FOR UPCOMING BLOCKS
    int x = right_x + 100; // Moves to the right along the x axis, based on the right_x placement
    int y = bottom_y - 200; // moves up along the y axis, based on the bottom_y placement
    g2.drawRect(x, y, 200, 200);
    g2.setFont(new Font("Arial", Font.PLAIN, 30)); // SETS THE FONT USED, MIGHT USE THE 8BIT TEXT l8R
    g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    g2.drawString("NEXT", x+60, y+60); // DRAWS "NEXT" INSIDE THE BOX
  }
}
