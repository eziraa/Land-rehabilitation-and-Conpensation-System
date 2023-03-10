
package landmanagement;

import java.util.Scanner;
import java.io.*;
import java.util.Date;
import java.util.ArrayList;

public class Request {

    Address address;
    Project project;
    private Date request_date;
    public Land land;
    LandOwner LandOwn;
    static ArrayList<LandOwner> LandOwners = new ArrayList<LandOwner>(0);
    static ArrayList<Request> RequestList = new ArrayList<Request>(0);
    static ArrayList<Request> landRequestList = new ArrayList<Request>(0);

    public Request() {

    }

    public Request(Address address, Project project, Date request_date) {
        this.address = address;
        this.project = project;
        this.request_date = new Date();
    }

    public Request(ArrayList<LandOwner> LandOwners, Address address, Project project, Date request_date) {
        this.address = address;
        this.project = project;
        this.request_date = new Date();
        this.LandOwners = LandOwners;
    }

    public Date getrequest_date() {
        return this.request_date;
    }

    public void setrequest_date(Date request_date) {

        this.request_date = request_date;

    }

    public static ArrayList<Request> request_land() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\t\t--------land request interface--------\n");
        System.out.println("Enter the name of the project: ");
        String projectName = input.nextLine();
        System.out.println("Enter project type: ");
        String projectType = input.nextLine();
        System.out.println("Enter the region of the land you want to build your project: ");
        String region = input.nextLine();
        System.out.println("Enter its zone: ");
        String zone = input.nextLine();
        System.out.println("Enter its wereda: ");
        String wereda = input.nextLine();
        System.out.println("Enter its kebele: ");
        String kebele = input.nextLine();
        Project project = new Project(projectName, projectType);
        Address adddress = new Address(region, zone, wereda, kebele);
        java.util.Date date = new java.util.Date();
        Request request = new Request(adddress, project, date);
        RequestList.add(request);
        System.out.print("\n\t\t requested Successfully");
        return RequestList;
    }

    public static ArrayList<Request> countProperty(String name) {
        Request Request = new Request();
        if (RequestList.size() != 0) {
            for (int i = 0; i < RequestList.size(); i++)
                if (RequestList.get(i).project.projectName.equalsIgnoreCase(name)) {
                    Request = RequestList.get(i);
                    ArrayList<LandOwner> landOwne = LandOwner.searchByAddress(Request.address.kebele);
                    Project project = Request.project;
                    Address adddress = Request.address;
                    System.out.println("\n\t\t-------Proprty counting interface--------\n");
                    if (landOwne != null)
                        for (int k = 0; k < landOwne.size(); k++) {
                            System.out.println("\n\tLand Owner Name : " + landOwne.get(k).getName());
                            Land land = Land.add_land();
                            LandOwners.add(
                                    new LandOwner(land, landOwne.get(k).getLandOwner_ID(), landOwne.get(k).getName(),
                                            landOwne.get(k).getPhone_no()));
                        }
                    java.util.Date date = new java.util.Date();
                    Request request = new Request(LandOwners, adddress, project, date);
                    landRequestList.add(request);
                    System.out.print("\n\t\t requested Successfully");
                }
        } else
            System.out.println("\t\tThere is no record");
        return landRequestList;
    }

    public static void seeRequests() {
        for (int i = 0; i < RequestList.size(); i++) {
            System.out.println("\n\t----------------Request List-------------------");
            System.out.println(i + 1 + ".: ");
            System.out.print("\t\tProject Name : " + RequestList.get(i).project.projectName + "\n");
            System.out.print("\t\tProject Type : " + RequestList.get(i).project.projectType + "\n");
            System.out.println("\t\t\t\tAddress of the request");
            System.out.println("\t\t\tRegion : " + RequestList.get(i).address.region + "\n");
            System.out.println("\t\t\tZone : " + RequestList.get(i).address.zone + "\n");
            System.out.println("\t\t\tWereda : " + RequestList.get(i).address.wereda + "\n");
            System.out.println("\t\t\tKebele : " + RequestList.get(i).address.kebele + "\n");
            System.out.println("\t\t\tRsequest date : " + RequestList.get(i).request_date + "\n");

        }
    }

    /**
     * 
     */
    public static void seeinfo() {
        if (landRequestList.size() != 0) {
            int i = 0;
            System.out.println("\n\t----------------Request List-------------------");
            System.out.println(i + 1 + ".: ");
            System.out.println("\tProject Name : " + landRequestList.get(i).project.projectName);
            System.out.println("\tProject Type : " + landRequestList.get(i).project.projectType);
            System.out.println("\tRegion : " + landRequestList.get(i).address.region);
            System.out.println("\tZone : " + landRequestList.get(i).address.zone);
            System.out.println("\tWereda : " + landRequestList.get(i).address.wereda);
            System.out.println("\tKebele : " + landRequestList.get(i).address.kebele);
            System.out.println("\tRsequest date : " + landRequestList.get(i).request_date);
            System.out.println("\n\t\tInformation of land owner\t");
            for (int j = 0; j < landRequestList.get(i).LandOwners.size(); j++) {
                landRequestList.get(i).LandOwners.get(j).displayLandOwner();
                System.out.println("\n\n\t\tCrop Information\t");
                for (int k = 0; k < landRequestList.get(i).LandOwners.get(j).land.CropList.size(); k++) {
                    landRequestList.get(i).LandOwners.get(j).land.CropList.get(k).display();
                }
                System.out.println("\n\n\t\tPlant Information\t");
                for (int k = 0; k < landRequestList.get(i).LandOwners.get(j).land.PlantList.size(); k++) {
                    landRequestList.get(i).LandOwners.get(j).land.PlantList.get(k).display();
                }
                System.out.println("\n\n\t\tHouse Information\t");
                House.displayAllHouses(landRequestList.get(i).LandOwners.get(j).land.HouseList);
            }
        } else
            System.out.println("There is no record");
    }

    public void seeRequest() {
        System.out.println("\n\t----------------Request Datails-------------------");
        System.out.println("\tProject Name : " + this.project.projectName + "\n");
        System.out.println("\tProject Type : " + this.project.projectType + "\n");
        System.out.println("\tRegion : " + this.address.region + "\n");
        System.out.println("\tZone : " + this.address.zone + "\n");
        System.out.println("\tWereda : " + this.address.wereda + "\n");
        System.out.println("\tKebele : " + this.address.kebele + "\n");
        System.out.println("\tRsequest date : " + this.request_date + "\n");
    }

    public static void notifyLandOwner(String name) {
        Request Request = new Request();
        if (RequestList.size() != 0) {
            for (int i = 0; i < RequestList.size(); i++)
                if (RequestList.get(i).project.projectName.equalsIgnoreCase(name)) {
                    Request = RequestList.get(i);
                    ArrayList<LandOwner> landOwne = LandOwner.searchByAddress(Request.address.kebele);
                    if (landOwne != null)
                        for (int k = 0; k < landOwne.size(); k++) {
                            System.out.println("\n\t\t______________________________________________");
                            System.out.println("\t\t|----------------Notification------------------");
                            System.out.println("\t\t|\tDear: " + landOwne.get(k).getName() + "      |");
                            System.out.println("\t\t|                                              |");
                            System.out.println("\t\t|  I hope this message finds you well. I am    |");
                            System.out.println("\t\t|  writing to discuss a proposed project that  |");
                            System.out.println("\t\t|  would require  use of your land. Our team   |");
                            System.out.println("\t\t|  has identified a need for the development   |");
                            System.out.println("\t\t|  of this project and we believe that your    |");
                            System.out.println("\t\t|  property is suitable location.We understand |");
                            System.out.println("\t\t|  that may impact your current use   the land |");
                            System.out.println("\t\t|  land and we would like to have an open and  |");
                            System.out.println("\t\t|  transparent conversation with you about and |");
                            System.out.println("\t\t|  this matter. Our goal is to find a solution |");
                            System.out.println("\t\t|  that is beneficial for both parties and we  |");
                            System.out.println("\t\t|  would be grateful for the opportunity to    |");
                            System.out.println("\t\t|  this proposal with you in person. Would you |");
                            System.out.println("\t\t|  be available for a meeting in the next week |");
                            System.out.println("\t\t|  you  to discuss  further? We would be happy |");
                            System.out.println("\t\t|  to arrange time & place that is convenient  |");
                            System.out.println("\t\t|  Thank you for your time and consideration.  |");
                            System.out.println("\t\t|  we look forward to speaking with you soon.  |");
                            System.out.println("\t\t|\t\t\tBest regards : " + Request.project.projectName + "\t|");
                            System.out.println("\t\t|______________________________________________|");

                        }
                }
        } else
            System.out.println("\t\tThere is no record");

    }

    public static void makeCompensation() {

        if (landRequestList.size() != 0) {
            for (int i = 0; i < landRequestList.size(); i++) {
                System.out.println("\n\t\tProject Name :" + landRequestList.get(i).project.projectName);
                for (int j = 0; j < landRequestList.get(i).LandOwners.size(); j++) {
                    System.out.println("\n\t\tLandOwner Name :" + landRequestList.get(i).LandOwners.get(j).getName());
                    Land.getTotalLand(landRequestList.get(i).LandOwners.get(j).land);
                    System.out.println("\n\t\t\tTotal compensation : "
                            + landRequestList.get(i).LandOwners.get(j).land.calculateLandExpense());
                }
            }
        } else
            System.out.println("\t\tThere is no record");
    }

    public static void deleteRequest() {
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t--- Request Deletion ---\n");
        System.out.println("Enter the Project name to delete it\' request: ");
        String name = input.nextLine();
        boolean flag = false;
        for (int i = 0; i < RequestList.size(); i++) {
            if (RequestList.get(i).project.projectName.equalsIgnoreCase(name)) {
                RequestList.remove(i);
                flag = true;
                System.out.println("\n*Request DELETED SUCCESSFULLY*\n");
            }
        }
        if (flag == false)
            System.out.println("\nRequest IS NOT FOUND\n");

    }

    public static Request searchRequest() {
        Request searchedRequest = null;
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t--- Request Searching ---\n");
        System.out.println("Enter the Project Name to search the request: ");
        String name = input.nextLine();
        boolean flag = false;
        for (int i = 0; i < RequestList.size(); i++) {
            if (RequestList.get(i).project.projectName.equalsIgnoreCase(name)
                    || RequestList.get(i).project.projectName.contains(name)) {
                searchedRequest = RequestList.get(i);
            }
        }
        return searchedRequest;
    }

}
