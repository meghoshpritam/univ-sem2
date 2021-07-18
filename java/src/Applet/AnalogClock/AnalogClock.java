package Applet.AnalogClock;

import Applet.Utils;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.*;
import java.applet.Applet;

public class AnalogClock extends Applet implements Runnable {
  int width, height;
  Thread t = null;
  boolean threadSuspended;
  int hours = 0, minutes = 0, seconds = 0;

  public void init() {
    width = getSize().width - 20;
    height = getSize().height - 20;
    setBackground(Utils.dark);
  }

  public void start() {
    if (t == null) {
      t = new Thread(this);
      t.setPriority(Thread.MIN_PRIORITY);
      threadSuspended = false;
      t.start();
    } else {
      if (threadSuspended) {
        threadSuspended = false;
        synchronized (this) {
          notify();
        }
      }
    }
  }

  public void stop() {
    threadSuspended = true;
  }

  public void run() {
    try {
      while (true) {

        Calendar cal = Calendar.getInstance();
        hours = cal.get(Calendar.HOUR_OF_DAY);
        if (hours > 12)
          hours -= 12;
        minutes = cal.get(Calendar.MINUTE);
        seconds = cal.get(Calendar.SECOND);


        if (threadSuspended) {
          synchronized (this) {
            while (threadSuspended) {
              wait();
            }
          }
        }
        repaint();
        Thread.sleep(1000);
      }
    } catch (Exception ignored) {
    }
  }

  void drawHand(double angle, int radius, Graphics g) {
    angle -= 0.5 * Math.PI;
    int x = (int) (radius * Math.cos(angle));
    int y = (int) (radius * Math.sin(angle));
    drawLine(g, Color.WHITE, 3, width / 2, height / 2, width / 2 + x, height / 2 + y);
    drawCircle(g, Color.WHITE, 8, width / 2, height / 2, 8, 8);
  }

  void drawWedge(double angle, int radius, Graphics g) {
    angle -= 0.5 * Math.PI;
    int x = (int) (radius * Math.cos(angle));
    int y = (int) (radius * Math.sin(angle));
    angle += 2 * Math.PI / 3;
    int x2 = (int) (5 * Math.cos(angle));
    int y2 = (int) (5 * Math.sin(angle));
    angle += 2 * Math.PI / 3;
    int x3 = (int) (5 * Math.cos(angle));
    int y3 = (int) (5 * Math.sin(angle));

    drawLine(g, Utils.primary, 7, width / 2 + x2, height / 2 + y2, width / 2 + x, height / 2 + y);
    drawLine(g, Utils.primary, 7, width / 2 + x3, height / 2 + y3, width / 2 + x, height / 2 + y);
    drawLine(g, Utils.primary, 7, width / 2 + x2, height / 2 + y2, width / 2 + x3, height / 2 + y3);
  }

  public void drawLine(Graphics graphics, Color color, int width, int x1, int y1, int x2, int y2) {
    Graphics2D g2 = (Graphics2D) graphics;
    g2.setColor(color);
    g2.setStroke(new BasicStroke(width));
    g2.draw(new Line2D.Float(x1, y1, x2, y2));
  }

  public void drawCircle(Graphics graphics, Color color, int width, int x1, int y1, int x2, int y2) {
    Graphics2D g2 = (Graphics2D) graphics;
    g2.setColor(color);
    g2.setStroke(new BasicStroke(width));
    g2.draw(new Ellipse2D.Float(x1, y1, x2, y2));
  }

  public void paint(Graphics graphics) {
    drawWedge(2 * Math.PI * hours / 12, (int) (width / 5.2), graphics);
    drawWedge(2 * Math.PI * minutes / 60, (int) (width / 3.5), graphics);
    drawHand(2 * Math.PI * seconds / 60, width / 3, graphics);
    drawCircle(graphics, Utils.secondary, 4, (int) (width * 0.1), (int) (width * 0.1), (int) (width * 0.8), (int) (width * 0.8));
  }
}
