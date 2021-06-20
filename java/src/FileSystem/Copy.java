package FileSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Copy {
  private static void copyFile(String src, String dst) {
    File source;
    Scanner sourceScanner = null;
    FileWriter destination = null;

    try {
      source = new File(src);
      sourceScanner = new Scanner(source);
    } catch (IOException err) {
      System.out.println("Can't work with source file, " + err.getMessage());
    }
    try {
      destination = new FileWriter(dst);
    } catch (IOException err) {
      System.out.println("Can't work with destination file, " + err.getMessage());
    }
    try {
      while (true) {
        assert sourceScanner != null;
        if (!sourceScanner.hasNextLine()) break;
        assert destination != null;
        destination.write(sourceScanner.nextLine());
      }
      sourceScanner.close();
      assert destination != null;
      destination.close();
      System.out.println("Successfully file copy to ->, " + dst);
    } catch (IOException err) {
      System.out.println("Ann error occur, " + err.getMessage());
    }
  }
  
  
  public static void main(String[] args) {
    if (args.length == 1) {
      System.out.println("Destination file name missing!");
      return;
    }
    if (args.length == 2) {
      copyFile(args[0], args[1]);
      return;
    }
    if (args.length > 2) {
      System.out.println("too many arguments can't process the operation!");
      return;
    }
    
    Scanner scanner = new Scanner(System.in);
    System.out.println("Copy file");
    System.out.print("Enter source file location: ");
    String source = scanner.nextLine();
    System.out.print("Enter destination file location: ");
    String destination = scanner.nextLine();
    
    copyFile(source, destination);
  }
}
