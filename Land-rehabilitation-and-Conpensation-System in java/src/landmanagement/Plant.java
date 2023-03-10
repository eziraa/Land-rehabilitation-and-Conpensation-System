
package landmanagement;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Plant {
  private String PlantName;
  private int quantity;
  private float currentPrice;
  private float preservationExpense;

  public Plant() {

  }

  public Plant(String PlantName, int quantity, float currentPrice, float preservationExpense) {
    this.PlantName = PlantName;
    this.quantity = quantity;
    this.currentPrice = currentPrice;
    this.preservationExpense = preservationExpense;
  }

  public Plant(Plant Plant) {
    this.PlantName = Plant.PlantName;
    this.quantity = Plant.quantity;
    this.currentPrice = Plant.currentPrice;
    this.preservationExpense = Plant.preservationExpense;
  }

  public String getPlantName() {
    return this.PlantName;
  }

  public void setPlantName(String PlantName) {
    this.PlantName = PlantName;
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

  public float getpreservationExpense() {
    return this.preservationExpense;
  }

  public void setpreservationExpense(float preservationExpense) {
    this.preservationExpense = preservationExpense;
  }

  public void display() {
    System.out.println("\tPlant Name: " + this.PlantName);
    System.out.println("\t\tPlant currentPrice : " + this.currentPrice);
    System.out.println("\t\tQuanitityr: " + this.quantity);
    System.out.println("\t\tPreservation Expense: " + this.preservationExpense + "\n");
  }

  public static ArrayList<Plant> addPlant() {
    ArrayList<Plant> PlantList = new ArrayList<Plant>(0);
    Scanner input = new Scanner(System.in);
    String choose;
    do {
      System.out.print("\t\t\t\t--- Menu for Adding Plant ---\n");
      System.out.println("Enter Plant Name: ");
      String PlantName = input.nextLine();
      System.out.println("Enter currentPrice : ");
      float currentPrice = input.nextFloat();
      System.out.println("Enter preservationExpense: ");
      float preservationExpense = input.nextFloat();
      System.out.println("Enter Quantity(int): ");
      int quantity = input.nextInt();
      Plant Plant = new Plant(PlantName, quantity, currentPrice, preservationExpense);
      PlantList.add(Plant);
      System.out.println("Do you want to add other crop ? enter y/n");
      input.nextLine();
      choose = input.nextLine();
    } while (choose.equalsIgnoreCase("y"));

    return PlantList;
  }

  public static float calculatePlantExpense(ArrayList<Plant> PlantList) {
    float total = 0;
    for (int i = 0; i < PlantList.size(); i++) {
      total = total + PlantList.get(i).currentPrice * PlantList.get(i).quantity + PlantList.get(i).preservationExpense;
    }
    return total;
  }
}
