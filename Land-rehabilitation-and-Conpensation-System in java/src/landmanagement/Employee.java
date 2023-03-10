
package landmanagement;


import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

class Employee extends Person {
  private String Employee_ID;
  private String email;
  private String officeNo;

  static ArrayList<Employee> EmployeeList = new ArrayList<Employee>(0);

  public Employee() {

  }

  public Employee(String Employee_ID, String name, String phone_no, String email, String officeNo) {
    this.Employee_ID = Employee_ID;
    this.setName(name);
    this.setPhone_no(phone_no);
    this.email = email;
    this.officeNo = officeNo;
  }

  public String getEmployee_ID() {
    return this.Employee_ID;
  }

  public void setEmployee_ID(String Employee_ID) {
    this.Employee_ID = Employee_ID;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getOfficeNO() {
    return this.officeNo;
  }

  public void setOfficeNO(String officeNo) {
    this.officeNo = officeNo;
  }

  public static Employee searchEmployee() {
    Employee searchedEmployee = null;
    Scanner input = new Scanner(System.in);
    System.out.println("\t\t--- Employee Searching ---\n");
    System.out.println("Enter the Employee Name to search: ");
    String name = input.nextLine();
    boolean flag = false;
    for (int i = 0; i < EmployeeList.size(); i++) {
      if (EmployeeList.get(i).getName().equalsIgnoreCase(name) || EmployeeList.get(i).getName().contains(name)) {
        searchedEmployee = EmployeeList.get(i);
      }
    }
    return searchedEmployee;
  }

  public static ArrayList<Employee> addEmployee() {

    Scanner input = new Scanner(System.in);
    String choose;
    do {
      System.out.print("\n\t\t+++ Form for new employee +++\n");
      System.out.println("Enter employee ID: ");
      String Employee_ID = input.nextLine();
      System.out.println("Enter employee name : ");
      String name = input.nextLine();
      System.out.println("Enter employee Phone number: ");
      String phone_no = input.nextLine();
      System.out.println("Enter employee Email: ");
      String email = input.nextLine();
      System.out.println("Enter employee officeNo : ");
      String officeNo = input.nextLine();
      Employee m1 = new Employee(Employee_ID, name, phone_no, email, officeNo);
      EmployeeList.add(m1);
      System.out.println("Do you want add othe emloyee enter y/n");
      choose = input.nextLine();
    } while (choose.equalsIgnoreCase("y"));

    return EmployeeList;
  }

  public static void displayEmployees() {
    boolean flag = false;
    System.out.print("\t\tInformation about Employees  \n");
    for (int i = 0; i < EmployeeList.size(); i++) {
      flag = true;
      System.out.print("\nNo.: " + (i + 1) + "\t");
      System.out.print("\tEmployee ID: " + EmployeeList.get(i).getEmployee_ID());
      System.out.print("\tEmployee Name: " + EmployeeList.get(i).getName());
      System.out.print("\tPhone No.: " + EmployeeList.get(i).getPhone_no());
      System.out.print("\tEmail: " + EmployeeList.get(i).getEmail());
    }
    if (flag == false) {
      System.out.println("\n\t\t-- No Record Found --\n");
    }
    System.out.println("\n");
  }

  public void displayEmployee() {
    System.out.println("\n\t\tInformation of the seached employee\t");
    System.out.print("\tEmployee ID: " + this.getEmployee_ID() + "\t");
    System.out.print("\tEmployee Name: " + this.getName() + "\t");
    System.out.print("\tPhone No.: " + this.getPhone_no() + "\t");
    System.out.print("\tEmail: " + this.getEmail() + "\t");
  }

  public static void deleteEmployee() {
    Scanner input = new Scanner(System.in);
    System.out.println("\t\t--- Employee Deletion ---\n");
    System.out.println("Enter the Employee Name to delete: ");
    String name = input.nextLine();
    boolean flag = false;
    for (int i = 0; i < EmployeeList.size(); i++) {
      if (EmployeeList.get(i).getName().equalsIgnoreCase(name)) {
        EmployeeList.remove(i);
        flag = true;
        System.out.println("\n*Employee DELETED SUCCESSFULLY*\n");
      }
    }
    if (flag == false)
      System.out.println("\n*Employee IS NOT FOUND*\n");

  }

  public static void updateEmployeeInfo() {
    Scanner input = new Scanner(System.in);
    System.out.println("\t\t--- Employee Searching ---\n");
    System.out.println("Enter the Employee Name to search: ");
    String name = input.nextLine();
    boolean flag = false;
    for (int i = 0; i < EmployeeList.size(); i++) {

      if (EmployeeList.get(i).getName().equalsIgnoreCase(name) || EmployeeList.get(i).getName().contains(name)) {
        System.out.print("\n\t\t+++ Form for new employee +++\n");
        System.out.println("Enter employee ID: ");
        EmployeeList.get(i).Employee_ID = input.nextLine();
        System.out.println("Enter employee name : ");
        EmployeeList.get(i).setName(input.nextLine());
        System.out.println("Enter employee Phone number: ");
        EmployeeList.get(i).setPhone_no(input.nextLine());
        System.out.println("Enter employee Email: ");
        EmployeeList.get(i).email = input.nextLine();
        System.out.println("Enter employee officeNo : ");
        EmployeeList.get(i).officeNo = input.nextLine();
        flag = true;
      }
    }
    if (flag == false)
      System.out.println("There is no match record");
  }

}
