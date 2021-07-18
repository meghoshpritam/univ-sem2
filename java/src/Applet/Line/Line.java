package Applet.Line;

import Applet.Utils;

import java.applet.Applet;
import java.awt.*;
import java.awt.geom.Line2D;

public class Line extends Applet {
  public void drawLine(Graphics graphics, Color color, int x1, int y1, int x2, int y2) {
    Graphics2D g2 = (Graphics2D) graphics;
    g2.setColor(color);
    g2.setStroke(new BasicStroke(5));
    g2.draw(new Line2D.Float(x1, y1, x2, y2));
  }

  public void paint(Graphics graphics) {
    setBackground(Color.WHITE);
    
    drawLine(graphics, Utils.primary, 10,20,490,20);
    drawLine(graphics, Utils.secondary, 10,40,490,40);
    drawLine(graphics, Utils.primaryDull, 10,60,490,60);
    drawLine(graphics, Utils.dark, 10,80,490,80);
    drawLine(graphics, Color.CYAN, 10,100,490,100);
    drawLine(graphics, Color.GREEN, 10,120,490,120);
    drawLine(graphics, Color.RED, 10,140,490,140);
    drawLine(graphics, Color.YELLOW, 10,160,490,160);
  }
}
