package Applet.CheckBoxChoice;

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

import Applet.Utils;

public class CheckBoxChoice extends Applet implements ItemListener {
  Checkbox c1, c2, c3;
  Label l;

  public void init() {
    setLayout(new GridLayout(3, 2, 1, 1));
    Panel p1 = new Panel();
    Panel p2 = new Panel();
    p1.setLayout(new GridLayout(3, 1));
    p2.setLayout(new GridLayout(1, 2));

    c1 = new Checkbox("Checkbox 1");
    p1.add(c1);
    c1.addItemListener(this);
    c2 = new Checkbox("Checkbox 2");
    p1.add(c2);
    c2.addItemListener(this);
    c3 = new Checkbox("CheckBox 3");
    p1.add(c3);
    c3.addItemListener(this);
    l = new Label("");
    p2.add(l);

    add(p1);
    add(p2);
  }

  public void itemStateChanged(ItemEvent e) {
    c1.setForeground(Utils.dark);
    c2.setForeground(Utils.dark);
    c3.setForeground(Utils.dark);

    String selected = "";
    if (c1.getState()) {
      selected += "1";
      c1.setForeground(Utils.primary);
    }
    if (c2.getState()) {
      if (!selected.isEmpty())
        selected += ", ";
      selected += "2";
      c2.setForeground(Utils.primary);
    }
    if (c3.getState()) {
      if (!selected.isEmpty())
        selected += ", ";
      selected += "3";
      c3.setForeground(Utils.primary);
    }
    selected += " Checkbox selected";
    l.setText(selected);
  }
}

// <applet code="Applet.CheckBoxChoice.CheckBoxChoice" width="500"
// height="500"></applet>