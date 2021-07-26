package Applet.DifferentShapes;

import Applet.Utils;

import java.applet.Applet;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Main extends Applet {
  public void drawLine(Graphics graphics, Color color, int x1, int y1, int x2, int y2) {
    Graphics2D g2 = (Graphics2D) graphics;
    g2.setColor(color);
    g2.setStroke(new BasicStroke(5));
    g2.draw(new Line2D.Float(x1, y1, x2, y2));
  }

  public void drawRoundedRectangle(Graphics graphics, Color color, int x1, int y1, int x2, int y2) {
    Graphics2D g2 = (Graphics2D) graphics;
    g2.setColor(color);
    g2.setStroke(new BasicStroke(5));
    g2.drawRoundRect(x1, y1, x2, y2, 50, 50);
  }

  public void drawCircle(Graphics graphics, Color color, int x1, int y1, int x2, int y2) {
    Graphics2D g2 = (Graphics2D) graphics;
    g2.setColor(color);
    g2.setStroke(new BasicStroke(5));
    g2.draw(new Ellipse2D.Float(x1, y1, x2, y2));
  }

  public void drawTriangle(Graphics graphics, Color color, int x1, int y1, int x2, int y2, int x3, int y3) {
    Graphics2D g2 = (Graphics2D) graphics;
    g2.setColor(color);
    g2.setStroke(new BasicStroke(5));
    g2.draw(new Polygon(new int[] { x1, x2, x3 }, new int[] { y1, y2, y3 }, 3));
  }

  public void paint(Graphics graphics) {
    setBackground(Color.WHITE);

    drawLine(graphics, Utils.primary, 20, 20, 370, 20);
    drawRoundedRectangle(graphics, Utils.primaryDull, 70, 50, 300, 350);
    drawCircle(graphics, Utils.secondary, 100, 100, 200, 200);
    drawTriangle(graphics, Color.GREEN, 205, 110, 265, 265, 140, 265);
  }
}

// <applet code="Applet.DifferentShapes.Main" width="500"
// height="500"></applet>