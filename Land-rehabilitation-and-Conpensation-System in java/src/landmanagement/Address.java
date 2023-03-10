package landmanagement;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

import java.util.Scanner;

public class Address {

  public String region;

  public String zone;

  public String wereda;

  public String kebele;

  public Address() {

  }

  public Address(String region, String zone, String wereda, String kebele) {
    this.region = region;
    this.zone = zone;
    this.wereda = wereda;
    this.kebele = kebele;
  }

  public void display() {
    System.out.println("\n\n\t\t\t\t---Address infomation---");
    System.out.println("\t\t\tRegion : " + this.region);
    System.out.println("\t\t\tZone : " + this.zone);
    System.out.println("\t\t\tWereda : " + this.wereda);
    System.out.println("\t\t\tkebele : " + this.kebele);
  }

  

  public Address getAddress() {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the region of the land  ");
    region = input.nextLine();
    System.out.println("Enter it's zone: ");
    zone = input.nextLine();
    System.out.println("Enter its wereda: ");
    wereda = input.nextLine();
    System.out.println("Enter its kebele: ");
    kebele = input.nextLine();
    Address address = new Address();
    address = new Address(region, zone, wereda, kebele);
    return address;
  }

}