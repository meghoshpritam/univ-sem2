package Applet.SandClock;

import Applet.Utils;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Main extends JFrame {
  public static void main(String[] args) {
    new Main();
  }

  public Main() {
    EventQueue.invokeLater(() -> {
      Canvas c = new Canvas(0, 3);
      setContentPane(c);
      pack();
      setSize(400, 400);
      setBackground(Utils.dark);
      setLocationRelativeTo(null);
      setVisible(true);
    });
  }
}
