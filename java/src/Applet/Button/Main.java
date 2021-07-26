package Applet.Button;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

import Applet.Utils;

public class Main extends Applet implements ActionListener {
  Button button1, button2;
  Label status;

  public void init() {
    setLayout(new GridLayout(3, 2, 1, 1));
    Panel p1 = new Panel();
    p1.setLayout(new GridLayout(2, 1));

    button1 = new Button("Button 1");
    button1.setBackground(Utils.primary);
    button1.setForeground(Color.WHITE);
    button1.addActionListener(this);

    button2 = new Button("Button 2");
    button2.setBackground(Utils.dark);
    button2.setForeground(Color.WHITE);
    button2.addActionListener(this);

    p1.add(button1);
    p1.add(button2);
    status = new Label("");

    p1.add(status);
    add(p1);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button1) {
      status.setText("Button 1 was pressed");
      System.out.println("Button 1 was pressed");
    } else {
      status.setText("Button 2 was pressed");
      System.out.println("Button 2 was pressed");
    }
  }
}

// <applet code="Applet.Button.Main" width="500" height="500"></applet>