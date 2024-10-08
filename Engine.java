/**
 * Represents the engine of the train
 */
public class Engine {
    //Engine attributes
    private FuelType f;
    private double currentFuelLevel;
    private double maxFuelLevel;

    /**
     * Engine constructor, engine is fueled to maximum fuel level
     * @param f fuel type
     * @param maxFuelLevel maximum fuel capacity
     */
    public Engine(FuelType f, double maxFuelLevel){
        this.f = f;
        this.currentFuelLevel = maxFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }

    /**
     * Getter for FuelType
     * @return the fuel type
     */
    public FuelType getFuelType(){
        return this.f;
    }

    /**
     * Getter for CurrentFuelLevel
     * @return current fuel level
     */
    public double getCurrentFuelLevel(){
        return this.currentFuelLevel;
    }

    /**
     * Getter for maxFuelLevel
     * @return maximum fuel level
     */
    public double getMaxFuelLevel(){
        return this.maxFuelLevel;
    }

    /**
     * Setter for currentFuelLevel; set fuel to max capacity
     */
    public void refuel(){
        this.currentFuelLevel = this.getMaxFuelLevel();
    }

    /**
     * Decrease the current fuel level and print remaining fuel level
     * @return T/F: if there is fuel left in engine
     */
    public boolean go(){
        this.currentFuelLevel -= 20;
        System.out.printf("Remaining fuel level: %f \n", this.getCurrentFuelLevel());
        if (this.currentFuelLevel > 0){
            return true;
        } else {
            return false;
        }
    } 

    /**
     * Test Engine methods
     */
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
