package Applet.Menu;

import java.awt.*;
import java.awt.event.*;

public class Main extends Frame {
  MenuBar mb = new MenuBar();
  Label label = new Label(" ");
  private static Dialog d;

  public static void main(String[] args) {
    new Main();
  }

  public Main() {
    super("Demonstration of Menus");
    Panel panel = new Panel();
    panel.add(label);
    add("Center", panel);
    addWindowListener(new WindowEventHandler());
    menudetails();
    setMenuBar(mb);
    pack();
    setSize(400, 400);
    show();

    Frame f = new Frame();
    d = new Dialog(f, "Dialog Example", true);
    d.setLayout(new FlowLayout());
    Button b = new Button("OK");
    b.addActionListener(e -> Main.d.setVisible(false));
    d.add(new Label("Click button to continue."));
    d.add(b);
    d.setSize(300, 300);
    d.setVisible(false);
  }

  void menudetails() {
    Menu fmenu = new Menu("File");
    Menu emenu = new Menu("Edit");
    Menu hmenu = new Menu("Help");
    Menu dmenu = new Menu("Dialog");
    
    MenuItem newfitem = new MenuItem("New");
    MenuItem exitfitem = new MenuItem("Exit");
    fmenu.add(newfitem);
    fmenu.addSeparator();
    fmenu.add(exitfitem);
    
    MenuItem cuteitem = new MenuItem("Cut");
    MenuItem copyitem = new MenuItem("Copy");
    MenuItem pasteitem = new MenuItem("Paste");
    CheckboxMenuItem refreshitem = new CheckboxMenuItem("Refresh", true);
    emenu.add(cuteitem);
    emenu.add(copyitem);
    emenu.add(pasteitem);
    emenu.addSeparator();
    emenu.add(refreshitem);
    
    Menu sendmenu = new Menu("Send To");
    MenuItem drivesitem = new MenuItem("Send to Drive");
    MenuItem deskitem = new MenuItem("send to Desktop");
    sendmenu.add(drivesitem);
    sendmenu.add(deskitem);
    emenu.add(sendmenu);
    
    MenuItem abouthitem = new MenuItem("About");
    hmenu.add(abouthitem);
    
    MenuItem dialogItem = new MenuItem("Open Dialog");
    dmenu.add(dialogItem);
    
    mb.add(fmenu);
    mb.add(emenu);
    mb.add(hmenu);
    mb.add(dmenu);
    
    Menuhandler mh = new Menuhandler();
    newfitem.addActionListener(mh);
    exitfitem.addActionListener(mh);
    cuteitem.addActionListener(mh);
    copyitem.addActionListener(mh);
    pasteitem.addActionListener(mh);
    refreshitem.addActionListener(mh);
    drivesitem.addActionListener(mh);
    deskitem.addActionListener(mh);
    abouthitem.addActionListener(mh);
    dialogItem.addActionListener(mh);
  }

  class Menuhandler implements ActionListener, ItemListener {
    public void actionPerformed(ActionEvent e) {
      String s = e.getActionCommand();
      label.setText(s);
      validate();
      if (s.equals("Open Dialog")) d.setVisible(true);
      if (s.equals("Exit")) System.exit(0);
    }

    public void itemStateChanged(ItemEvent e) {
      CheckboxMenuItem
        item = (CheckboxMenuItem) e.getItemSelectable();
      String status;
      if (item.getState()) status = "You checked:";
      else status = "you unchecked";
      status += item.getLabel();
      label.setText(status);
      validate();
    }
  }

  static class WindowEventHandler extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
      System.exit(0);
    }
  }
}

/* <applet code="Applet.Menu.Main" width="300" height="200"> </applet> */