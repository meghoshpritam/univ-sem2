package Applet.RoundedRectangle;

import Applet.Utils;

import java.applet.Applet;
import java.awt.*;

public class Main extends Applet {
  public void drawRoundedRectangle(Graphics graphics, Color color, int x1, int y1, int x2, int y2) {
    Graphics2D g2 = (Graphics2D) graphics;
    g2.setColor(color);
    g2.setStroke(new BasicStroke(5));
    g2.drawRoundRect(x1,y1,x2,y2,50,50);
  } 

  public void paint(Graphics graphics) {
    setBackground(Color.WHITE);
    
    drawRoundedRectangle(graphics, Utils.primary, 20,50,465,350);
    
  }
}

/*
 * <applet code="Applet.RoundedRectangle.Main" width="500"
 * height="500"></applet>
 */