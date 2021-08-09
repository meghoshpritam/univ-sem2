package Applet.SandClock;

import Applet.Utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

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

class Canvas extends JPanel implements ActionListener {
  private int off, elapsed;
  private final int tick;
  private final int h = 150;
  Timer t;

  public Canvas(int hh, int mm) {
    super();
    tick = ((hh * 3600 + mm * 60) * 1000) / h;
    t = new Timer(tick, this);
    t.start();
  }

  @Override
  public void paintComponent(Graphics g) {
    int x = 100, y = 30, w = 200;
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    g2.clearRect(x, y, w, h * 2 + 20);
    g2.setColor(Color.orange);

    GeneralPath polygon = new GeneralPath(GeneralPath.WIND_NON_ZERO, 4);

    polygon.moveTo(x, y);
    polygon.quadTo(x, h+30, w / 2+x, h+y);
    polygon.quadTo(x, h+y, x, h * 2+y);
    polygon.lineTo(w+x, h * 2+y);
    polygon.quadTo(w+x, h+y, w / 2+x, h+y);
    polygon.quadTo(w+x, h+y, w+x, y);
    polygon.closePath();

    
    Rectangle2D mask = new Rectangle2D.Double(x, y + off, w, h - off);
    Rectangle2D mask2 = new Rectangle2D.Double(x, y + 2 * h - off, w, off);
    
    Area a1 = new Area(mask);
    Area a2 = new Area(polygon);
    a2.intersect(a1);
    g2.fill(a2);

    a1 = new Area(mask2);
    a2 = new Area(polygon);
    a2.intersect(a1);
    g2.fill(a2);
    g2.setStroke(new BasicStroke(1));
    g2.setColor(new Color(0xDDDDDD));
    g2.draw(polygon);
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    off = off + 1;
    elapsed = elapsed + tick;
    repaint();

    if (off == h) {
      t.stop();
    }
  }
}