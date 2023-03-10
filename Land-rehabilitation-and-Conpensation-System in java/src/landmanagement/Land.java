
package landmanagement;

import java.util.Scanner;
import java.util.Vector;
import java.io.*;
import java.util.ArrayList;

class Land {

  public String landID;

  public String landType;

  public String landStatus;
  public House HouseList = new House();
  static ArrayList<Land> LandList = new ArrayList<Land>(0);
  static ArrayList<Plant> PlantList = new ArrayList<Plant>(0);
  static ArrayList<Crop> CropList = new ArrayList<Crop>(0);

  public Vector myPlant;
  public Vector myCrop;
  public Vector myHouse;
  public Vector myBuildingMaterial;

  public Land() {

  }

  public Land(ArrayList<Plant> PlantList, ArrayList<Crop> CropList, House HouseList,
      String landID, String landType, String landStatus) {
    this.CropList = CropList;
    this.PlantList = PlantList;
    this.HouseList = HouseList;
    this.landID = landID;
    this.landStatus = landStatus;
    this.landType = landType;
  }

  public static Land add_land() {
    Land land = new Land();
    Address address = new Address();
    Scanner input = new Scanner(System.in);
    System.out.println("\t\t\t---Adding land ---");
    System.out.println("\t\t\tEnter the land status: ");
    String landStatus = input.nextLine();
    System.out.println("\t\t\tEnter the land ID: ");
    String landID = input.nextLine();
    System.out.println("\t\t\tEnter the land type: ");
    String landType = input.nextLine();
    Crop crop = new Crop();
    CropList = Crop.addCrop();
    PlantList = Plant.addPlant();
    House HouseList = House.addHouse();
    land = new Land(PlantList, CropList, HouseList, landID, landType, landStatus);
    return land;
  }

  public float calculateLandExpense() {
    float sum = 0;
    float sum1 = 0;
    for (int i = 0; i < this.CropList.size(); i++) {
      sum = sum + this.CropList.get(i).calculateCropExpense(this.CropList);
    }
    for (int i = 0; i < this.PlantList.size(); i++) {
      sum1 = sum1 + this.PlantList.get(i).calculatePlantExpense(this.PlantList);
    }

    return this.HouseList.calculateHouseExpense(this.HouseList) + sum + sum1;
  }

  public static void getTotalLand(Land land) {
    System.out.println("\t\t\t|Plant compensation : " + Plant.calculatePlantExpense(land.PlantList));
    System.out.println("\t\t\t|Crop compensation : " + Crop.calculateCropExpense(land.CropList));
    System.out.println("\t\t\t|House compensation : " + land.HouseList.calculateHouseExpense(land.HouseList));

  }

}