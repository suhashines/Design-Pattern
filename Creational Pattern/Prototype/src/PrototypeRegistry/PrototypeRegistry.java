package PrototypeRegistry;
import java.util.ArrayList;

public class PrototypeRegistry {

    ArrayList<Prototype> items ;

    PrototypeRegistry(){
        items = new ArrayList<>();
    }

    void addItem(Prototype prototype){
        items.add(prototype);
    }

    Prototype getByColor(String color){
        
        for(Prototype item:items){
            if(item.getColor().equalsIgnoreCase(color)){
                return item.getClone();
            }
        }

        return null;
    }


}
