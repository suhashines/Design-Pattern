import java.util.ArrayList;
import java.util.List;

abstract class Shake {
    protected String name ;
    protected Ingredient baseIngredient ;

    protected List<Ingredient> extraIngredient;

    Shake(String name,Ingredient baseIngredient){
        this.name = name ;
        this.baseIngredient = baseIngredient;
        extraIngredient =new ArrayList<>() ;
    }

    void customizeShake(Ingredient ingredient){
        extraIngredient.add(ingredient);
    }

    public void makeLactoseFree() {
        extraIngredient.add(new LactoseFreeIngredient());
    }

    public void addCandy(){
        extraIngredient.add(new CandyIngredient());
    }

    public void addCookie(){
        extraIngredient.add(new CookieIngredient());
    }

    public boolean hasExtraIngredient(){
        return extraIngredient.size()!=0 ;
    }
}

class CoffeeShake extends Shake{


    CoffeeShake() {
        super("Coffee Shake",new CoffeeShakeIngredient());
    }

}

class ChocolateShake extends Shake{

    ChocolateShake(){
        super("Chocolate Shake",new ChocolateShakeIngredient());
    }
}

class StrawberryShake extends Shake{
    StrawberryShake(){
        super("Strawberry Shake",new StrawberryShakeIngredient());
    }
}

class VanillaShake extends Shake{
    VanillaShake(){
        super("Vanilla Shake",new VanillaShakeIngredient());
    }
}

class ZeroShake extends Shake{
    ZeroShake(){
        super("Zero shake",new ZeroShakeIngredient());
    }
}
