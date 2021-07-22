package Applet.NationalFlag;


import java.applet.Applet;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.*;

//import javax.swing.JFrame;
  
public class NationalFlag extends Applet {
  //Main Method
//  public static void main(String[] args)
//  {
//    Flag i =new Flag();
//  }

  //Costructor 
//  public Flag()
//  {
//    setSize(1400, 750);
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    setLayout(null);
//    setVisible(true);
//  }

  //Flag design 
  public void paint(Graphics g)
  {
    Color saffron = new Color(255, 128, 0);
    g.setColor(saffron);
    g.fillRect(0, 0, 1400, 250);

    g.setColor(Color.white);
    g.fillRect(0, 250, 1400, 250);

    g.setColor(Color.BLUE);
    g.drawOval(600, 250, 250, 250);

    g.setColor(Color.green);
    g.fillRect(0, 500, 1400, 250);

    //Author :
    g.setFont(new Font("", Font.BOLD, 15));
    g.setColor(Color.RED);
    g.drawString("@shivesh", 1250, 700);

    // Ashoka Chakra design : All 24 spokes will display one after one 
    int x = 600, y = 250;
    int w = 250, h = 250;
    int start = 90, arc = 5;

    for (int i = 1; i <= 24; i++)
    {
      try
      {
        g.setColor(Color.BLUE);
        g.fillArc(x, y, w, h, start, arc);
        Thread.sleep(100);
        start += 15;

      }
      catch (InterruptedException ex)
      {
        System.out.println(ex);
      }
    }

        /*
        Code to print texts on Flag :
        The text will appear with the mix color of Red and Yellow giving it an animated look.
         .........
        INDIA will be displayed in the centre of Saffron body.
        JAI & HIND will be displayed on the Left & Right side of the Ashok chakra respectively at White body.
        */
    for (int i = 0; i < 10; i++)
    {
      try
      {
        g.setFont(new Font("", Font.BOLD, 100));
        g.setColor(Color.red);
        g.drawString("INDIA", 575, 190);
        Thread.sleep(300);
        g.setColor(Color.yellow);
        g.drawString("INDIA", 575, 190);
        Thread.sleep(300);
        g.setColor(Color.YELLOW);
        g.drawString("JAI", 250, 410);
        g.drawString("HIND", 1000, 410);
        Thread.sleep(200);
        g.setColor(Color.RED);
        g.drawString("JAI", 250, 410);
        g.drawString("HIND", 1000, 410);
        Thread.sleep(300);
      }
      catch (InterruptedException ex)
      {
        System.out.println(ex);
      }
    }

  }

}