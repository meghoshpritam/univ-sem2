package Applet.Lists;

import java.awt.*;
import java.awt.event.*;

public class Lists {
  private final Frame mainFrame;
  private final Label status;
  private final Panel controlPanel;

  public Lists() {
    mainFrame = new Frame("Java AWT Examples");
    mainFrame.setSize(400, 400);
    mainFrame.setLayout(new GridLayout(3, 1));
    mainFrame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent windowEvent) {
        System.exit(0);
      }
    });
    status = new Label();
    status.setAlignment(Label.CENTER);
    status.setSize(350, 100);
    status.setText("My expertise");
    
    controlPanel = new Panel();
    controlPanel.setLayout(new FlowLayout());

    mainFrame.add(controlPanel);
    mainFrame.add(status);
    mainFrame.setVisible(true);
  }

  public static void main(String[] args) {
    Lists list = new Lists();
    list.showLists();
  }

  

  private void showLists() {
    final List languages = new List(5, true);

    languages.add("C");
    languages.add("C++");
    languages.add("Java");
    languages.add("Python");
    languages.add("Java Script");

    final List expertise = new List(3, false);

    expertise.add("Beginner");
    expertise.add("Intermediate");
    expertise.add("Expert");

    Button showButton = new Button("Submit");

    showButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        StringBuilder data = new StringBuilder("I am " + expertise.getItem(expertise.getSelectedIndex()) + " at ");
        for (String lang : languages.getSelectedItems()) {
          data.append(lang).append(" ");
        }
        status.setText(data.toString());
      }
    });

    controlPanel.add(languages);
    controlPanel.add(expertise);
    controlPanel.add(showButton);

    mainFrame.setVisible(true);
  }
}