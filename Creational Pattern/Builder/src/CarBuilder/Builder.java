package CarBuilder;

public interface Builder {
    
    void reset();
    void buildSeats(int seats);
    void buildEngine(String engine);
    void buildModel(String name);
}
