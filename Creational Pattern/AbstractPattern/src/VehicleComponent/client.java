package VehicleComponent;

public class client {
    
    public static void main(String[] args) {
        
        Car toyotaCar = new BrandFactory().createVehicle("Toyota").createCar();
        Car hondaCar = new BrandFactory().createVehicle("Honda").createCar();

        hondaCar.addEngine();
        hondaCar.createTyre();
    }
}
