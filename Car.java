import java.util.ArrayList;

public class Car {

    private ArrayList<Passenger> passengersOnboard;
    private int maxCapacity;

    public Car(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.passengersOnboard = new ArrayList<>(maxCapacity);
    }

    public int getCapacity(){
        return this.maxCapacity;
    }

    public int seatsRemaining(){
        return this.maxCapacity - this.passengersOnboard.size();
    }

    public boolean addPassenger(Passenger p){
        if(this.seatsRemaining() > 0){
            this.passengersOnboard.add(p);
            return true;
        }else{
            return false;
        }
        
    }

    public boolean removePassenger(Passenger p){
        if(this.passengersOnboard.contains(p)){
            this.passengersOnboard.remove(p);
            return true;
        }else{
            return false;
        }
    }

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