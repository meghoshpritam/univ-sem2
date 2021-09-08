package Applet.KeyBoardListener;

import java.awt.Color;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

class Utils {
  public static Color primary = Color.decode("#F70776");
  public static Color primaryDull = Color.decode("#C3195D");
  public static Color secondary = Color.decode("#680747");
  public static Color dark = Color.decode("#141010");

  
}

public class Main extends Applet implements KeyListener, MouseListener {
  Label l;
  TextArea area;

  public void init() {
    l = new Label();
    l.setBounds(20, 50, 200, 20);
    area = new TextArea();
    area.setBounds(20, 80, 300, 300);
    area.addKeyListener(this);

    addMouseListener(this);
    setBackground(Utils.dark);
    setSize(500, 500);
    setLayout(null);
    setVisible(true);

    add(l);
    add(area);
    setSize(400, 400);
    setLayout(null);
    setVisible(true);
  }

  public void keyPressed(KeyEvent e) {
  }

  public void keyReleased(KeyEvent e) {
    String text = area.getText();
    String[] words = text.split("\\s");
    l.setText("Words: " + words.length + " Characters:" + text.length());
  }

  public void keyTyped(KeyEvent e) {
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

/*
 * <applet code="Applet.KeyBoardListener.Main" width="500"
 * height="500"></applet>
 */