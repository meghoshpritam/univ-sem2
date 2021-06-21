package Shopping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

public class Main {
  private static final Scanner scanner = new Scanner(System.in);

  private static String getUserInput() {
    return scanner.nextLine();
  }

  private static String getUserInput(String message) {
    System.out.print(message);
    return getUserInput();
  }

  private static int getUserInputInt() {
    int input = scanner.nextInt();
    scanner.nextLine();
    return input;
  }

  private static int getUserInputInt(String message) {
    System.out.print(message);
    return getUserInputInt();
  }

  private static double getUserInputDouble() {
    double input = scanner.nextDouble();
    scanner.nextLine();
    return input;
  }

  private static double getUserInputDouble(String message) {
    System.out.print(message);
    return getUserInputDouble();
  }

  private static Laptop getLaptop(ArrayList<Laptop> laptops, UUID laptopId) {
    ArrayList<Laptop> laptopNew = (ArrayList<Laptop>) laptops.stream().filter(laptop -> laptop.getId()
      .equals(laptopId)).collect(Collectors.toList());
    if (laptopNew.size() < 1) {
      return null;
    }
    return laptopNew.get(0);
  }

  private static SmartPhone getMobile(ArrayList<SmartPhone> phones, UUID phoneId) {
    ArrayList<SmartPhone> phonesNew = (ArrayList<SmartPhone>) phones.stream().filter(phone -> phone.getId()
      .equals(phoneId)).collect(Collectors.toList());
    if (phonesNew.size() < 1) {
      return null;
    }
    return phonesNew.get(0);
  }

  private static UUID stringToUUID(String id) {
    try {
      return UUID.fromString(id);
    } catch (Exception ignored) {
      System.out.println("Invalid id!");
      return null;
    }
  }

