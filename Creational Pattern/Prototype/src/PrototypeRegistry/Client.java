package PrototypeRegistry;

public class Client {
    
    public static void main(String[] args) {

        PrototypeRegistry registry = new PrototypeRegistry();

        Button b = new Button(0, 0, "blue");

        registry.addItem(b);

        Prototype bClone = registry.getByColor(b.getColor());

    }
}
