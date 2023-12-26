package VehicleComponent;

//abstract factory

public interface VehicleFactory {
    Car createCar();
    Motorcycle createMotorcycle();
}

class ToyotaFactory implements VehicleFactory {
    public Car createCar(){
        return new ToyotaCar();
    }
    public Motorcycle createMotorcycle(){
        return new ToyotaMotorcycle();
    }
}
class HondaFactory implements VehicleFactory {
    public Car createCar(){
        return new HondaCar();
    }
    public Motorcycle createMotorcycle(){
        return new HondaMotorcycle();
    }
}


