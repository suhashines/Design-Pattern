package CarBuilder;

public class Client {
    
    public static void main(String[] args) {
        
        CarBuilder carBuilder = new CarBuilder();
        carBuilder.buildModel("SUV");
        carBuilder.buildSeats(10);
        carBuilder.buildEngine("High Performance Engine");

        Car car = carBuilder.getCar(); //ultimate product must be fetched from respective builder

        //but instead of all these hustle we will now use director
        Director director = new Director();

        director.BuildSUV(carBuilder);
        Car suvCar = carBuilder.getCar();

        System.out.println("Got my SUV Car "+suvCar.engine+" "+suvCar.model);

        ManualBuilder manualBuilder = new ManualBuilder();
        director.BuildSUV(manualBuilder);

        Manual manual = manualBuilder.getManual();


    }
}
