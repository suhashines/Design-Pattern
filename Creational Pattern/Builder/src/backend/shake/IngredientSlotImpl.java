package backend.shake;

public enum IngredientSlotImpl implements IngredientSlot {

    MILK_SLOT(true, true),
    SWEETENER_SLOT(true, true),
    BASE_SLOT(false, true),
    ADDON_SLOT(false, false);

    private final boolean acceptsSingleIngredient;
    private final boolean mandatory;
    IngredientSlotImpl(boolean acceptsSingleIngredient, boolean mandatory) {
        this.acceptsSingleIngredient = acceptsSingleIngredient;
        this.mandatory = mandatory;
    }

    @Override
    public boolean doesAcceptSingleIngredient() {
        return acceptsSingleIngredient;
    }

    @Override
    public boolean isMandatory() {
        return mandatory;
    }

}
