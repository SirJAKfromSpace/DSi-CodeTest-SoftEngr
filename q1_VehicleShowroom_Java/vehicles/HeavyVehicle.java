package vehicles;

public class HeavyVehicle extends Vehicle{
    private double weight;

    public HeavyVehicle(String m, double p, double t, double w){
        super(m, EngineType.Oil, p, t);
        this.weight = w;
        // System.out.println("Heavy");
    }
}