package Shopping;

public class Laptop extends Product {
  private int batteryCapacity;
  private int ram;
  private String processor;
  private boolean graphics;
  private boolean camera;
  private String storage;

  public Laptop(String name, double price, String description, String[] images, int batteryCapacity, int ram,
                String processor, boolean graphics, boolean camera, String storage) {
    super(name, price, description, images);
    this.batteryCapacity = batteryCapacity;
    this.ram = ram;
    this.processor = processor;
    this.graphics = graphics;
    this.camera = camera;
    this.storage = storage;
  }

  public Laptop(String name, double price, String description, String[] images) {
    this(name, price, description, images, 0, 0, "", false, false, "");
  }

  public Laptop(String name, double price, String description, String image) {
    this(name, price, description, new String[]{image});
  }

  public Laptop(String name, double price, String description) {
    this(name, price, description, new String[]{});
  }

  public int getBatteryCapacity() {
    return batteryCapacity;
  }

  public void setBatteryCapacity(int batteryCapacity) {
    this.batteryCapacity = batteryCapacity;
  }

  public int getRam() {
    return ram;
  }

  public void setRam(int ram) {
    this.ram = ram;
  }

  public String getProcessor() {
    return processor;
  }

  public void setProcessor(String processor) {
    this.processor = processor;
  }

  public boolean isGraphics() {
    return graphics;
  }

  public void setGraphics(boolean graphics) {
    this.graphics = graphics;
  }

  public boolean isCamera() {
    return camera;
  }

  public void setCamera(boolean camera) {
    this.camera = camera;
  }

  public String getStorage() {
    return storage;
  }

  public void setStorage(String storage) {
    this.storage = storage;
  }
}
