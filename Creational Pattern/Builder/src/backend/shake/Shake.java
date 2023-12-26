package backend.shake;

import java.math.BigDecimal;

public interface Shake {
    String getName();
    BigDecimal getBasePrice();
    Ingredient[] getIngredients();
}
