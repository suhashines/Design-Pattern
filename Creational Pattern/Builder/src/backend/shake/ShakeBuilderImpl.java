package backend.shake;

import java.math.BigDecimal;
import java.util.*;

public class ShakeBuilderImpl implements ShakeBuilder {
    private String shakeName;
    private BigDecimal basePrice;
    private final AbstractMap<IngredientSlotImpl, AbstractSet<IngredientImpl>> ingredients;


    public ShakeBuilderImpl() {
        ingredients = new EnumMap<>(IngredientSlotImpl.class);
        for (IngredientSlotImpl slot : IngredientSlotImpl.values()) {
            ingredients.put(slot, EnumSet.noneOf(IngredientImpl.class));
            if (slot.isMandatory()) {
                IngredientImpl i = Arrays.stream(IngredientImpl.values()).filter(e -> e.getSlot().equals(slot)).findFirst().get();
                ingredients.get(slot).add(i);
            }
        }
    }

    @Override
    public ShakeBuilder setName(String name) {
        shakeName = name;
        return this;
    }

    @Override
    public ShakeBuilder setBasePrice(BigDecimal price) {
        basePrice = price;
        return this;
    }

    @Override
    public ShakeBuilder addIngredient(IngredientImpl ingredient) {
        // this replaces previous if the slot demands substitution not addition
        if (ingredient.getSlot().doesAcceptSingleIngredient()) {
            ingredients.get(ingredient.getSlot()).clear();
        }
        ingredients.get(ingredient.getSlot()).add(ingredient);
        return this;
    }

    @Override
    public ShakeBuilder removeIngredient(IngredientImpl ingredient) {
        // it does not remove any mandatory ingredient
        if (!ingredient.getSlot().isMandatory()) {
            ingredients.get(ingredient.getSlot()).remove(ingredient);
        }
        return this;
    }

    @Override
    public ShakeBuilder clear() {
        for (IngredientSlotImpl slot : ingredients.keySet()) {
            if (!slot.isMandatory()) {
                ingredients.get(slot).clear();
            }
        }
        return this;
    }

    @Override
    public Shake build() {
        return new ShakeImpl(shakeName, basePrice, getIngredientsArray());
    }

    @Override
    public BigDecimal getCurrentTotal() {
        BigDecimal price = basePrice;
        for (IngredientSlotImpl slot : ingredients.keySet()) {
            for (IngredientImpl ingredient : ingredients.get(slot)) {
                BigDecimal ingredientPrice = ingredient.getPrice();
                if (ingredientPrice != null) {
                    price = price.add(ingredientPrice);
                }
            }
        }
        return price;
    }

    @Override
    public IngredientImpl[] getIngredientsArray() {
        List<IngredientImpl> ingredientList = new ArrayList<>();
        for (IngredientSlotImpl slot : ingredients.keySet()) {
            ingredientList.addAll(ingredients.get(slot));
        }
        IngredientImpl[] ret = new IngredientImpl[ingredientList.size()];
        for (int i = 0; i < ret.length; i += 1) {
            ret[i] = ingredientList.get(i);
        }
        return ret;
    }

}
