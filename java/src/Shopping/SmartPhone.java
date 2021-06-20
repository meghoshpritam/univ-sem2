package Shopping;

import java.util.ArrayList;

public class SmartPhone extends Mobile {
  private int ram;
  private String processor;
  private int core;
  private String screenType;
  private String operatingSystem;

  public SmartPhone(String name, double price, String description, String[] images, String manufactureYear,
                    String origin, int screenSize, boolean externalMemory, String inTheBox, int ram, String processor,
                    int core, String screenType, String operatingSystem) {
    super(name, price, description, images, manufactureYear, origin, screenSize, externalMemory, inTheBox);
    this.ram = ram;
    this.processor = processor;
    this.core = core;
    this.screenType = screenType;
    this.operatingSystem = operatingSystem;
  }

  public void setRam(int ram) {
    this.ram = ram;
  }

  public void setProcessor(String processor) {
    this.processor = processor;
  }

  public void setCore(int core) {
    this.core = core;
  }

  public void setScreenType(String screenType) {
    this.screenType = screenType;
  }

  public void setOperatingSystem(String operatingSystem) {
    this.operatingSystem = operatingSystem;
  }
}
