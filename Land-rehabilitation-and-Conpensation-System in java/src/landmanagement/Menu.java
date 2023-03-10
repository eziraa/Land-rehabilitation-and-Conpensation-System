
package landmanagement;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Menu {

    public static void main(String[] args) {
        Menu Menu = new Menu();
        Menu.LoginMenu(Menu);
        System.out.println("Application has been shut down");
    }

    public Menu LoginMenu(Menu Menu) {
        int option = 0;
        System.out.println("\t\t--------Log in--------\n");
        System.out.println("\t\tPlease Enter your user name and password\n");
        boolean flag = false;
        boolean login_check = false;
        String name = "root";
        while (!flag) {
            flag = true;
            Console console = System.console();
            name = console.readLine("User Name:");
            char[] password = console.readPassword("Password:");
            String pwd = new String(password);
            LandOwner employee = new LandOwner();
            if (name.equals("admin") && pwd.equals("root") || name.equals("guest") && pwd.equals("root")) {
                System.out.println("\t\t\tLogin Successful \n");
                login_check = true;
            } else {
                System.out.println("\t\t\tLogin Failed. Incorrect Name or Password. Please try again !!\n");
                flag = false;
            }
        }
        if (login_check == true && name.equals("admin")) {
            Menu.MainMenu(Menu);
        } else {
         Menu.guastMenu(Menu);
     }
        return Menu;

    }

    private Menu MainMenu(Menu Menu) {
        Scanner input = new Scanner(System.in);

        int option;
        do {
            System.out.println("\n\t\t===========================================================================\n");
            System.out.println("\t\t\t\t Land Compensation and rehabilitation System\n");
            System.out.println("\t\t===========================================================================\n");
            System.out.println("\t\t--------------------------------Main Menu------------------------------------\n");
            System.out.println("\t1. Manage Employee \n");
            System.out.println("\t2. Manage LandOwner \n");
            System.out.println("\t3. Manage Land Request \n");
            System.out.println("\t4. Back to login\n");
            System.out.println("\t0. Quit \n");
            System.out.println("\t\t-----------------------------------------------------------------------------\n");
            option = input.nextInt();

            switch (option) {
                case 1:
                    return Menu.EmployeeMenu(Menu);
                case 2:
                    return Menu.LandOwnerMenu(Menu);
                case 3:
                    return Menu.RequestMenu(Menu);
                case 4:
                    return Menu.LoginMenu(Menu);
                default:
                    System.out.print("Wrong input, please try again !!\n");
            }
        } while (option != 0);

        return Menu;
    }

    private Menu EmployeeMenu(Menu Menu) {
        Scanner input = new Scanner(System.in);
        {
            int empOption = 0;
            Employee employee = new Employee();
            do {
                System.out.println("\n\t\tChoose what you want to do\n\n");
                System.out.println("\t1. Add Employee \n");
                System.out.println("\t2. Delete Employee\n");
                System.out.println("\t3. Update Employee Information\n");
                System.out.println("\t4. Search Employee\n");
                System.out.println("\t5. Display All Employee\n");
                System.out.println("\t6. Back to Main Menu\n");
                System.out.println("\t0. Exit\n");
                empOption = input.nextInt();
                switch (empOption) {
                    case 1:
                        ArrayList<Employee> EmployeeList = Employee.addEmployee();
                        break;
                    case 2:
                        Employee.deleteEmployee();
                        break;
                    case 3:
                        Employee.updateEmployeeInfo();
                        break;
                    case 4:
                        Employee searchedEmployee = Employee.searchEmployee();
                        if (searchedEmployee != null) {
                            searchedEmployee.displayEmployee();

                        } else {
                            System.out.println("Employee not found");
                        }
                        break;
                    case 5:
                        Employee.displayEmployees();
                        break;
                    case 6:
                        return Menu.MainMenu(Menu);
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Wrong input!!!!!!!");
                }
            } while (empOption != 0);
        }
        return Menu;
    }

    private Menu LandOwnerMenu(Menu Menu) {
        Scanner input = new Scanner(System.in);
        int empOption = 0;
        LandOwner employee = new LandOwner();
        do {
            System.out.println("\n\t\tChoose what you want to do\n\n");
            System.out.println("\t1. Add LandOwner \n");
            System.out.println("\t2. Delete LandOwner\n");
            System.out.println("\t3. Update LandOwner Information\n");
            System.out.println("\t4. Search LandOwner\n");
            System.out.println("\t5. Display All LandOwner\n");
            System.out.println("\t6. Back to Main Menu\n");
            System.out.println("\t0. Exit\n");
            empOption = input.nextInt();
            switch (empOption) {
                case 1:
                    ArrayList<LandOwner> LandOwnerList = LandOwner.addLandOwner();
                    break;
                case 2:
                    LandOwner.deleteLandOwner();
                    break;
                case 3:
                    LandOwner.updateLandOwnerInfo();
                    break;
                case 4:
                    LandOwner searchedLandOwner = LandOwner.searchLandOwner();
                    if (searchedLandOwner != null) {
                        searchedLandOwner.displayLandOwner();
                    } else {
                        System.out.println("LandOwner not found");
                    }
                    break;
                case 5:
                    LandOwner.displayLandOwners();
                    break;
                case 6:
                    return Menu.MainMenu(Menu);
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Wrong input!!!!!");
            }
        } while (empOption != 0);
        return Menu;
    }

    private Menu RequestMenu(Menu Menu) {
        Scanner input = new Scanner(System.in);
        {
            int empOption = 0;
            Request employee = new Request();
            do {
                System.out.println("\n\t\tChoose what you want to do\n\n");
                System.out.println("\t1. Search Request\n");
                System.out.println("\t2. Delete Request\n");
                System.out.println("\t3. Display All Request\n");
                System.out.println("\t4. Make notification\n");
                System.out.println("\t5. Count Proprty\n");
                System.out.println("\t6. See counted info\n");
                System.out.println("\t7. Make Compensation\n");
                System.out.println("\t8. Back to Main Menu\n");
                System.out.println("\t0. Exit\n");
                empOption = input.nextInt();
                switch (empOption) {
                    case 1:
                        Request searchedRequest = Request.searchRequest();
                        if (searchedRequest != null) {
                            searchedRequest.seeRequest();

                        } else {
                            System.out.println("Request not found");
                        }
                        break;
                    case 2:
                        Request.deleteRequest();
                        break;
                    case 3:
                        Request.seeRequests();
                        break;
                    case 4:
                        String name;
                        System.out.println("Enter The project name you want to make notification");
                        input.nextLine();
                        name = input.nextLine();
                        Request.notifyLandOwner(name);
                        break;
                    case 5:
                        // String name;
                        System.out.println("Enter The project name you want to make notification");
                        input.nextLine();
                        name = input.nextLine();
                        Request.countProperty(name);
                        break;
                    case 6:
                        Request.seeinfo();
                        break;
                    case 7:
                        Request.makeCompensation();
                        break;
                    case 8:
                        return Menu.MainMenu(Menu);
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Wrong input!!!!!!!");
                }
            } while (empOption != 0);
        }
        return Menu;
    }

    private Menu guastMenu(Menu Menu) {
        Scanner input = new Scanner(System.in);

        int option;
        do {
            System.out.println("\n\t\t===========================================================================\n");
            System.out.println("\t\t\t\t Land Compensation and rehabilitation System\n");
            System.out.println("\t\t===========================================================================\n");
            System.out.println(
                    "\t\t--------------------------------User interface------------------------------------\n");
            System.out.println("\t1. Request Land \n");
            System.out.println("\t2. Back to Login \n");
            System.out.println("\t0. Quit \n");
            option = input.nextInt();
            switch (option) {
                case 1:
                    Request.request_land();
                    break;
                case 2:
                    Menu.LoginMenu(Menu);
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input!!!!!!!");
            }
        } while (option != 0);
        return Menu;
    }
}