package backend;

import backend.shake.IngredientImpl;
import backend.shake.ShakeBuilder;
import backend.shake.ShakeBuilderImpl;

public class ShakeDirectorImpl implements ShakeDirector {
    @Override
    public ShakeBuilder getChocolateShakeBuilder() {
        return new ShakeBuilderImpl()
                .setName(ShakeTemplate.CHOCOLATE_SHAKE.toString())
                .setBasePrice(ShakeTemplate.CHOCOLATE_SHAKE.getBasePrice())
                .addIngredient(IngredientImpl.REGULAR_MILK)
                .addIngredient(IngredientImpl.REGULAR_SUGAR)
                .addIngredient(IngredientImpl.CHOCOLATE_SYRUP)
                .addIngredient(IngredientImpl.CHOCOLATE_ICE_CREAM);
    }

    @Override
    public ShakeBuilder getCoffeeShakeBuilder() {
        return new ShakeBuilderImpl()
                .setName(ShakeTemplate.COFFEE_SHAKE.toString())
                .setBasePrice(ShakeTemplate.COFFEE_SHAKE.getBasePrice())
                .addIngredient(IngredientImpl.REGULAR_MILK)
                .addIngredient(IngredientImpl.REGULAR_SUGAR)
                .addIngredient(IngredientImpl.COFFEE)
                .addIngredient(IngredientImpl.REGULAR_JELLO);
    }

    @Override
    public ShakeBuilder getStrawberryShakeBuilder() {
        return new ShakeBuilderImpl()
                .setName(ShakeTemplate.STRAWBERRY_SHAKE.toString())
                .setBasePrice(ShakeTemplate.STRAWBERRY_SHAKE.getBasePrice())
                .addIngredient(IngredientImpl.REGULAR_MILK)
                .addIngredient(IngredientImpl.REGULAR_SUGAR)
                .addIngredient(IngredientImpl.STRAWBERRY_SYRUP)
                .addIngredient(IngredientImpl.STRAWBERRY_ICE_CREAM);
    }

    @Override
    public ShakeBuilder getVanillaShakeBuilder() {
        return new ShakeBuilderImpl()
                .setName(ShakeTemplate.VANILLA_SHAKE.toString())
                .setBasePrice(ShakeTemplate.VANILLA_SHAKE.getBasePrice())
                .addIngredient(IngredientImpl.REGULAR_MILK)
                .addIngredient(IngredientImpl.REGULAR_SUGAR)
                .addIngredient(IngredientImpl.VANILLA_FLAVORING)
                .addIngredient(IngredientImpl.REGULAR_JELLO);
    }

    @Override
    public ShakeBuilder getZeroShakeBuilder() {
        return new ShakeBuilderImpl()
                .setName(ShakeTemplate.ZERO_SHAKE.toString())
                .setBasePrice(ShakeTemplate.ZERO_SHAKE.getBasePrice())
                .addIngredient(IngredientImpl.REGULAR_MILK)
                .addIngredient(IngredientImpl.ARTIFICIAL_SWEETENER)
                .addIngredient(IngredientImpl.VANILLA_FLAVORING)
                .addIngredient(IngredientImpl.SUGAR_FREE_JELLO);
    }

    @Override
    public ShakeBuilder getAppropriateBuilder(ShakeTemplate template) {
        switch (template) {
            case CHOCOLATE_SHAKE: {
                return getChocolateShakeBuilder();
            }
            case COFFEE_SHAKE: {
                return getCoffeeShakeBuilder();
            }
            case STRAWBERRY_SHAKE: {
                return getStrawberryShakeBuilder();
            }
            case VANILLA_SHAKE: {
                return getVanillaShakeBuilder();
            }
            case ZERO_SHAKE: {
                return getZeroShakeBuilder();
            }
            default: {
                return new ShakeBuilderImpl();
            }
        }
    }
}
