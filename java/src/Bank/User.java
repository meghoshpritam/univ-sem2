package Bank;

import java.util.UUID;

public class User {
  private final int consumerNumber;
  private String name;
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String state;
  private String country;
  private String pinCode;
  private String identityTyp;
  private String identityDoc;
  private String email;
  private String phone;

  public User(int consumerNumber, String name, String addressLine1, String addressLine2, String city, String state, String country,
              String pinCode, String identityTyp, String identityDoc, String email, String phone) {
    this.consumerNumber = consumerNumber;
    this.name = name;
    this.addressLine1 = addressLine1;
    this.addressLine2 = addressLine2;
    this.city = city;
    this.state = state;
    this.country = country;
    this.pinCode = pinCode;
    this.identityTyp = identityTyp;
    this.identityDoc = identityDoc;
    this.email = email;
    this.phone = phone;
  }

  public User(int consumerNumber, String name, String city, String state, String country, String pinCode, String email, String phone) {
    this(consumerNumber, name, "", "", city, state, country, pinCode, "", "", email, phone);
  }

  public String getName() {
    return name;
  }

  public String getAddressLine1() {
    return addressLine1;
  }

  public String getAddressLine2() {
    return addressLine2;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getCountry() {
    return country;
  }

  public String getPinCode() {
    return pinCode;
  }

  public String getIdentityTyp() {
    return identityTyp;
  }

  public String getIdentityDoc() {
    return identityDoc;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public int getConsumerNumber() {
    return consumerNumber;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setPinCode(String pinCode) {
    this.pinCode = pinCode;
  }

  public void setIdentityTyp(String identityTyp) {
    this.identityTyp = identityTyp;
  }

  public void setIdentityDoc(String identityDoc) {
    this.identityDoc = identityDoc;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
