package backend;

import backend.shake.Ingredient;
import backend.shake.InvalidCommand;
import backend.shake.Shake;

import java.math.BigDecimal;
import java.util.List;

public interface OrderManager {
    void openOrder(ShakeTemplate template) throws InvalidCommand;

    Shake closeOrder() throws InvalidCommand;

    List<OrderOption> getAvailableCustomizeOptions() throws InvalidCommand;

    ShakeTemplate[] getAvailableShakes();

    void manageOrder(OrderOption option) throws InvalidCommand;

    Ingredient[] getCurrentIngredients() throws InvalidCommand;
    ShakeTemplate getOngoingShake();
    BigDecimal getCurrentTotal() throws InvalidCommand;
}
