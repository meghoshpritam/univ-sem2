package Applet.Button;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

import Applet.Utils;

public class Buttons extends Applet implements ActionListener {
  public void init() {
    button1 = new Button("Button 1");
    button1.setBackground(Utils.dark);
    button1.setForeground(Color.WHITE);
    add(button1);
    button1.addActionListener(this);

    button2 = new Button("Button 2");
    button2.setBackground(Utils.dark);
    button2.setForeground(Color.WHITE);
    add(button2);
    button2.addActionListener(this);
    
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button1)
      System.out.println("Button 1 was pressed");
    else
      System.out.println("Button 2 was pressed");
  }

  Button button1, button2;
}