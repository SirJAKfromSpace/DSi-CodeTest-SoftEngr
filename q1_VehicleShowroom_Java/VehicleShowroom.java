import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import vehicles.*;

public class VehicleShowroom {
    
    List<Vehicle> listofVehicles;
    public static Scanner input;
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public VehicleShowroom(){
        listofVehicles = new ArrayList<Vehicle>();
        System.out.println("\n\n---\nWelcome to JAK's Vehicle Showroom Program\n---");
    }

    /**
     * Displays a list of vehicles in the showroom list
     * @param shortList make the list short (true) or long and detailed (false)?
     * @return the number of expected visitors for the current vehicle listing
     */
    public int printAllVehiclesDeets(boolean shortList){
        if(listofVehicles.isEmpty()){
            System.out.println(ANSI_YELLOW+"---\nShowroom has 0 (zero) Vehicles to display\n---"+ANSI_RESET);
            return 0;
        }
        int itercount = 0;
        int visitors = 30;
        for(Vehicle iterVeh : listofVehicles){
            if(shortList){
                System.out.print(String.format("%02d",itercount++)+" ");
                String vtype = iterVeh.getClass().getSimpleName();
                System.out.println(iterVeh.getModelName()+" ["+vtype+"]");
                if(vtype.equals("SportsVehicle")) visitors += 20;
            }
            else{
                System.out.print(String.format("%02d",itercount++)+" ");
                iterVeh.printDetails();
                String vtype = iterVeh.getClass().getSimpleName();
                System.out.println(iterVeh.getModelName()+" ["+vtype+"]");
                if(vtype.equals("SportsVehicle")) visitors += 20;
                System.out.println("- - - - - -");
            }
        }
        return visitors;
    }

    
    /**
     * Main Driver Function to run the Vehicle Showroom Java program
     * @throws InterruptedException because of sleep()
     */
    public static void main(String[] args) throws InterruptedException {
        // Preloading Test Data
        Vehicle v1 = new Vehicle();
        NormalVehicle n1 = new NormalVehicle("Toyota Axio", EngineType.Gas, 110, 15);
        SportsVehicle s1 = new SportsVehicle("Audi A7", 335, 20, 6);
        HeavyVehicle h1 = new HeavyVehicle("Ford Ranger", 270, 18, 3.2);
        
        VehicleShowroom show = new VehicleShowroom();
        show.listofVehicles.add(v1);
        show.listofVehicles.add(n1);
        show.listofVehicles.add(s1);
        show.listofVehicles.add(h1);

        // show.printAllVehiclesDeets();
        Scanner in = new Scanner(System.in);
        int select = 1;
        
        while(select != 0){
            TimeUnit.SECONDS.sleep(2);
            printOptions();
            
            // Taking user input while bypassing invalid input errors
            try{ select = Integer.parseInt(in.nextLine()); }
            catch(NumberFormatException e) { System.out.println(ANSI_YELLOW+"Please enter Numbers not characters!"+ANSI_RESET); }
            if(select>4 || select<0){
                System.out.println(ANSI_YELLOW+"Number: "+select+" is not an option\nPlease try again!"+ANSI_RESET);
                continue;
            }
            
            // Option Routing
            switch(select){
                
                // Add Vehicle (a painfully long if-else tree, full of inputs that could go horribly wrong)
                case 1:
                    System.out.println("\n--- Add New Vehicle ---\nWhat type of vehicle to add?");
                    System.out.println("1. Normal  -  2.Sports  -  3. Heavy");
                    System.out.print("Enter Option [1-3]: ");
                    try{ select = Integer.parseInt(in.nextLine()); }
                    catch(NumberFormatException e) { 
                        System.out.println(ANSI_YELLOW+"Please enter Numbers not characters!\nGoing back"+ANSI_RESET);
                        break;
                    }
                    // Add Normal
                    if(select == 1){
                        System.out.println("\n--- Add Normal Vehicle ---");
                        System.out.print("Enter Model Number: ");
                        String m = in.nextLine();
                        
                        System.out.println("Select engine type \n1. Oil  -  2. Gas  -  3. Diesel");
                        try{ select = Integer.parseInt(in.nextLine()); }
                        catch(NumberFormatException e) { 
                            System.out.println(ANSI_YELLOW+"Please enter Numbers not characters!\nGoing back"+ANSI_RESET);
                            break;
                        }
                        EngineType et;
                        if(select == 1) et = EngineType.Oil;
                        else if(select == 2) et = EngineType.Gas; 
                        else if(select == 3) et = EngineType.Diesel; 
                        else{
                            System.out.println(ANSI_YELLOW+"Invalid Engine Type Selected - "+select+" "+ANSI_RESET);
                            break;
                        }

                        System.out.print("Enter Engine Power (in horsepower): ");
                        double p;
                        try{ p = Double.parseDouble(in.nextLine()); }
                        catch(NumberFormatException er) { 
                            System.out.println(ANSI_YELLOW+"Please enter Numbers not characters!\nGoing back"+ANSI_RESET);
                            break;
                        }

                        System.out.print("Enter Tire Size (in inches): ");
                        double t;
                        try{ t = Double.parseDouble(in.nextLine()); }
                        catch(NumberFormatException er) { 
                            System.out.println(ANSI_YELLOW+"Please enter Numbers not characters!\nGoing back"+ANSI_RESET);
                            break;
                        }

                        NormalVehicle tempv = new NormalVehicle(m, et, p, t);
                        show.listofVehicles.add(tempv);
                        System.out.println("New Normal Vehicle Added! " + m);
                    }
                    
                    // Add Sports
                    else if(select == 2){
                        System.out.println("\n--- Add Sports Vehicle ---");
                        System.out.print("Enter Model Number: ");
                        String m = in.nextLine();
                        
                        System.out.println("Enter Engine Power (in horsepower): ");
                        double p;
                        try{ p = Double.parseDouble(in.nextLine()); }
                        catch(NumberFormatException er) { 
                            System.out.println(ANSI_YELLOW+"Please enter Numbers not characters!\nGoing back"+ANSI_RESET);
                            break;
                        }

                        System.out.print("Enter Tire Size (in inches): ");
                        double t;
                        try{ t = Double.parseDouble(in.nextLine()); }
                        catch(NumberFormatException er) { 
                            System.out.println(ANSI_YELLOW+"Please enter Numbers not characters!\nGoing back"+ANSI_RESET);
                            break;
                        }
                        
                        System.out.print("Enter Turbo (in psi): ");
                        double tb;
                        try{ tb = Double.parseDouble(in.nextLine()); }
                        catch(NumberFormatException er) { 
                            System.out.println(ANSI_YELLOW+"Please enter Numbers not characters!\nGoing back"+ANSI_RESET);
                            break;
                        }

                        SportsVehicle tempv = new SportsVehicle(m, p, t, tb);
                        show.listofVehicles.add(tempv);
                        System.out.println("New Sports Vehicle Added! " + m);
                    }

                    // Add Heavy
                    else if(select == 3){
                        System.out.println("\n--- Add Heavy Vehicle ---");
                        System.out.print("Enter Model Number: ");
                        String m = in.nextLine();
                        
                        System.out.println("Enter Engine Power (in horsepower): ");
                        double p;
                        try{ p = Double.parseDouble(in.nextLine()); }
                        catch(NumberFormatException er) { 
                            System.out.println(ANSI_YELLOW+"Please enter Numbers not characters!\nGoing back"+ANSI_RESET);
                            break;
                        }

                        System.out.print("Enter Tire Size (in inches): ");
                        double t;
                        try{ t = Double.parseDouble(in.nextLine()); }
                        catch(NumberFormatException er) { 
                            System.out.println(ANSI_YELLOW+"Please enter Numbers not characters!\nGoing back"+ANSI_RESET);
                            break;
                        }
                        
                        System.out.print("Enter weight (in psi): ");
                        double w;
                        try{ w = Double.parseDouble(in.nextLine()); }
                        catch(NumberFormatException er) { 
                            System.out.println(ANSI_YELLOW+"Please enter Numbers not characters!\nGoing back"+ANSI_RESET);
                            break;
                        }

                        HeavyVehicle tempv = new HeavyVehicle(m, p, t, w);
                        show.listofVehicles.add(tempv);
                        System.out.println("New Heavy Vehicle Added! " + m);
                    }
                    else{
                        System.out.println(ANSI_YELLOW+"Number:"+select+" is not an option\nGoing back!"+ANSI_RESET);
                    }
                    break;
                
                // Remove a Vehicle from List
                case 2:
                    System.out.println("\n--- Remove Vehicle---");
                    show.printAllVehiclesDeets(true);
                    if(show.listofVehicles.size() == 0) break;
                    System.out.print("Enter index number of which vehicle you wish to remove: ");
                    try{ select = Integer.parseInt(in.nextLine()); }
                    catch(NumberFormatException e) { 
                        System.out.println(ANSI_YELLOW+"Please enter Numbers not characters!\nNothing was Removed."+ANSI_RESET);
                        break;
                    }
                    if(select<0 || select>=show.listofVehicles.size()){
                        System.out.println(ANSI_YELLOW+"Invalid Option!\nNothing was Removed"+ANSI_RESET);
                        select = 100;
                    }
                    else{
                        System.out.println("Removed: "+show.listofVehicles.get(select).getModelName());
                        show.listofVehicles.remove(select);
                        select = 100;
                    }
                    break;

                // Print All Details
                case 3:
                    System.out.println("\n--- Details of All Vehicles---");
                    show.printAllVehiclesDeets(false);
                    break;
                
                // List Vehicles and show Expected Visitor count
                case 4:
                    System.out.println("\n--- Listing of Vehicles ---");
                    int visitors = show.printAllVehiclesDeets(true);
                    System.out.println("--- Expected visitor count: "+visitors+" ---");
                    break;
            }
        }
        System.out.println("\nQuitting Showroom Program....");
        TimeUnit.SECONDS.sleep(2);
        in.close();
    }

    /**
     * Helper Function for console controls prompt
     */
    public static void printOptions(){
        System.out.println("\n--- What would you like to do? ---");
        System.out.println("1. Add a New Vehicle to showroom");
        System.out.println("2. Remove a Vehicle from the showroom");
        System.out.println("3. Show Details of All Vehicles in showroom");
        System.out.println("4. List All Vehicles and expected visitor count");
        System.out.println("0. Quit Vehicle Showroom Program");
        System.out.print("\nEnter your option number [0-4]: ");
    }
    


}