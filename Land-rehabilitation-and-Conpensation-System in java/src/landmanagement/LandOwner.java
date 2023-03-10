
package landmanagement;
import java.util.Vector;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

class LandOwner extends Person {
  private String LandOwner_ID;
  private Address address;
  public Land land;
  static ArrayList<LandOwner> LandOwnerList = new ArrayList<LandOwner>(0);

  public static void main(String[] args) {
    LandOwnerList = LandOwner.addLandOwner();
  }

  public LandOwner() {

  }

  public LandOwner(Land land, String LandOwner_ID, String name, String phone_no) {
    this.LandOwner_ID = LandOwner_ID;
    this.setName(name);
    this.setPhone_no(phone_no);
    this.land = land;
  }

  public LandOwner(String LandOwner_ID, String name, String phone_no, Address address) {
    this.LandOwner_ID = LandOwner_ID;
    this.setName(name);
    this.setPhone_no(phone_no);
    this.address = address;
  }

  public String getLandOwner_ID() {
    return this.LandOwner_ID;
  }

  public void setLandOwner_ID(String LandOwner_ID) {
    this.LandOwner_ID = LandOwner_ID;
  }

  public Address getAddress() {
    return this.address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public static ArrayList<LandOwner> addLandOwner() {
    String option;
    do {
      System.out.print("\n\t\tWelcome, new user. Please fill the following form\n");
      Scanner input = new Scanner(System.in);
      System.out.print("\n\t\t+++ Form for new users +++\n");
      System.out.println("Enter Land owner ID: ");
      String LandOwner_ID = input.nextLine();
      System.out.println("Enter name: ");
      String LandOwnername = input.nextLine();
      System.out.println("Enter Land owner Phone number: ");
      String phone_no = input.nextLine();
      System.out.println("Enter Land Owner Address: ");
      System.out.println("Enter the region of the land owner ");
      String region = input.nextLine();
      System.out.println("Enter the zone of the land owner ");
      String zone = input.nextLine();
      System.out.println("Enter the wereda of the land owner ");
      String wereda = input.nextLine();
      System.out.println("Enter the kebele of the land owner ");
      String kebele = input.nextLine();
      Address A1 = new Address(region, zone, wereda, kebele);
      LandOwner m1 = new LandOwner(LandOwner_ID, LandOwnername, phone_no, A1);
      LandOwnerList.add(m1);
      System.out.println("Do you want to continue enter y/n");
      option = input.nextLine();
    } while (option.equalsIgnoreCase("y"));
    return LandOwnerList;
  }

  public static void displayLandOwners() {
    boolean flag = false;
    System.out.print("\t\t\tInformation about LandOwners \n");
    for (int i = 0; i < LandOwnerList.size(); i++) {
      flag = true;
      System.out.println("\n\t\tLand Owner.: " + (i + 1) + "\t");
      System.out.println("\t\t\tLandOwner ID: " + LandOwnerList.get(i).getLandOwner_ID() + "\t");
      System.out.println("\t\t\tLandOwner Name: " + LandOwnerList.get(i).getName() + "\t");
      System.out.println("\t\t\tPhone No.: " + LandOwnerList.get(i).getPhone_no() + "\t");
      LandOwnerList.get(i).address.display();
    }
    if (flag == false) {
      System.out.println("\n\t\t-- No Record Found --\n");
    }
    System.out.println("\n");
  }

  public static LandOwner searchLandOwner() {
    LandOwner searchedLandOwner = null;
    Scanner input = new Scanner(System.in);
    System.out.println("\t\t--- LandOwner Searching ---\n");
    System.out.println("Enter the LandOwner Name to search: ");
    String name = input.nextLine();
    boolean flag = false;
    for (int i = 0; i < LandOwnerList.size(); i++) {
      if (LandOwnerList.get(i).getName().equalsIgnoreCase(name) || LandOwnerList.get(i).getName().contains(name)) {
        searchedLandOwner = LandOwnerList.get(i);
      }
    }
    return searchedLandOwner;
  }

  public void displayLandOwner() {
    System.out.print("\tLandOwner ID: " + this.getLandOwner_ID() + "\t");
    System.out.print("\tLandOwner Name: " + this.getName() + "\t");
    System.out.print("\tPhone No.: " + this.getPhone_no() + "\t");

  }

  public static void deleteLandOwner() {
    Scanner input = new Scanner(System.in);
    System.out.println("\t\t--- LandOwner Deletion ---\n");
    System.out.println("Enter the LandOwner Name to delete: ");
    String name = input.nextLine();
    boolean flag = false;
    for (int i = 0; i < LandOwnerList.size(); i++) {
      if (LandOwnerList.get(i).getName().equalsIgnoreCase(name)) {
        LandOwnerList.remove(i);
        flag = true;
        System.out.println("\n*LandOwner DELETED SUCCESSFULLY*\n");
      }
    }
    if (flag == false)
      System.out.println("\n*LandOwner IS NOT FOUND*\n");

  }

  public static ArrayList<LandOwner> searchByAddress(String request) {
    boolean flag = false;
    ArrayList<LandOwner> notifiy = new ArrayList<LandOwner>(0);
    for (int i = 0; i < LandOwnerList.size(); i++) {
      flag = true;
      if (LandOwnerList.get(i).address.kebele.equalsIgnoreCase(request)) {
        notifiy.add(LandOwnerList.get(i));

      }

    }
    if (flag == false)
      System.out.println("No match landowner in this kebele");
    return notifiy;
  }

  public static void updateLandOwnerInfo() {
    Scanner input = new Scanner(System.in);
    System.out.println("\t\t--- Employee Searching ---\n");
    System.out.println("Enter the Employee Name to search: ");
    String name = input.nextLine();
    boolean flag = false;
    for (int i = 0; i < LandOwnerList.size(); i++) {

      if (LandOwnerList.get(i).getName().equalsIgnoreCase(name) || LandOwnerList.get(i).getName().contains(name)) {
        System.out.print("\n\t\t+++ Form for update employee +++\n");
        System.out.println("Enter employee ID: ");
        LandOwnerList.get(i).LandOwner_ID = input.nextLine();
        System.out.println("Enter employee name : ");
        LandOwnerList.get(i).setName(input.nextLine());
        System.out.println("Enter employee Phone number: ");
        LandOwnerList.get(i).setPhone_no(input.nextLine());
        System.out.println("Enter the region of the land owner ");
        LandOwnerList.get(i).address.region = input.nextLine();
        System.out.println("Enter the zone of the land owner ");
        LandOwnerList.get(i).address.zone = input.nextLine();
        System.out.println("Enter the wereda of the land owner ");
        LandOwnerList.get(i).address.wereda = input.nextLine();
        System.out.println("Enter the kebele of the land owner ");
        LandOwnerList.get(i).address.kebele = input.nextLine();
        flag = true;
      }
    }
    if (flag == false)
      System.out.println("There is no match record");
  }
}