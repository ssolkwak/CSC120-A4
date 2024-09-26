public class Passenger {
    
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void boardCar(Car c){
        if(!c.addPassenger(this)){
            System.out.println("This car is FULL.");
        }
    }

    public void getOffCar(Car c){
        if(!c.removePassenger(this)){
            System.out.println("Passenger is not onboard.");
        }
    }
}
