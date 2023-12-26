package backend.shake;

import java.math.BigDecimal;

class ShakeImpl implements Shake {
    final String name;
    final BigDecimal basePrice;
    final Ingredient[] ingredients;

    ShakeImpl(String name, BigDecimal basePrice, Ingredient[] ingredients) {
        this.name = name;
        this.basePrice = basePrice;
        this.ingredients = ingredients;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getBasePrice() {
        return basePrice;
    }

    @Override
    public Ingredient[] getIngredients() {
        return ingredients.clone();
    }
}
