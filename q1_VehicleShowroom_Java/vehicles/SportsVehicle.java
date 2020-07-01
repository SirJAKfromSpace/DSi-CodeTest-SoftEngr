package vehicles;

public class SportsVehicle extends Vehicle{
    private double turbo;

    public SportsVehicle(String m, double p, double t, double tb){
        super(m, EngineType.Oil, p, t);
        // System.out.println("Sports");
        this.turbo = tb;
    }

    @Override
    public void printDetails(){
        super.printDetails();
        System.out.println("Turbo: "+turbo+" psi");
    }
}