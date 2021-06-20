package Shopping;

import java.util.Calendar;

public class Mobile extends Product {
  private String manufactureYear;
  private String origin;
  private int screenSize;
  private boolean externalMemory;
  private String inTheBox;

  public Mobile(String name, double price, String description, String[] images, String manufactureYear, String origin,
                int screenSize, boolean externalMemory, String inTheBox) {
    super(name, price, description, images);
    this.manufactureYear = manufactureYear;
    this.origin = origin;
    this.screenSize = screenSize;
    this.externalMemory = externalMemory;
    this.inTheBox = inTheBox;
  }

  public Mobile(String name, double price, String description, String[] images) {
    this(name, price, description, images, String.valueOf(Calendar.getInstance().get(Calendar.YEAR)), "India",
      0, false, "The mobile 1U");
  }

  public Mobile(String name, double price, String description, String image) {
    this(name, price, description, new String[]{image});
  }

  public Mobile(String name, double price, String description) {
    this(name, price, description, new String[]{});
  }

  public String getManufactureYear() {
    return manufactureYear;
  }

  public String getOrigin() {
    return origin;
  }

  public int getScreenSize() {
    return screenSize;
  }

  public boolean isExternalMemory() {
    return externalMemory;
  }

  public String getInTheBox() {
    return inTheBox;
  }

  public void setManufactureYear(String manufactureYear) {
    this.manufactureYear = manufactureYear;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public void setScreenSize(int screenSize) {
    this.screenSize = screenSize;
  }

  public void setExternalMemory(boolean externalMemory) {
    this.externalMemory = externalMemory;
  }

  public void setInTheBox(String inTheBox) {
    this.inTheBox = inTheBox;
  }
}
