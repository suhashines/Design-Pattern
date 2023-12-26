enum ShakeType{
        CHOCOLATE,
        COFFEE,
        STRAWBERRY,
        VANILLA,
        ZERO
}

public class ShakeFactory {

    public Shake getShake(ShakeType type){

        if(type==ShakeType.CHOCOLATE){
            return new ChocolateShake();
        }

        if(type==ShakeType.COFFEE){
            return new CoffeeShake();
        }

        if(type==ShakeType.VANILLA){
            return new VanillaShake();
        }

        if(type==ShakeType.STRAWBERRY){
            return new StrawberryShake();
        }

        if(type==ShakeType.ZERO){
            return new ZeroShake();
        }

        return null ;
    }

}
