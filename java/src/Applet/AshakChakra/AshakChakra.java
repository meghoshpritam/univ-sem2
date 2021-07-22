package Applet.AshakChakra;

import java.applet.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;

public class AshakChakra extends Applet {
  public void drawLine(Graphics graphics, int x1, int y1, int x2, int y2) {
    Graphics2D g2 = (Graphics2D) graphics;
    g2.setColor(Color.blue);
    g2.setStroke(new BasicStroke(5));
    g2.draw(new Line2D.Float(x1, y1, x2, y2));
  }


  public void drawCircle(Graphics graphics, int x1, int y1, int x2, int y2) {
    Graphics2D g2 = (Graphics2D) graphics;
    g2.setColor(Color.blue);
    g2.setStroke(new BasicStroke(5));
    g2.draw(new Ellipse2D.Float(x1, y1, x2, y2));
  }

  public void paint(Graphics graphics) {
    graphics.setColor(Color.blue);
    drawCircle(graphics, 100, 80, 400, 400);

    int n1 = 300;
    int d1 = 280;
    int r = 200;
    double n2, d2, angle, line = 0.0;

    for (int i = 1; i <= 24; i++) {
      angle = line * (3.14 / 180);
      n2 = n1 + (double) r * Math.cos(angle);
      d2 = d1 + (double) r * Math.sin(angle);
      drawLine(graphics, n1, d1, (int) n2, (int) d2);
      line += 360 / (double) 24;
    }
  }
}

/*
 * <applet code="Applet.AshakChakra.AshakChakra" width="600"
 * height="600"></applet>
 */