package Applet;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class Banner extends Applet implements Runnable {
  String msg = "Applet Scroll Banner Text ";
  Thread t = null;

  public void init() {
    setBackground(Color.DARK_GRAY);
    setForeground(Color.WHITE);
    t = new Thread(this);
    t.start();
  }

  public void run() {
    char ch;
    while (true) {
      try {
        repaint();
        Thread.sleep(200);
        ch = msg.charAt(0);
        msg = msg.substring(1);
        msg += ch;
      } catch (InterruptedException ignored) {
      }
    }
  }

  public void paint(Graphics graphics) {
    graphics.setColor(Color.white);
    graphics.setFont(new Font("TimesRoman", Font.BOLD, 25));
    graphics.drawString(msg, 30, 150);
  }
}