package Applet.DigitalClock;

import Applet.Utils;
import java.applet.Applet;
import java.awt.*;
import java.util.*;

public class DigitalClock extends Applet {
  public void init() {
    this.setSize(new Dimension(800, 400));
    setBackground(Utils.dark);
    new Thread(() -> {
      while (true) {
        repaint();
        delayAnimation();
      }
    }).start();
  }

  private void delayAnimation() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void display(int val, int pos, Graphics graphics) {
    graphics.setColor(Utils.primary);
    
    if ((val & 1) != 0)
      graphics.fillRect(pos, 150, 5, 50);

    if ((val & 2) != 0)
      graphics.fillRect(pos, 145, 50, 5);

    if ((val & 4) != 0)
      graphics.fillRect(pos + 45, 150, 5, 50);

    if ((val & 8) != 0)
      graphics.fillRect(pos + 45, 200, 5, 50);

    if ((val & 16) != 0)
      graphics.fillRect(pos, 250, 50, 5);

    if ((val & 32) != 0)
      graphics.fillRect(pos, 200, 5, 50);

    if ((val & 64) != 0)
      graphics.fillRect(pos + 5, 200, 40, 5);
  }

  public void paint(Graphics graphics) {
    int[] digits = new int[] { 63, 12, 118, 94, 77, 91, 123, 14, 127, 95 };

    Calendar time = Calendar.getInstance();
    int hour = time.get(Calendar.HOUR_OF_DAY);
    int minute = time.get(Calendar.MINUTE);
    int second = time.get(Calendar.SECOND);

    boolean am = true;
    if (hour > 12) {
      hour -= 12;
      am = false;
    }

    display(digits[hour / 10], 150, graphics);
    display(digits[hour % 10], 225, graphics);

    display(digits[minute / 10], 325, graphics);
    display(digits[minute % 10], 400, graphics);

    display(digits[second / 10], 500, graphics);
    display(digits[second % 10], 575, graphics);

    graphics.setFont(new Font("", Font.PLAIN, 30));
    if (am)
      graphics.drawString("am", 650, 250);
    else
      graphics.drawString("pm", 650, 250);

    graphics.fillRect(300, 175, 5, 5);
    graphics.fillRect(300, 225, 5, 5);

    graphics.fillRect(475, 175, 5, 5);
    graphics.fillRect(475, 225, 5, 5);

    graphics.setColor(Utils.primary);
  }
}
