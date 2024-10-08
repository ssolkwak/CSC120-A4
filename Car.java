import java.util.ArrayList;

/**
 * Represents a Car of a train
 */
public class Car {
    //Car attributes
    private ArrayList<Passenger> passengersOnboard;
    private int maxCapacity;

    /**
     * Car constructor which creates ArrayList of passengers with capacity of maxCapacity
     * @param maxCapacity maximum passenger capacity of the car
     */
    public Car(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.passengersOnboard = new ArrayList<>(maxCapacity);
    }

    /**
     * Getter for maxCapacity
     * @return passenger capacity
     */
    public int getCapacity(){
        return this.maxCapacity;
    }

    /**
     * Gets number of open seats in the car
     * @return remaining seats
     */
    public int seatsRemaining(){
        return this.maxCapacity - this.passengersOnboard.size();
    }

    /**
     * Add a passenger to the car if the car is not full
     * @param p passenger to add
     * @return T/F: if the car has open seat and is able to add passenger
     */
    public boolean addPassenger(Passenger p){
        if(this.seatsRemaining() > 0){
            this.passengersOnboard.add(p);
            return true;
        }else{
            return false;
        }
        
    }

    /**
     * Remove a passenger from the car if the passenger is in the car
     * @param p passenger to remove
     * @return T/F: if the car has the passenger and is able to remove passenger 
     */
    public boolean removePassenger(Passenger p){
        if(this.passengersOnboard.contains(p)){
            this.passengersOnboard.remove(p);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Prints the list of all passengers in the car or prints that it is empty
     */
    public void printManifest(){
        if(this.passengersOnboard.size() > 0){
            System.out.println("Passengers Onboard:");
            for (Passenger p : this.passengersOnboard){
                System.out.println(p.getName());
            }
        }else{
            System.out.println("This car is EMPTY.");
        }
    }

    /**
     * Test Car methods
     * @param args
     */
    public static void main(String[] args) {
        Car car = new Car(3);
        Passenger sophia = new Passenger("Sophia");
        Passenger katherine = new Passenger("Katherine");
        Passenger vivian = new Passenger("Vivian");
        Passenger ruby = new Passenger("Ruby");

        car.printManifest();
        car.addPassenger(sophia);
        System.out.println(car.seatsRemaining());
        car.addPassenger(katherine);
        car.addPassenger(vivian);
        car.addPassenger(ruby);
        car.printManifest();
        ruby.boardCar(car);
        car.removePassenger(sophia);
        vivian.getOffCar(car);
        ruby.getOffCar(car);
        ruby.boardCar(car);
        car.printManifest();

    }
}