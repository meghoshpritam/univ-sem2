package Applet.NightSky;

/*<applet code='Applet.NightSky.Main' height=500 width=800></applet>*/

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Main extends Applet  {
  public void init() {
    this.setBackground(Color.BLACK);
  }

  public void paint(Graphics g) {
    {
      int i = 0;
      while (i < 1000) {
        int appletWidth = getSize().width;
        int appletHeight = getSize().height;
        int x = (int) (Math.random() * appletWidth);
        int y = (int) (Math.random() * appletHeight);

        g.setColor(Color.WHITE);
        g.fillOval(x, y, 1, 1);

        i++;
      }
    }

    {
      int appletWidth = getSize().width;
      int appletHeight = getSize().height;
      int x = (int) (Math.random() * appletWidth - 30);
      int y = (int) (Math.random() * appletHeight - 50);
      g.setColor(Color.WHITE);
      g.fillOval(x, y, 30, 30);
      g.setColor(Color.BLACK);
      g.fillOval(x + 7, y + 3, 30, 30);
    }

//    {
//      int appletWidth = getSize().width;
//      int appletHeight = getSize().height;
//      int x = (int) (Math.random() * appletWidth);
//      int y = (int) (Math.random() * appletHeight);
//      double draw = Math.random();
//      if (draw < 0.3) {
//        g.setColor(Color.RED);
//        g.fillOval(x, y, 3, 3);
//      }
//    }

    {
      int appletWidth = getSize().width;
      int appletHeight = getSize().height;
      int x = (int) (Math.random() * appletWidth - 20);
      int y = (int) (Math.random() * appletHeight - 50);
      double draw = Math.random();
      if (draw < 0.1) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y + 1, 4, 4);
        g.fillOval(x + 44, y + 1, 4, 4);
        g.setColor(Color.GRAY);
        g.fillOval(x + 14, y - 6, 20, 12);
        g.fillOval(x, y, 48, 8);
        g.setColor(Color.BLACK);
        g.fillOval(x + 16, y - 4, 16, 6);
        g.setColor(Color.GREEN);
        g.fillOval(x + 18, y - 2, 3, 3);
        g.fillOval(x + 26, y - 2, 3, 3);
      }
    }

//    {
//      int column = 0;
//      int appletWidth = getSize().width;
//      int horizonHeight = 50;
//      int appletHeight = getSize().height;
//      while (column < appletWidth) {
//        g.setColor(new Color(.53f, .76f, .34f));
//        g.drawRect(column, (appletHeight - horizonHeight), 1, appletHeight);
//
//        column++;
//        horizonHeight = horizonHeight + (int) (Math.random() * 3 - 1.5);
//      }
//    }
  }
}