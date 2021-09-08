/* 
* Road Traffic System Using Packages and Interface
* */

package Exam.TrafficSystem;

import java.util.ArrayList;
import java.util.Scanner;

/*
Question's description scenario


lens 
    1
  2   3
    4
we have 4 len

only 1,4 have no issues
only 2,3 have no issues

if any car is in len 2 | 3 and 1 | 4 then we pass 1 | 4 and stop 2 | 3
*/

public class Main {
  private static final Scanner scanner = new Scanner(System.in);

  private static int getUserInputNumber() {
    String input = scanner.nextLine();
    return Integer.parseInt(input);
  }

  public static int getLen() {
    while (true) {
      System.out.println("Enter len [1 - 4]: ");
      int len = getUserInputNumber();
      if (len < 1 || len > 4) {
        System.out.println("Enter number between 1 to 4 only!");
      } else {
        return len;
      }
    }
  }

  public static void main(String[] args) {
    Len lens = new Len();
    System.out.println("Enter total cars: ");
    int loop = getUserInputNumber();

    // get the lens
    while (loop > 0) {
      int len = getLen();
      lens.addLen(len);
      loop -= 1;
    }

    // all the cars in all lens
    ArrayList<Integer> cars = lens.getLens();


    boolean collision = false;
    for (Integer car : cars) {
      if (car == 3 || car == 2) {
        collision = true;
        break;
      }
    }

    if (collision) {
      cars.forEach(car -> {
        if (car == 2 || car == 3) {
          System.out.println("Release car from len: " + car);
        }
      });

      cars.forEach(car -> {
        if (car == 1 || car == 4) {
          System.out.println("Release car from len: " + car);
        }
      });
    } else {
      for (Integer car : cars) {
        System.out.println("Release car from len: " + car);
      }
    }

    scanner.close();
  }
}