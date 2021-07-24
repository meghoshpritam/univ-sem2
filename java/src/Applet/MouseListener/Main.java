package Applet.MouseListener;

import Applet.Utils;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends Applet implements MouseListener {
  public void init() {
    addMouseListener(this);
    setBackground(Utils.dark);
    setSize(500, 500);
    setLayout(null);
    setVisible(true);
  }

  public void mouseClicked(MouseEvent e) {
    Graphics graphics = getGraphics();
    graphics.setColor(Utils.primary);
    graphics.fillOval(e.getX(), e.getY(), 7, 7);
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

  public void mousePressed(MouseEvent e) {
  }

  public void mouseReleased(MouseEvent e) {
  }
}

/* <applet code="Applet.MouseListener.Main" width="500" height="500"></applet> */