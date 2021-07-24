class Helloworld {
  public native void Hello();

  static {
    System.loadLibrary("Helloworld");
  }

  public native void send(String a);

  public static void main(String[] args) {
    new Helloworld().Hello();
    new Helloworld().send("100010101010231310231023");
  }
}
