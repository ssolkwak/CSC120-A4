import java.util.ArrayList;

public class Train {

    private Engine engine;
    private ArrayList<Car> carsAttatched;

    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, fuelCapacity);
        this.carsAttatched = new ArrayList<>(nCars);
        for (int i = 1; i <= nCars; i++){
            this.carsAttatched.add(new Car(passengerCapacity));
        }
    }

    public Engine getEngine(){
        return this.engine;
    }

    public Car getCar(int i){
        return this.carsAttatched.get(i);
    }

    public int getMaxCapacity(){
        int totalCapacity = 0;
        for (Car c : this.carsAttatched){
            totalCapacity += c.getCapacity();
        }
        return totalCapacity;
    }

    public int seatsRemaining(){
        int totalRemaining = 0;
        for (Car c : this.carsAttatched){
            totalRemaining += c.seatsRemaining();
        }
        return totalRemaining;
    }

    public void printManifest(){
        for (Car c : this.carsAttatched){
            c.printManifest();
        }
    }

    public static void main(String[] args) {
        Train train = new Train(FuelType.STEAM, 100.00, 3, 2);
        Passenger sophia = new Passenger("Sophia");

        System.out.println(train.getMaxCapacity());
        train.getCar(1).addPassenger(sophia);
        train.seatsRemaining();
        train.printManifest();

    }
}
