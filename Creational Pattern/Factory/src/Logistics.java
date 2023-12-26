public abstract class Logistics {
    public void planDelivery(){
        System.out.println("common for both");
    }

    public abstract Transport createTransport();
}
