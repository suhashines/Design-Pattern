package backend.shake;

import java.math.BigDecimal;

public interface ShakeBuilder {
    ShakeBuilder setName(String name);
    ShakeBuilder setBasePrice(BigDecimal price);
    ShakeBuilder addIngredient(IngredientImpl ingredient);
    ShakeBuilder removeIngredient(IngredientImpl ingredient);
    ShakeBuilder clear();
    Shake build();
    IngredientImpl[] getIngredientsArray();
    BigDecimal getCurrentTotal();
}
