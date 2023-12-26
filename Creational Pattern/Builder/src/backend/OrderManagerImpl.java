package backend;

import backend.shake.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderManagerImpl implements OrderManager {
    private final ShakeDirector director;
    private ShakeBuilder builder;
    private ShakeTemplate ongoingShake;

    public OrderManagerImpl() {
        director = new ShakeDirectorImpl();
    }

    @Override
    public void openOrder(ShakeTemplate template) throws InvalidCommand {
        if (builder != null) {
            throw new InvalidCommand("Placing a new order before closing the ongoing order");
        }
        builder = director.getAppropriateBuilder(template);
        ongoingShake = template;
    }

    @Override
    public Shake closeOrder() throws InvalidCommand {
        if (builder == null) {
            throw new InvalidCommand("Closing a non existent order");
        }
        Shake shake = builder.build();
        builder = null;
        ongoingShake = null;
        return shake;
    }

    private void addIngredient(IngredientImpl ingredient) throws InvalidCommand {
        if (builder == null) {
            throw new InvalidCommand("Adding ingredient before opening any order");
        }
        builder.addIngredient(ingredient);
    }

    private void removeIngredient(IngredientImpl ingredient) throws InvalidCommand {
        if (builder == null) {
            throw new InvalidCommand("Adding ingredient before opening any order");
        }
        builder.removeIngredient(ingredient);
    }

    @Override
    public List<OrderOption> getAvailableCustomizeOptions() throws InvalidCommand {
        if (builder == null) {
            throw new InvalidCommand("Order options are invalid before placing any order");
        }

        List<OrderOption> options = new ArrayList<>();
        IngredientImpl[] ingredients = builder.getIngredientsArray();
        IngredientImpl[] allIngredients = IngredientImpl.values();

        for (IngredientImpl elem : ingredients) {

            IngredientSlot slot = elem.getSlot();
            
            if (!slot.isMandatory()) {
                options.add(new OrderOption(elem, null));
            }
            if (!slot.doesAcceptSingleIngredient()) {
                continue;
            }
            List<IngredientImpl> matchingSlotIngredients = Arrays.stream(allIngredients).
                    filter(e -> !e.equals(elem) && e.getSlot().equals(slot)).
                    collect(Collectors.toList());
            for (IngredientImpl sub : matchingSlotIngredients) {
                options.add(new OrderOption(elem, sub));
            }
        }

        List<IngredientImpl> ingredientList = Arrays.asList(ingredients);
        for (IngredientImpl elem: allIngredients) {
            if (!elem.getSlot().isMandatory() && !ingredientList.contains(elem)) {
                options.add(new OrderOption(null, elem));
            }
        }
        return options;
    }


    @Override
    public ShakeTemplate[] getAvailableShakes() {
        return ShakeTemplate.values();
    }


    @Override
    public void manageOrder(OrderOption option) throws InvalidCommand {
        if (option.previous == null && option.current == null) {
            throw new RuntimeException("Invalid order option");
        }
        if (option.current != null) {
            addIngredient(option.current);
        } else {
            removeIngredient(option.previous);
        }
    }

    @Override
    public Ingredient[] getCurrentIngredients() throws InvalidCommand {
        if (builder == null) {
            throw new InvalidCommand("Querying ingredients of a non existent order");
        }
        return builder.getIngredientsArray();
    }

    @Override
    public ShakeTemplate getOngoingShake() {
        return ongoingShake;
    }

    @Override
    public BigDecimal getCurrentTotal() throws InvalidCommand {
        if (builder == null) {
            throw new InvalidCommand("Querying total of a non existent order");
        }
        return builder.getCurrentTotal();
    }

}
