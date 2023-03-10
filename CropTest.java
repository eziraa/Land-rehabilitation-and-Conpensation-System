
package landmanagement;

import static org.junit.Assert.*;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;


public class CropTest {
  Crop crop;
  ArrayList<Crop> CropList;
 public CropTest(Crop crop){
      this.crop = crop;
  }
  @Before
  public void setUp() {
   //Crop  crop = new Crop("Wheat", 20, 30.0f, 5.0f);
     
Crop crop = new Crop("Wheat", 20, 30.0f, 5.0f);
  CropTest test = new CropTest(crop);
  }
  public static void main(String[] args) {
   
Crop crop = new Crop("Wheat", 20, 30.0f, 5.0f);
  CropTest test = new CropTest(crop);
  test.testGetCropName();
  test.testCropConstructor();
 test.testCropCopyConstructor();
  test.testDisplayAllCrops();
  test.testGetCropName();
  test.testGetPreservationExpense();
  test.testGetQuantity();
  test.testGetcurrentPrice();
  test.testSetCropName();
  test.testSetPreservationExpense();
  test.testSetQuantity();
  test.testSetcurrentPrice();
  Plant plant = new Plant("Rose", 10, 20.0f, 5.0f);
 PlantTest  plantTest = new PlantTest(plant);
  plantTest.testGetPlantName();
  plantTest.testGetPlantName();
  plantTest.testGetPreservationExpense();
  plantTest.testGetQuantity();
  test.testGetcurrentPrice();
  plantTest.testSetPlantName();
  plantTest.testSetPreservationExpense();
  plantTest.testSetQuantity();
  test.testSetcurrentPrice();
  BuildingMaterial bldg = new BuildingMaterial("cement", 10, 20.0f);
 BuildingMaterialTest  buildingMaterialTest = new BuildingMaterialTest(bldg);
 buildingMaterialTest.testBuildingMaterialName();
 buildingMaterialTest.testCalculateBldgExpense();
 buildingMaterialTest.testCurrentPrice();
 buildingMaterialTest.testDisplayAllBuildingMaterials();
 buildingMaterialTest.testQuantity();
 ArrayList<BuildingMaterial> BL = new ArrayList<BuildingMaterial>(0);
 House house = new House("ID001",10,20.0f,BL);
 HouseTest houseTest = new HouseTest(house);
 houseTest.testCalculateHouseExpense();
 houseTest.testDisplayAllHouses();
 houseTest.testSettersAndGetters();
 
  }
  @Test
  public void testGetCropName() {
      System.out.println("Name of crop wheat = "+crop.getCropName());
    assertEquals("Wheat", crop.getCropName());
  }

  @Test
  public void testSetCropName() {
//   Crop crop = new Crop();
      crop.setCropName("Rice");
    assertEquals("Rice", crop.getCropName());
  }

  @Test
  public void testGetQuantity() {
      System.out.println("Quntity of crop1 20 = "+crop.getQuantity());
    assertEquals(20, crop.getQuantity());
  }

  @Test
  public void testSetQuantity() {
    crop.setQuantity(30);
    assertEquals(30, crop.getQuantity());
  }

  @Test
  public void testGetcurrentPrice() {
     
      //System.out.println("Current price of crop 20 = "+crop.getcurrentPrice());
    assertEquals(30.0f, crop.getcurrentPrice(), 0.0);
  }

  @Test
  public void testSetcurrentPrice() {
      
    crop.setcurrentPrice(30.0f);
    assertEquals(30.0f, crop.getcurrentPrice(), 0.0);
  }

  @Test
  public void testGetPreservationExpense() {
    assertEquals(5.0f, crop.getPreservationExpense(), 0.0);
  }

  @Test
  public void testSetPreservationExpense() {
    crop.setPreservationExpense(10.0f);
    assertEquals(10.0f, crop.getPreservationExpense(), 0.0);
  }

