package backend;

import backend.shake.IngredientImpl;

import java.math.BigDecimal;

public class OrderOption {
    final IngredientImpl previous;
    final IngredientImpl current;

    OrderOption(IngredientImpl previous, IngredientImpl current) {
        if (previous == null && current == null) {
            throw new RuntimeException("OrderOption(null, null) called");
        }
        this.previous = previous;
        this.current = current;
    }

    @Override
    public String toString() {
        if (previous == null && current == null) {
            throw new RuntimeException("Invalid order option");
        }
        if (previous == null) {
            BigDecimal price = current.getPrice();
            String str = "Add " + current;
            if (price != null) {
                str += " (" + price + " Tk)";
            }
            return str;
        }
        if (current == null) {
            BigDecimal price = previous.getPrice();
            String str = "Remove " + previous;
            if (price != null) {
                str += " (" + price.negate() + " Tk)";
            }
            return str;
        }
        String str = "Substitute " + previous + " with " + current;
        BigDecimal currentPrice = current.getPrice();
        if (currentPrice == null) {
            currentPrice = new BigDecimal(0);
        }
        BigDecimal previousPrice = previous.getPrice();
        if (previousPrice == null) {
            previousPrice = new BigDecimal(0);
        }

        BigDecimal cost = currentPrice.subtract(previousPrice);
        if (cost.compareTo(new BigDecimal(0)) != 0) {
            str += " (" + cost +" Tk)";
        }

        return str;
    }


}