  private static void operation(ArrayList<Laptop> laptops, ArrayList<SmartPhone> smartPhones) {
    System.out.println("Welcome to our store");
    System.out.println("We are dealing with smartphones and laptops");

    boolean loop = true;

    while (loop) {
      System.out.println("\n\n====================================================");
      System.out.println("1. check available mobiles");
      System.out.println("2. check available laptops");
      System.out.println("3. check mobile details");
      System.out.println("4. check laptop details");
      System.out.println("5. add new laptop");
      System.out.println("6. add new mobile");
      System.out.println("7. delete a mobile");
      System.out.println("8. delete a laptop");
      System.out.println("9. exit");
      int option = getUserInputInt("Enter your option: ");
      System.out.println("----------------------------------------------------------");

      switch (option) {
        case 1: {
          if (smartPhones.size() < 1) {
            System.out.println("No mobile phone available");
            break;
          }
          System.out.println("Available mobiles are:");
          for (SmartPhone mobile : smartPhones) {
            System.out.println("Phone ID: " + mobile.getId());
            System.out.println("Phone Name: " + mobile.getName());
            System.out.println("Phone Price: " + mobile.getPrice());
          }
          break;
        }
        case 2: {
          if (laptops.size() < 1) {
            System.out.println("No laptop available");
            break;
          }
          System.out.println("Available laptop are:");
          for (Laptop laptop : laptops) {
            System.out.println("Laptop ID: " + laptop.getId());
            System.out.println("Laptop Name: " + laptop.getName());
            System.out.println("Laptop Price: " + laptop.getPrice());
          }
          break;
        }
        case 3: {
          String mobileId = getUserInput("Enter mobile id: ");

          if (stringToUUID(mobileId) != null) {
            SmartPhone phone = getMobile(smartPhones, stringToUUID(mobileId));
            if (phone == null) {
              System.out.println("Invalid mobile id!");
              break;
            }
            System.out.println("Phone ID: " + phone.getId());
            System.out.println("Phone name: " + phone.getName());
            System.out.println("Phone description: " + phone.getDescription());
            System.out.println("Phone image: " + phone.getImage());
            System.out.println("Phone box details : " + phone.getInTheBox());
            System.out.println("Phone manufacture year : " + phone.getManufactureYear());
            System.out.println("Phone ram : " + phone.getRam());
            System.out.println("Phone ram : " + phone.getProcessor());
          }
          break;
        }
        case 4: {
          String laptopId = getUserInput("Enter laptop id: ");

          if (stringToUUID(laptopId) != null) {
            Laptop laptop = getLaptop(laptops, stringToUUID(laptopId));
            if (laptop == null) {
              System.out.println("Invalid laptop id!");
              break;
            }
            System.out.println("Laptop ID: " + laptop.getId());
            System.out.println("Laptop name: " + laptop.getName());
            System.out.println("Laptop description: " + laptop.getDescription());
            System.out.println("Laptop price: " + laptop.getPrice());
            System.out.println("Laptop image: " + laptop.getImage());
            System.out.println("Laptop storage : " + laptop.getStorage());
            System.out.println("Laptop ram : " + laptop.getRam());
            System.out.println("Laptop processor : " + laptop.getProcessor());
          }
          break;
        }
        case 5: {
          String name = getUserInput("Enter laptop name: ");
          String description = getUserInput("Enter laptop description: ");
          double price = getUserInputDouble("Enter laptop price: ");
          int ram = getUserInputInt("Enter laptop Ram in GB: ");
          String processor = getUserInput("Enter laptop processor: ");
          String storage = getUserInput("Enter laptop storage: ");
          int battery = getUserInputInt("Enter laptop battery: ");
          Laptop laptop = new Laptop(name, price, description, new String[]{}, battery, ram, processor,
            false, false, storage);
          laptops.add(laptop);
          System.out.println(laptop.getId() + " laptop successfully added");
          break;
        }
        case 6: {
          String name = getUserInput("Enter mobile Name: ");
          String description = getUserInput("Enter mobile description: ");
          double price = getUserInputDouble("Enter mobile price: ");
          String mfy = getUserInput("Enter mobile manufacturing year: ");
          int ram = getUserInputInt("Enter mobile Ram in GB: ");
          int screen = getUserInputInt("Enter mobile screen size: ");
          int core = getUserInputInt("Enter mobile core: ");
          String processor = getUserInput("Enter mobile processor: ");
          String screenType = getUserInput("Enter mobile screen type: ");
          String os = getUserInput("Enter mobile operating system: ");
          SmartPhone mobile = new SmartPhone(name, price, description, new String[]{}, mfy, "", screen, 
            false, "", ram, processor, core, screenType, os);
          ;
          smartPhones.add(mobile);
          System.out.println(mobile.getId() + " mobile successfully added");
          break;
        }
        case 7: {
          String mobileId = getUserInput("Enter mobile id: ");
          SmartPhone mobile = getMobile(smartPhones, UUID.fromString(mobileId));
          smartPhones.removeIf(phone -> phone.getId().equals(UUID.fromString(mobileId)));
          System.out.println(mobileId + "mobile remove successfully");
          break;
        }
        case 8: {
          String laptopId = getUserInput("Enter laptop id: ");
          SmartPhone laptop = getMobile(smartPhones, UUID.fromString(laptopId));
          laptops.removeIf(laptop1 -> laptop1.getId().equals(UUID.fromString(laptopId)));
          System.out.println(laptopId + "laptop remove successfully");
          break;
        }
        case 9:
          System.out.println("Thank you");
          loop = false;
          break;
        default:
          System.out.println("You enter an invalid option!");
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<Laptop> laptops = new ArrayList<Laptop>();
    ArrayList<SmartPhone> smartPhones = new ArrayList<SmartPhone>();

    try {
      operation(laptops, smartPhones);
    } catch (Exception err) {
      System.out.println("An error occur! " + err.getMessage() + Arrays.toString(err.getStackTrace()));
    }

    scanner.close();
  }
}
