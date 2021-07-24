package Applet.ChildFrame;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

class AnotherFrame extends Frame {
  AnotherFrame(String title) {
    super(title);
    WinAdapter adapter = new WinAdapter(this);
    addWindowListener(adapter);
  }

  public void paint(Graphics g) {
    g.drawString("This is in frame window", 200, 100);
  }
}


class WinAdapter extends WindowAdapter {
  AnotherFrame sampleFrame;

  public WinAdapter(AnotherFrame sampleFrame) {
    this.sampleFrame = sampleFrame;
  }

  public void windowClosing(WindowEvent we) {
    sampleFrame.setVisible(false);
  }
}


public class Main extends Applet {
  Frame f;

  public void init() {
    f = new AnotherFrame("A Frame Window");
    f.setSize(500, 500);
    f.setVisible(true);
  }

  public void start() {
    f.setVisible(true);
  }

  public void stop() {
    f.setVisible(false);
  }

  public void paint(Graphics g) {
    g.drawString("This is in applet window", 10, 20);
  }
}

/* <applet code="Applet.ChildFrame.Main" width=500 height=500> </applet> */