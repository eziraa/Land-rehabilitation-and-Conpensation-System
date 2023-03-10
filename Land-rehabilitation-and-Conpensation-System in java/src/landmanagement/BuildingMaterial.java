
package landmanagement;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class BuildingMaterial {
  private String BuildingMaterialName;
  private int quantity;
  private float currentPrice;

  public BuildingMaterial() {

  }

  public BuildingMaterial(String BuildingMaterialName, int quantity, float currentPrice) {
    this.BuildingMaterialName = BuildingMaterialName;
    this.quantity = quantity;
    this.currentPrice = currentPrice;
  }

  public BuildingMaterial(BuildingMaterial BuildingMaterial) {
    this.BuildingMaterialName = BuildingMaterial.BuildingMaterialName;
    this.quantity = BuildingMaterial.quantity;
    this.currentPrice = BuildingMaterial.currentPrice;
  }

  public String getBuildingMaterialName() {
    return this.BuildingMaterialName;
  }

  public void setBuildingMaterialName(String BuildingMaterialName) {
    this.BuildingMaterialName = BuildingMaterialName;
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

  public static void displayAllBuildingMaterials(ArrayList<BuildingMaterial> BuildinMaterialList) {
    boolean flag = false;
    int increment;
    System.out.print("\n\t\t\t\tAll BuildingMaterials of the house \n");
    for (int i = 0; i < BuildinMaterialList.size(); i++) {
      flag = true;
      increment = i;
      increment++;
      System.out.println("\t\t\tBuilding Material.: " + increment);
      System.out.println("\t\t\tBuildingMaterial name: " + BuildinMaterialList.get(i).getBuildingMaterialName() + "");
      System.out.println("\t\t\tcurrentPrice: " + BuildinMaterialList.get(i).getcurrentPrice() + "");
      System.out.println("\t\t\tQuantity: " + BuildinMaterialList.get(i).getQuantity() + "\n");

    }
    if (flag == false) {
      System.out.println("\n\t\t-- No Record Found --\n");
    }
    System.out.println("\n");
  }

  public static ArrayList<BuildingMaterial> addBuildingMaterial() {
    ArrayList<BuildingMaterial> BuildingMaterialList = new ArrayList<BuildingMaterial>(0);
    Scanner input = new Scanner(System.in);
    String choose;
    System.out.print("\t\t\t\t--- Menu for Adding BuildingMaterial ---\n");
    do {
      System.out.println("Enter BuildingMaterial Name: ");
      String BuildingMaterialName = input.nextLine();
      System.out.println("Enter currentPrice Name: ");
      float currentPrice = input.nextFloat();
      System.out.println("Enter Quantity(int): ");
      int quantity = input.nextInt();
      BuildingMaterial buildingMaterial = new BuildingMaterial(BuildingMaterialName, quantity, currentPrice);
      BuildingMaterialList.add(buildingMaterial);
      input.nextLine();
      System.out.println("Do you want to add other enter y/n\n");
      choose = input.nextLine();
    } while (choose.equalsIgnoreCase("y"));
    return BuildingMaterialList;
  }

  public float calculateBldgExpense() {
    return this.currentPrice * this.quantity;
  }
}
