public interface Ingredient {
    String getName();
    double getPrice();
}

class ChocolateShakeIngredient implements Ingredient{

    @Override
    public String getName() {
        return "Chocolate syrap and Chocolate Ice-cream";
    }

    @Override
    public double getPrice() {
        return 230;
    }
}


class CoffeeShakeIngredient implements Ingredient{

    @Override
    public String getName() {
        return "Coffee and Jello";
    }

    @Override
    public double getPrice() {
        return 250;
    }
}

class StrawberryShakeIngredient implements Ingredient{

    @Override
    public String getName() {
        return "Strawberry syrap and strawberry ice cream";
    }

    @Override
    public double getPrice() {
        return 200;
    }
}

class VanillaShakeIngredient implements Ingredient{

    @Override
    public String getName() {
        return "Vanilla flavoring and jello";
    }

    @Override
    public double getPrice() {
        return 190;
    }
}

class ZeroShakeIngredient implements Ingredient{

    @Override
    public String getName() {
        return "Sweetener with vanilla flavoring and sugar free jello";
    }

    @Override
    public double getPrice() {
        return 240;
    }
}

class LactoseFreeIngredient implements Ingredient{

    @Override
    public String getName() {
        return "Lactose-free by substituting almond milk for regular milk";
    }

    @Override
    public double getPrice() {
        return 60;
    }
}

class CandyIngredient implements Ingredient{

    @Override
    public String getName() {
        return "Candy added on top" ;
    }

    @Override
    public double getPrice() {
        return 50;
    }
}

class CookieIngredient implements Ingredient{

    @Override
    public String getName() {
        return "Cookie added on top";
    }

    @Override
    public double getPrice() {
        return 40;
    }
}


