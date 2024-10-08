import java.util.ArrayList;

/**
 * Represents a train
 */
public class Train {

    // Train attributes
    private Engine engine;
    private ArrayList<Car> carsAttatched;

    /**
     * Train constructor; create Engine object and ArrayList of attatched cars
     * @param fuelType fuel type of engine
     * @param fuelCapacity max fuel capacity of engine
     * @param nCars number of cars attatched to the train
     * @param passengerCapacity passenger capacity for each car attatched
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, fuelCapacity);
        this.carsAttatched = new ArrayList<>();
        for (int i = 1; i <= nCars; i++){
            this.carsAttatched.add(new Car(passengerCapacity));
        }
    }

    /**
     * Getter for engine
     * @return engine
     */
    public Engine getEngine(){
        return this.engine;
    }

    /**
     * Getter for ith car of train
     * @param i index/location of the car
     * @return car
     */
    public Car getCar(int i){
        return this.carsAttatched.get(i);
    }

    /**
     * Gets maximum passenger capacity for the entire train
     * @return sum of all car's capacity
     */
    public int getMaxCapacity(){
        int totalCapacity = 0;
        for (Car c : this.carsAttatched){
            totalCapacity += c.getCapacity();
        }
        return totalCapacity;
    }

    /**
     * Gets number of all remaining seats in the train
     * @return sum of remaining seats in all cars
     */
    public int seatsRemaining(){
        int totalRemaining = 0;
        for (Car c : this.carsAttatched){
            totalRemaining += c.seatsRemaining();
        }
        return totalRemaining;
    }

    /**
     * Prints list of all passengers onboard by each car of the train
     */
    public void printManifest(){
        for (Car c : this.carsAttatched){
            c.printManifest();
        }
    }

    /**
     * Test Train methods
     * @param args
     */
    public static void main(String[] args) {
        Train train = new Train(FuelType.STEAM, 100.00, 3, 2);
        Passenger sophia = new Passenger("Sophia");

        System.out.println(train.getMaxCapacity());
        train.getCar(1).addPassenger(sophia);
        train.seatsRemaining();
        train.printManifest();

    }
}
