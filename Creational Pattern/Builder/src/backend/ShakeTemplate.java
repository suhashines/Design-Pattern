package backend;

import java.math.BigDecimal;

public enum ShakeTemplate {
    CHOCOLATE_SHAKE("Chocolate Shake", new BigDecimal(230)),
    COFFEE_SHAKE("Coffee Shake", new BigDecimal(250)),
    STRAWBERRY_SHAKE("Strawberry Shake", new BigDecimal(200)),
    VANILLA_SHAKE("Vanilla Shake", new BigDecimal(100)),
    ZERO_SHAKE("Zero Shake", new BigDecimal(240));

    private final String name;
    private final BigDecimal basePrice;

    ShakeTemplate(String name, BigDecimal basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return name;
    }
}
