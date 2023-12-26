package Game;

public class Client {

    public static void main(String[] args) {
        PrototypeRegistry registry = new PrototypeRegistry();
        Characters doraemon = new Characters("Doraemon");
        doraemon.agility = 10 ;
        registry.addCharacter(doraemon);

        Characters agileDoraemon = registry.getCharacter(doraemon.name);

        agileDoraemon.strength = 100 ;

        registry.addCharacter(agileDoraemon);

        Characters agileAndStrongDoraemon = registry.getCharacter(agileDoraemon.name);

        System.out.println("final doraemon "+agileAndStrongDoraemon.agility+" "+agileAndStrongDoraemon.strength);
    }
    

}
