package backend.shake;

import java.math.BigDecimal;

public interface Ingredient {


    String getName();
    BigDecimal getPrice();

    IngredientSlotImpl getSlot();
}
