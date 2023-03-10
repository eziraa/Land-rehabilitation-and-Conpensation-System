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
    static ArrayList<LandOwner> LandOwners;
    static ArrayList<Request> RequestList;
    static ArrayList<Request> landRequestList;

    public Request() {

    }

    public Request(Address address, Project project, Date request_date) {

    }

    public Request(ArrayList<LandOwner> LandOwners, Address address, Project project, Date request_date) {

    }

    public Date getrequest_date() {
        return;
    }

    public void setrequest_date(Date request_date) {

    }

    public static ArrayList<Request> request_land() {

        return;
    }

    public static ArrayList<Request> countProperty(String name) {

        return;
    }

    public static void seeRequests() {

    }

    /**
     * 
     */
    public static void seeinfo() {

    }

    public void seeRequest() {
    }

    public static void notifyLandOwner(String name) {

    }

    public static void makeCompensation() {

    }

    public static void deleteRequest() {

    }

    public static Request searchRequest() {
        
        }return;
}

}
