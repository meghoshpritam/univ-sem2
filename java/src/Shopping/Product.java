package Shopping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class Product {
  private final UUID id;
  private String name;
  private double price;
  private String description;
  private ArrayList<String> images;

  public Product(String name, double price, String description, String[] images) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.price = price;
    this.description = description;
    this.images = new ArrayList<String>();

    this.images.addAll(Arrays.asList(images));
  }

  public Product(String name, double price, String description) {
    this(name, price, description, new String[]{});
  }

  public Product(String name, double price, String description, String image) {
    this(name, price, description, new String[]{image});
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public String getDescription() {
    return description;
  }

  public ArrayList<String> getImages() {
    return images;
  }

  public String getImage() {
    if (this.images.size() < 1)
      return "";
    return images.get(0);
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setImages(ArrayList<String> images) {
    this.images = images;
  }
}
