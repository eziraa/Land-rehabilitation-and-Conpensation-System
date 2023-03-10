
package landmanagement;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class House {
  private String House_ID;
  private int labourQuantity;
  private float currentLabourPrice;

  static ArrayList<BuildingMaterial> BuildingMaterialList = new ArrayList<BuildingMaterial>(0);
  // static ArrayList<House> HouseList = new ArrayList<House>(0);

  public House() {

  }

  public House(String House_ID, int labourQuantity, float currentLabourPrice,
      ArrayList<BuildingMaterial> BuildingMaterialList) {
    this.House_ID = House_ID;
    this.labourQuantity = labourQuantity;
    this.currentLabourPrice = currentLabourPrice;
    this.BuildingMaterialList = BuildingMaterialList;
  }

  public House(House B) {
    this.House_ID = B.House_ID;
    this.labourQuantity = B.labourQuantity;
    this.currentLabourPrice = B.currentLabourPrice;
    this.BuildingMaterialList = B.BuildingMaterialList;
  }

  public String getHouse_ID() {
    return this.House_ID;
  }

  public void setHouse_ID(String House_ID) {
    this.House_ID = House_ID;
  }

  public int getLabourQuantity() {
    return this.labourQuantity;
  }

  public void setLabourQuantity(int labourQuantity) {
    this.labourQuantity = labourQuantity;
  }

  public float getCurrentLabourPrice() {
    return this.currentLabourPrice;
  }

  public void setCurrentLabourPrice(float currentLabourPrice) {
    this.currentLabourPrice = currentLabourPrice;
  }

  public static void displayAllHouses(House house) {
    System.out.println("\tHouse ID: " + house.House_ID);
    System.out.println("\tCurrentLabourPrice Name: " + house.currentLabourPrice);
    System.out.println("\tNumber of human resource that house taken: " + house.labourQuantity);
    BuildingMaterial.displayAllBuildingMaterials(house.BuildingMaterialList);

  }

  public static House addHouse() {
    BuildingMaterial BLDGMaterial;
    Scanner input = new Scanner(System.in);
    House house = new House();
    String choose;
    System.out.print("\t\t+++ Menu for Adding House +++\n");
    System.out.println("Enter House ID: ");
    String House_ID = input.nextLine();
    System.out.println("Enter currentLabourPrice : ");
    float currentLabourPrice = input.nextFloat();
    System.out.println("Enter labourQuantity(int): ");
    int labourQuantity = input.nextInt();
    input.nextLine();
    try {
      house = new House(House_ID, labourQuantity, currentLabourPrice, BuildingMaterial.addBuildingMaterial());
      System.out.println("\n*House Added Successflly*\n");

    } catch (Exception e) {
      System.out.print("Invalid Input !!");
    }
    return house;
  }

  public float calculateHouseExpense(House House) {
    float sum = 0;
    for (int i = 0; i < House.BuildingMaterialList.size(); i++) {
      sum = sum + House.BuildingMaterialList.get(i).calculateBldgExpense();
    }
    return (House.getCurrentLabourPrice() * House.getLabourQuantity()) + sum;
  }
}
