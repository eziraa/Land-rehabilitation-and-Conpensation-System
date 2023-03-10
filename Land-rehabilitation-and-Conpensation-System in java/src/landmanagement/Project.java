
package landmanagement;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Project {

  public String projectName;

  public String projectType;

  public Project() {

  }

  public Project(String projectName, String projectType) {
    this.projectName = projectName;
    this.projectType = projectType;
  }

  public void requestLand() {
  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getProjectType() {
    return projectType;
  }

  public void setProjectType(String projectType) {
    this.projectType = projectType;
  }

}
