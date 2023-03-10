
package landmanagement;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Crop {
  private String CropName;
  private int quantity;
  private float currentPrice;
  private float preservationExpense;

  // static ArrayList<Crop> CropList = new ArrayList<Crop>(0);

  public Crop() {

  }


  public Crop(String CropName, int quantity, float currentPrice, float preservationExpense) {
    this.CropName = CropName;
    this.quantity = quantity;
    this.currentPrice = currentPrice;
    this.preservationExpense = preservationExpense;
  }

  public Crop(Crop Crop) {
    this.CropName = Crop.CropName;
    this.quantity = Crop.quantity;
    this.currentPrice = Crop.currentPrice;
    this.preservationExpense = Crop.preservationExpense;
  }

  public String getCropName() {
    return this.CropName;
  }

  public void setCropName(String CropName) {
    this.CropName = CropName;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public float getcurrentPrice() {
    return this.currentPrice;
  }

  public void setcurrentPrice(float currentPrice) {
    this.currentPrice = currentPrice;
  }

  public float getPreservationExpense() {
    return this.preservationExpense;
  }

  public void setPreservationExpense(float preservationExpense) {
    this.preservationExpense = preservationExpense;
  }

  public void display() {
    System.out.println("\tCrop Name: " + this.CropName);
    System.out.println("\t\tCrop currentPrice : " + this.currentPrice);
    System.out.println("\t\tQuintal per hectar: " + this.quantity);
    System.out.println("\t\tPreservation Expense: " + this.preservationExpense);
  }

  public static void displayAllCrops(ArrayList<Crop> CropList) {
    boolean flag = false;
    int increment;
    System.out.println("\t\t\tAll Crops in the Land \n");
    for (int i = 0; i < CropList.size(); i++) {
      flag = true;
      System.out.println("\t\tCrop Name: " + CropList.get(i).CropName);
      System.out.print("\tCrop currentPrice : " + CropList.get(i).currentPrice);
      System.out.print("\tQuintal per hectar: " + CropList.get(i).quantity);
      System.out.print("\tPreservation Expense: " + CropList.get(i).preservationExpense);

    }
    if (flag == false) {
      System.out.println("\n\t\t-- No Record Found --\n");
    }
    System.out.println("\n");
  }

  public static ArrayList<Crop> addCrop() {
    ArrayList<Crop> CropList = new ArrayList<Crop>(0);
    Scanner input = new Scanner(System.in);
    String choose;
    do {
      System.out.print("\t\t\t\t--- Menu for Adding Crop ---\n");
      System.out.println("Enter Crop Name: ");
      String CropName = input.nextLine();
      System.out.println("Enter currentPrice : ");
      float currentPrice = input.nextFloat();
      System.out.println("Enter preservationExpense: ");
      float preservationExpense = input.nextFloat();
      System.out.println("Enter Quantity(int): ");
      int quantity = input.nextInt();
      Crop Crop = new Crop(CropName, quantity, currentPrice, preservationExpense);
      CropList.add(Crop);
      System.out.println("Do you want to add other crop ? enter y/n");
      input.nextLine();
      choose = input.nextLine();
    } while (choose.equalsIgnoreCase("y"));

    return CropList;
  }

  public static float calculateCropExpense(ArrayList<Crop> CropList) {
    float total = 0;
    for (int i = 0; i < CropList.size(); i++) {
      total = total + CropList.get(i).currentPrice * CropList.get(i).quantity + CropList.get(i).preservationExpense;
    }
    return total;
  }
}

