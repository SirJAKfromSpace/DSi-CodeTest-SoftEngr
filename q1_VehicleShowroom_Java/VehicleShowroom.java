import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import vehicles.*;

public class VehicleShowroom {
    
    List<Vehicle> listofVehicles;
    String ownerName;

    public VehicleShowroom(){
        Scanner input = new Scanner(System.in);
        this.ownerName = input.next().trim();
        listofVehicles = new ArrayList<Vehicle>();
        System.out.println("----\nWelcome to "+ownerName+"'s Vehicle Showroom\n----");
    }

    /*
        Main Driver Function to run the Vehicle Showroom Java program
    */
    public static void main(String[] args){
        // Preloading Test Data
        Vehicle v = new Vehicle();
        NormalVehicle n = new NormalVehicle("Toyota Axio", EngineType.Gas, 110, 15);
        SportsVehicle s = new SportsVehicle("Audi A7", 335, 20, 6);
        HeavyVehicle h = new HeavyVehicle("Ford Ranger", 270, 18, 3.2);
        
        VehicleShowroom show = new VehicleShowroom();
        show.listofVehicles.add(v);
        show.listofVehicles.add(n);
        show.listofVehicles.add(s);
        show.listofVehicles.add(h);

        printAllVehiclesDeets(show.listofVehicles);
    }
    

    public static void printAllVehiclesDeets(List<Vehicle> lVehicles){
        int itercount = 0;
        for(Vehicle iterVeh : lVehicles){
            System.out.print(String.format("%02d",itercount++)+" ");
            iterVeh.printDetails();
            System.out.println("------");
        }
    }
}