package vehicles;
// import vehicles.EngineType;

public class Vehicle{
    private String modelNumber;
    private EngineType engineType;
    private double enginePower;
    private double tireSize;

    public Vehicle(){
        this.modelNumber = "Unknown";
        this.engineType = EngineType.Gas;
        this.enginePower = 1;
        this.tireSize = 1;
        // System.out.println("Vehicle created: "+modelNumber);
    }

    public Vehicle(String m, EngineType et, double p, double t){
        this.modelNumber = m;
        this.engineType = et;
        this.enginePower = p;
        this.tireSize = t;
        // System.out.println("Vehicle created: "+modelNumber);
    }

    public void printDetails(){
        System.out.println(">> "+this.getClass().getSimpleName());
        System.out.println("Model Name: "+modelNumber);
        System.out.println("Type: "+engineType+" Engine");
        System.out.println("Power: "+enginePower+" horsepower");
        System.out.println("Tire Size: "+tireSize+" inches");
    }

    public String getModelName(){
        return modelNumber;
    }
}