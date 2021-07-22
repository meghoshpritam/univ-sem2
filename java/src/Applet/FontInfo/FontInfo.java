package Applet.FontInfo;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class FontInfo extends Applet implements ActionListener {
  Button submit;
  TextArea input, output;
  StringBuffer strBuff;
  URL url;

  public void init() {
    setLayout(new GridLayout(3, 2, 1, 1));
    Panel p1 = new Panel();
    Panel p2 = new Panel();
    p1.setLayout(new GridLayout(2, 2));
    p2.setLayout(new GridLayout(1, 2));

    input = new TextArea();
    output = new TextArea();
    submit = new Button("Submit");

    p1.add(input);
    p1.add(submit);
    p2.add(output);

    submit.addActionListener(this);

    add(p1);
    add(p2);
  }

  public String readFile(String fileToRead) {
    String line;

    try {
      url = new URL(getCodeBase(), fileToRead);
    } catch (MalformedURLException err) {
      return err.getMessage();
    }
    try {
      InputStream in = url.openStream();
      BufferedReader bf = new BufferedReader(new InputStreamReader(in));
      strBuff = new StringBuffer();
      while ((line = bf.readLine()) != null) {
        strBuff.append(line).append("\n");
      }
      
      return strBuff.toString();
    } catch (IOException e) {
      return e.getMessage();
    }
  }

  public void checkFont(String text) {
    String fontName = "\n Font name: ";
    if (Font.getFont(text) == null)
      fontName += "Default font";
    else
      fontName += Font.getFont(text);
    
    System.out.println(fontName);
    System.out.println(text);
    output.setText(text + fontName);
  }

  public void actionPerformed(ActionEvent e) {
    try {
      if (e.getSource() == submit) {
        System.out.println("called!");
        checkFont(readFile(input.getText()));
      }
    } catch (Exception err) {
      System.out.println(err.getMessage());
      output.setText(err.getMessage());
    }
  }
}

/* <applet code="Applet.FontInfo.FontInfo" width="500" height="500"></applet> */