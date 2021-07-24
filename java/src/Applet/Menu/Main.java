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
    menuDetails();
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

  void menuDetails() {
    Menu fMenu = new Menu("File");
    Menu eMenu = new Menu("Edit");
    Menu hMenu = new Menu("Help");
    Menu dMenu = new Menu("Dialog");
    
    MenuItem newFItem = new MenuItem("New");
    MenuItem exitFItem = new MenuItem("Exit");
    fMenu.add(newFItem);
    fMenu.addSeparator();
    fMenu.add(exitFItem);
    
    MenuItem cuteItem = new MenuItem("Cut");
    MenuItem copyItem = new MenuItem("Copy");
    MenuItem pasteItem = new MenuItem("Paste");
    CheckboxMenuItem refreshItem = new CheckboxMenuItem("Refresh", true);
    eMenu.add(cuteItem);
    eMenu.add(copyItem);
    eMenu.add(pasteItem);
    eMenu.addSeparator();
    eMenu.add(refreshItem);
    
    Menu sendMenu = new Menu("Send To");
    MenuItem drivesItem = new MenuItem("Send to Drive");
    MenuItem deskItem = new MenuItem("send to Desktop");
    sendMenu.add(drivesItem);
    sendMenu.add(deskItem);
    eMenu.add(sendMenu);
    
    MenuItem aboutHItem = new MenuItem("About");
    hMenu.add(aboutHItem);
    
    MenuItem dialogItem = new MenuItem("Open Dialog");
    dMenu.add(dialogItem);
    
    mb.add(fMenu);
    mb.add(eMenu);
    mb.add(hMenu);
    mb.add(dMenu);
    
    MenuHandler mh = new MenuHandler();
    newFItem.addActionListener(mh);
    exitFItem.addActionListener(mh);
    cuteItem.addActionListener(mh);
    copyItem.addActionListener(mh);
    pasteItem.addActionListener(mh);
    refreshItem.addActionListener(mh);
    drivesItem.addActionListener(mh);
    deskItem.addActionListener(mh);
    aboutHItem.addActionListener(mh);
    dialogItem.addActionListener(mh);
  }

  class MenuHandler implements ActionListener, ItemListener {
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