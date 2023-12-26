package VehicleComponent;

public interface Car {
    void createTyre();
    void addEngine();
}

class ToyotaCar implements Car{
    public void createTyre(){
        System.out.println("Toyota Tyre");
    }
    public void addEngine(){
        System.out.println("Toyota engine");
    }
}
class HondaCar implements Car{
    public void createTyre(){
        System.out.println("Honda Tyre");
    }
    public void addEngine(){
        System.out.println("Honda engine");
    }
}
