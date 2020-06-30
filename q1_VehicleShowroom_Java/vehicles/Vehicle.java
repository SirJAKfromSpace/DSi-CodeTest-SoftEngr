package vehicles;
import vehicles.EngineType;

public class Vehicle{
    private String modelNumber;
    private EngineType engineType;
    private double enginePower;
    private double tireSize;

    public Vehicle(String m, EngineType et, double p, double t){
        this.modelNumber = m;
        this.engineType = et;
        this.enginePower = p;
        this.tireSize = t;
        // System.out.println("Vehicle created: "+modelNumber);
    }
}