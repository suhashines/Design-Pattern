package Game;

import java.util.HashMap;

public interface Prototype {
    Characters getClone();
}

class Characters implements Prototype {
    String name;
    int strength;
    int agility;
    //add other attributes
    Characters(String name){
        this.name = name;
    }

    Characters(Characters character){
       this.name = character.name;
        this.strength = character.strength;
        this.agility = character.agility;
    }

    @Override
    public Characters getClone() {
        Characters character = new Characters(this);
        return character;
    }
}

class PrototypeRegistry{
    HashMap<String,Characters> map ;

    PrototypeRegistry(){
        map = new HashMap<>();
    }

    void addCharacter(Characters character){
        if(map.containsKey(character.name)){
            map.remove(character.name);
        }
        map.put(character.name,character);
    }

    Characters getCharacter(String name){
        return map.get(name).getClone();
    }
}
