package Applet.CheckList;

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

import Applet.Utils;

public class CheckLists extends Applet implements ItemListener {
  Checkbox cb1, cb2, cb3;
  CheckboxGroup cbg1;
  Label l;

  public void init() {
    setLayout(new GridLayout(3, 2, 1, 1));
    Panel p1 = new Panel();
    p1.setLayout(new GridLayout(2, 1));

    cbg1 = new CheckboxGroup();
    cb1 = new Checkbox("Check Box 1", cbg1, true);
    cb2 = new Checkbox("Check Box 2", cbg1, false);
    cb3 = new Checkbox("Check Box 3", cbg1, false);

    l = new Label(cb1.getLabel() + " selected");

    p1.add(cb1);
    p1.add(cb2);
    p1.add(cb3);
    p1.add(l);

    cb1.setForeground(Utils.primary);
    cb1.setForeground(Utils.dark);
    cb1.setForeground(Utils.dark);

    cb1.addItemListener(this);
    cb2.addItemListener(this);
    cb3.addItemListener(this);

    add(p1);
  }

  public void itemStateChanged(ItemEvent e) {
    System.out.println(cbg1.getSelectedCheckbox());
    if (cbg1.getSelectedCheckbox() == cb1) {
      cb1.setForeground(Utils.primary);
      cb2.setForeground(Utils.dark);
      cb3.setForeground(Utils.dark);
      l.setText(cb1.getLabel() + " selected");
    } else if (cbg1.getSelectedCheckbox() == cb2) {
      cb1.setForeground(Utils.dark);
      cb2.setForeground(Utils.primary);
      cb3.setForeground(Utils.dark);
      l.setText(cb2.getLabel() + " selected");
    } else if (cbg1.getSelectedCheckbox() == cb3) {
      cb1.setForeground(Utils.dark);
      cb2.setForeground(Utils.dark);
      cb3.setForeground(Utils.primary);
      l.setText(cb3.getLabel() + " selected");
    }
  }
} 