  @Test
  public void testCalculateCropExpense() {
      
      System.out.println("Quntity of crop 200 = "+crop.getQuantity());
    assertEquals(35.0f, Crop.calculateCropExpense(CropList), 0.0);
  }




  
 @Test
  void testCropConstructor() {
    Crop crop = new Crop("Rice", 100, 20.0f, 5.0f);
    assertEquals("Rice", crop.getCropName());
    assertEquals(100, crop.getQuantity());
    assertEquals(20.0f, crop.getcurrentPrice(),0.0003f);
    assertEquals(5.0f, crop.getPreservationExpense(),0.0003f);
  }
  
  @Test
  void testCropCopyConstructor() {
    Crop crop1 = new Crop("Rice", 100, 20.0f, 5.0f);
    Crop crop2 = new Crop(crop1);
    assertEquals("Rice", crop2.getCropName());
    assertEquals(100, crop2.getQuantity());
    assertEquals(20.0f, crop2.getcurrentPrice(),0.0003f);
    assertEquals(5.0f, crop2.getPreservationExpense(),0.0003f);
  }
  
  @Test
  void testAddCrop() {
    ArrayList<Crop> cropList = Crop.addCrop();
    assertEquals(1, cropList.size());
    Crop crop = cropList.get(0);
    assertEquals("Rice", crop.getCropName());
    assertEquals(100, crop.getQuantity());
    assertEquals(20.0f, crop.getcurrentPrice(),0.0003f);
    assertEquals(5.0f, crop.getPreservationExpense(),0.0003f);
  }

