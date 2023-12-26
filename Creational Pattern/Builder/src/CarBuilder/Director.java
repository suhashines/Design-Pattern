package CarBuilder;

public class Director {

    public void BuildSUV(Builder builder){
        builder.reset();
        builder.buildModel("SUV");
        builder.buildSeats(10);
        builder.buildEngine("High Performance Engine");
    }

    public void BuildMercedese(Builder builder){
        builder.reset();
        builder.buildModel("Mercedese");
        builder.buildSeats(10);
        builder.buildEngine("High Performance Engine");
    }
}
