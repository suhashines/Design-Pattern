package backend.shake;


import java.math.BigDecimal;

public enum IngredientImpl implements Ingredient {
    // milk slot
    REGULAR_MILK("Milk", null, IngredientSlotImpl.MILK_SLOT),
    ALMOND_MILK("Almond Milk", new BigDecimal(60), IngredientSlotImpl.MILK_SLOT),

    // sweetener slot
    REGULAR_SUGAR("Sugar", null, IngredientSlotImpl.SWEETENER_SLOT),
    ARTIFICIAL_SWEETENER("Sugar free sweetener", null, IngredientSlotImpl.SWEETENER_SLOT),

    // base slot
    CHOCOLATE_SYRUP("Chocolate Syrup", null, IngredientSlotImpl.BASE_SLOT),
    CHOCOLATE_ICE_CREAM("Chocolate Ice Cream", null, IngredientSlotImpl.BASE_SLOT),
    COFFEE("Coffee", null, IngredientSlotImpl.BASE_SLOT),
    REGULAR_JELLO("Jello", null, IngredientSlotImpl.BASE_SLOT),
    STRAWBERRY_SYRUP("Strawberry Syrup", null, IngredientSlotImpl.BASE_SLOT),
    STRAWBERRY_ICE_CREAM("Strawberry Ice Cream", null, IngredientSlotImpl.BASE_SLOT),
    VANILLA_FLAVORING("Vanilla Flavoring", null, IngredientSlotImpl.BASE_SLOT),
    SUGAR_FREE_JELLO("Sugar-free Jello", null, IngredientSlotImpl.BASE_SLOT),

    // addon slot
    CANDY("Candy", new BigDecimal(50), IngredientSlotImpl.ADDON_SLOT),
    COOKIE("Cookies", new BigDecimal(50), IngredientSlotImpl.ADDON_SLOT);


    private final String name;
    private final BigDecimal price;
    private final IngredientSlotImpl slot;

    IngredientImpl(String name, BigDecimal price, IngredientSlotImpl slot) {
        this.name = name;
        this.price = price;
        this.slot = slot;
    }


    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public IngredientSlotImpl getSlot() {
        return slot;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