  @Test
  void testDisplayAllCrops() {
    ArrayList<Crop> cropList = new ArrayList<>();
    cropList.add(new Crop("Rice", 100, 20.0f, 5.0f));
    cropList.add(new Crop("Wheat", 200, 15.0f, 3.0f));
    Crop.displayAllCrops(cropList);
  }
  
}


  class PlantTest {
     Plant plant ;
      public PlantTest(Plant plant){
          this.plant = plant;
      }
   @Test
   public void testGetPlantName() {
     Plant plant = new Plant("Rose", 10, 20.0f, 5.0f);
     assertEquals("Rose", plant.getPlantName());
   }

   @Test
   public void testSetPlantName() {
     Plant plant = new Plant();
     plant.setPlantName("Lily");
     assertEquals("Lily", plant.getPlantName());
   }

   @Test
   public void testGetQuantity() {
     Plant plant = new Plant("Rose", 10, 20.0f, 5.0f);
     assertEquals(10, plant.getQuantity());
   }

   @Test
   public void testSetQuantity() {
     Plant plant = new Plant();
     plant.setQuantity(15);
     assertEquals(15, plant.getQuantity());
   }

   @Test
   public void testGetCurrentPrice() {
     Plant plant = new Plant("Rose", 10, 20.0f, 5.0f);
     assertEquals(20.0f, plant.getcurrentPrice(), 0.0f);
   }

   @Test
   public void testSetCurrentPrice() {
     Plant plant = new Plant();
     plant.setcurrentPrice(25.0f);
     assertEquals(25.0f, plant.getcurrentPrice(), 0.0f);
   }

   @Test
   public void testGetPreservationExpense() {
     Plant plant = new Plant("Rose", 10, 20.0f, 5.0f);
     assertEquals(5.0f, plant.getpreservationExpense(), 0.0f);
   }

   @Test
   public void testSetPreservationExpense() {
     Plant plant = new Plant();
     plant.setpreservationExpense(7.0f);
     assertEquals(7.0f, plant.getpreservationExpense(), 0.0f);
   }

   @Test
   public void testAddPlant() {
     ArrayList<Plant> plantList = Plant.addPlant();
     assertNotEquals(0, plantList.size());
   }

   @Test
   public void testCalculatePlantExpense() {
     ArrayList<Plant> plantList = new ArrayList<>();
     plantList.add(new Plant("Rose", 10, 20.0f, 5.0f));
     plantList.add(new Plant("Lily", 15, 25.0f, 7.0f));
     float totalExpense = Plant.calculatePlantExpense(plantList);
     assertEquals(380.0f, totalExpense, 0.0f);
   }
 }
 class BuildingMaterialTest {
     BuildingMaterial bldg;
     public BuildingMaterialTest(BuildingMaterial bldg){
         this.bldg = bldg;
     }
   @Test
   public void testBuildingMaterialName() {
     BuildingMaterial material = new BuildingMaterial("Cement", 10, 50.0f);
     assertEquals("Cement", material.getBuildingMaterialName());
   }

   @Test
   public void testQuantity() {
     BuildingMaterial material = new BuildingMaterial("Cement", 10, 50.0f);
     assertEquals(10, material.getQuantity());
   }

   @Test
   public void testCurrentPrice() {
     BuildingMaterial material = new BuildingMaterial("Cement", 10, 50.0f);
     assertEquals(50.0f, material.getcurrentPrice(), 0.01);
   }

   @Test
   public void testAddBuildingMaterial() {
     ArrayList<BuildingMaterial> buildingMaterials = BuildingMaterial.addBuildingMaterial();
     assertTrue(buildingMaterials.size() > 0);
   }

   @Test
   public void testDisplayAllBuildingMaterials() {
     ArrayList<BuildingMaterial> buildingMaterials = new ArrayList<BuildingMaterial>();
     BuildingMaterial material = new BuildingMaterial("Cement", 10, 50.0f);
     buildingMaterials.add(material);
     BuildingMaterial.displayAllBuildingMaterials(buildingMaterials);
     assertTrue(true);
   }

   @Test
   public void testCalculateBldgExpense() {
     BuildingMaterial material = new BuildingMaterial("Cement", 10, 50.0f);
     assertEquals(500.0f, material.calculateBldgExpense(), 0.01);
   }
 }

  class HouseTest {
      House house;
public HouseTest(House house){
    this.house = house;
}
   @Test
   public void testAddHouse() {
     House house = new House();
     house = House.addHouse();
     assertEquals("House ID should be set correctly", "ID001", house.getHouse_ID());
     assertEquals("Labour Quantity should be set correctly", 10, house.getLabourQuantity());
     assertEquals("Current Labour Price should be set correctly", 20.0, house.getCurrentLabourPrice(), 0.01);
   }

   @Test
   public void testCalculateHouseExpense() {
     BuildingMaterial material1 = new BuildingMaterial("Material 1", 10, 50.0f);
     BuildingMaterial material2 = new BuildingMaterial("Material 2", 20, 60.0f);
     ArrayList<BuildingMaterial> buildingMaterials = new ArrayList<BuildingMaterial>();
     buildingMaterials.add(material1);
     buildingMaterials.add(material2);
     House house = new House("ID001", 10, 20.0f, buildingMaterials);
     assertEquals("House Expense should be calculated correctly", 1900.0, house.calculateHouseExpense(house), 0.01);
   }

   @Test
   public void testSettersAndGetters() {
     House house = new House();
     house.setHouse_ID("ID001");
     assertEquals("House ID should be set correctly", "ID001", house.getHouse_ID());
     house.setLabourQuantity(10);
     assertEquals("Labour Quantity should be set correctly", 10, house.getLabourQuantity());
     house.setCurrentLabourPrice(20.0f);
     assertEquals("Current Labour Price should be set correctly", 20.0, house.getCurrentLabourPrice(), 0.01);
   }

   @Test
   public void testDisplayAllHouses() {
     // The method displayAllHouses() writes to the console, so this test case can only check if the method is executed without any errors.
     BuildingMaterial material1 = new BuildingMaterial("Material 1", 10, 50.0f);
     BuildingMaterial material2 = new BuildingMaterial("Material 2", 20, 60.0f);
     ArrayList<BuildingMaterial> buildingMaterials = new ArrayList<BuildingMaterial>();
     buildingMaterials.add(material1);
     buildingMaterials.add(material2);
     House house = new House("ID001", 10, 20.0f, buildingMaterials);
     House.displayAllHouses(house);
   }
 }
