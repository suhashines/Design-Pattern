package CarBuilder;

public class ManualBuilder implements Builder {
    
    private Manual manual ;

    ManualBuilder(){
        reset();
    }

    public void reset() {
        manual = new Manual();
    }

    public void buildEngine(String engine) {
        manual.engineDescription = engine ;
    }

    public void buildModel(String model) {
        manual.modelDescription = model;
    }

    public void buildSeats(int seats){

        manual.seatsDescription = Integer.toString(seats);

    }

    public Manual getManual() {
        reset();
        return manual;
    }
}
