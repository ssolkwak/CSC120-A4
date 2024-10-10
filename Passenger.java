/**
 * Represents a passenger
 */
public class Passenger {
    // Passenger attribute
    private String name;

    /**
     * Passenger constructor
     * @param name name of passenger
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Getter for name
     * @return name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Passenger boards the car; if unable, prints that car is full
     * @param c car
     */
    public void boardCar(Car c){
        try{
            c.addPassenger(this);
        } catch (Exception e){
            System.out.println("This car is FULL.");
        }
    }

    /**
     * Passenger gets off the car; if not found, prints that the passenger is not onboard
     * @param c car
     */
    public void getOffCar(Car c){
        try{
            c.removePassenger(this);
        } catch (Exception e){
            System.out.println("Passenger is not onboard.");
        }
    }
}
