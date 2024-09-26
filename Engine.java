public class Engine {

    private FuelType f;
    private double currentFuelLevel;
    private double maxFuelLevel;

    public Engine(FuelType f, double maxFuelLevel){
        this.f = f;
        this.currentFuelLevel = maxFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }

    public FuelType getFuelType(){
        return this.f;
    }

    public double getCurrentFuelLevel(){
        return this.currentFuelLevel;
    }

    public double getMaxFuelLevel(){
        return this.maxFuelLevel;
    }

    public void refuel(){
        this.currentFuelLevel = this.getMaxFuelLevel();
    }

    public boolean go(){
        this.currentFuelLevel -= 20;
        System.out.printf("Remaining fuel level: %f \n", this.getCurrentFuelLevel());
        if (this.currentFuelLevel > 0){
            return true;
        } else {
            return false;
        }
    } 

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
        myEngine.refuel();
        System.out.println(myEngine.getCurrentFuelLevel());
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
    }
}
