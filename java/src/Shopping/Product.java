package Shopping;

import java.util.ArrayList;
import java.util.Arrays;

public class Product {
  private String name;
  private double price;
  private String description;
  private ArrayList<String> images;

  public Product(String name, double price, String description, String[] images) {
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
