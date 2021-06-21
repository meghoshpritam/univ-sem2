package FileSystem;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class VowelConsonant {
  private static void count(String file) {
    File source;
    Scanner sourceScanner = null;
    try {
      source = new File(file);
      sourceScanner = new Scanner(source);
    } catch (IOException err) {
      System.out.println("Can't work with the file, " + err.getMessage());
    }
    try {
      int vowel = 0;
      int length = 0;
      int consonant = 0;
      while (true) {
        assert sourceScanner != null;
        if (!sourceScanner.hasNextLine()) break;

        String line = sourceScanner.nextLine().toLowerCase();
        length += line.length();

        for (int idx = 0; idx < line.length(); idx += 1) {
          char ch = line.charAt(idx);

          if (Character.isAlphabetic(ch))
            consonant += 1;
          if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            vowel += 1;
        }
      }
      System.out.println("Number of character is: " + length);
      System.out.println(vowel + " vowel present in the file, " + file);
      System.out.println(consonant + " consonant present in the file, " + file);
    } catch (Exception err) {
      System.out.println("An error occur, " + err.getMessage());
    }
  }

  public static void main(String[] args) {
    if (args.length == 1) {
      count(args[0]);
      return;
    }
    
    if (args.length > 1) {
      System.out.println("too many arguments can't process the operation!");
      return;
    }

    Scanner scanner = new Scanner(System.in);
    System.out.println("Count the vowel of file");
    System.out.print("Enter source file location: ");
    String source = scanner.nextLine();
    
    count(source);
    scanner.close();
  }
}
