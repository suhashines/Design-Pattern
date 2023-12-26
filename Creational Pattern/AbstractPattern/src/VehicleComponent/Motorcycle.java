package VehicleComponent;

public interface Motorcycle {
    void createTyre();
    void addEngine();
}

class ToyotaMotorcycle implements Motorcycle{
    public void createTyre(){
        System.out.println("Toyota Tyre");
    }
    public void addEngine(){
        System.out.println("Toyota engine");
    }
}
class HondaMotorcycle implements Motorcycle{
    public void createTyre(){
        System.out.println("Honda Tyre");
    }
    public void addEngine(){
        System.out.println("Honda engine");
    }
}
