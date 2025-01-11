package main;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {

    JFrame window = new JFrame("Simply Tetris"); // Creates the JFrame windows, with the parameters being the window name
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Will close the operation on exit
    window.setResizable(false); // Makes sure that the window CANNOT be resized

    GamePanel gp = new GamePanel(); // Calls upon our gamepanel, where everything happens
    window.add(gp); // adds the gamepanel to our windowbb
    window.pack();

    window.setLocationRelativeTo(null); // set to null
    window.setVisible(true); // shows the actual window


  }
}
