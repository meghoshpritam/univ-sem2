public class HelloJNI {
    static {
        System.loadLibrary("hello"); // load libhello.so
    }

    private native void sayHello();

    public static void main(String[] args) {
        new HelloJNI().sayHello();
    }
}