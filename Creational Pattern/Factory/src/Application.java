public class Application {
    public static void main(String[] args) {
        Transport t = new RoadLogistics().createTransport();
        t.load();
        Transport t2 = new SeaLogistics().createTransport();
        t2.load();
    }
}
