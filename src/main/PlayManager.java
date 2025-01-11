package main;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class PlayManager {

  // MAIN PLAY AREA
  final int WIDTH = 360;
  final int HEIGHT = 600;
  public static int left_x;
  public static int right_x;
  public static int top_y;
  public static int bottom_y;
  Font maruMonica;

  public PlayManager() {

    // MAIN PLAY AREA FRAME
    left_x = (GamePanel.WIDTH / 2) - (WIDTH / 2); // 1280/2 - 360/2 = 460
    right_x = left_x + WIDTH;
    top_y = 50;
    bottom_y = top_y + HEIGHT;

    try { // ADDS CUSTOM FONT
      InputStream is = getClass().getClassLoader().getResourceAsStream("font/x12y16pxMaruMonica.ttf");
      maruMonica = Font.createFont(Font.TRUETYPE_FONT, is);
    } catch (FontFormatException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  public void update() {

  }

  public void draw(Graphics2D g2) {

    // DRAW PLAY AREA FRAME
    g2.setColor(Color.white); // SETS THE COLOR OF THE PLAY AREA FRAME
    g2.setStroke(new BasicStroke(4f)); // SETS THE THICKNESS OF THE STROKE
    g2.drawRect(left_x - 4, top_y - 4, WIDTH + 8, HEIGHT + 8); // DRAWS THE RECTANGLE OF OUR PLAY AREA, USING ABOVE METHODS FOR SIZE AND COLOR

    // DRAW FRAME FOR UPCOMING BLOCKS
    int x = right_x + 100; // Moves to the right along the x axis, based on the right_x placement
    int y = bottom_y - 200; // moves up along the y axis, based on the bottom_y placement
    g2.drawRect(x, y, 200, 200);


//    g2.setFont(new Font("Arial", Font.PLAIN, 30)); // SETS THE FONT USED, MIGHT USE THE 8BIT TEXT l8R
    g2.setFont(maruMonica); // SETS THE FONT, WE USE A CUSTOM 8BIT ONE
    g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30));
    g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    g2.drawString("NEXT", x + 60, y + 40); // DRAWS "NEXT" INSIDE THE BOX


  }
}
