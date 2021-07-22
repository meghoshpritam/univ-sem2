package Applet.NationalFlag;

import java.applet.*;
import java.awt.*;

public class NationalFlag extends Applet {

  public void paint(Graphics fl) {
    Color c1 = new Color(255, 140, 0);
    Color c2 = new Color(139, 0, 0);
    
    fl.setColor(c2);
    fl.fillRect(250, 100, 5, 400);
    fl.setColor(Color.black);
    fl.drawRect(250, 100, 5, 400);
    
    fl.setColor(c1);
    fl.fillRect(255, 102, 180, 40);
    fl.setColor(Color.black);
    fl.drawRect(255, 102, 180, 40);

    fl.setColor(Color.WHITE);
    fl.fillRect(255, 142, 180, 40);
    fl.setColor(Color.black);
    fl.drawRect(255, 142, 180, 40);

    fl.setColor(Color.GREEN);
    fl.fillRect(255, 182, 180, 40);
    fl.setColor(Color.black);
    fl.drawRect(255, 182, 180, 40);
 
    Color c4 = new Color(173, 216, 230);
    setBackground(c4);

    int[] j = { 250, 245, 245, 225, 225, 280, 280, 260, 260, 255 };
    int[] k = { 500, 500, 505, 505, 515, 515, 505, 505, 500, 500 };
    fl.setColor(c2);
    fl.fillPolygon(j, k, 10);
    fl.setColor(Color.BLACK);
    fl.drawPolygon(j, k, 10);

    fl.setColor(Color.blue);
    fl.drawOval(325, 142, 39, 39);

    int n1 = 345;
    int d1 = 162;
    int r = 20;
    double n2, d2,angle, line = 0.0;
    
    for (int i = 1; i <= 24; i++) {
      angle = line * (3.14 / 180);
      n2 = n1 + (double) r * Math.cos(angle);
      d2 = d1 + (double) r * Math.sin(angle);
      fl.drawLine(n1, d1, (int) n2, (int) d2);
      line += 360 /(double) 24;
    }
  }
}