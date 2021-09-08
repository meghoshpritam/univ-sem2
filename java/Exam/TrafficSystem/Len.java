package Exam.TrafficSystem;

import java.util.ArrayList;


public class Len implements LenI {
    private final ArrayList<Integer> lens;

    public Len() {
    this.lens = new ArrayList<Integer>();
  }

    public void addLen(int number) {
        lens.add(number);
    }

    public ArrayList<Integer> getLens() {
        return lens;
    }

    public void removeLen(int index) {
        lens.remove(index);
    }
}
