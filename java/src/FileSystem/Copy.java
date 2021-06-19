package FileSystem;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Copy {
  public static void main(String args[]) {
    System.out.println(System.getProperty("user.dir"));
    try {
      FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/FileSystem/a.txt");

      BufferedInputStream input = new BufferedInputStream(file);

      int i = input.read();
      System.out.println("testing ... ");
      while (i != -1) {
        System.out.print((char) i);
        i = input.read();
      }

      input.close();
    } catch (Exception e) {
      System.out.println("error " + e.getMessage());
    }
  }
}
