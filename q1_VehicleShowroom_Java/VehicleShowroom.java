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
        System.out.println("Welcome to "+ownerName+"'s ");
    }

    public static void main(String[] args){
        System.out.println("HELLo World!");
        Vehicle v = new Vehicle("iubqe12", EngineType.Oil, 2.2, 5.5);
        NormalVehicle n = new NormalVehicle("rtpegr435", EngineType.Oil, 2.2, 5.5);
        SportsVehicle s = new SportsVehicle("ohrt640", 2.2, 5.5, 7);
        HeavyVehicle h = new HeavyVehicle("sdc978er", 2.2, 5.5, 100);
        
        VehicleShowroom show = new VehicleShowroom();


        show.listofVehicles.add(v);
        show.listofVehicles.add(n);
        show.listofVehicles.add(s);
        show.listofVehicles.add(h);

        System.out.println(show.listofVehicles);
    }
}