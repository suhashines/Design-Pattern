package VehicleComponent;

public class BrandFactory {
    VehicleFactory createVehicle(String brand){
        if(brand.equalsIgnoreCase("Toyota")){
            return new ToyotaFactory();
        }else if(brand.equalsIgnoreCase("Honda")){
            return new HondaFactory();
        }

        return null ;
    }
}
