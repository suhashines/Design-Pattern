package CarBuilder;

public class CarBuilder implements Builder {
    
    private Car car ;

    CarBuilder(){
        reset();
    }

    public void reset() {
        car = new Car();
    }

    public void buildEngine(String engine) {
        car.engine = engine ;
    }

    public void buildModel(String model) {
        car.model = model;
    }

    public void buildSeats(int seats){
        car.seats = seats;
    }

    Car getCar(){
        Car temp = car;
        reset();
        return temp;
    }
}
