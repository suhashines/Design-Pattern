package backend;

import backend.shake.ShakeBuilder;

public interface ShakeDirector {
    ShakeBuilder getChocolateShakeBuilder();
    ShakeBuilder getCoffeeShakeBuilder();
    ShakeBuilder getStrawberryShakeBuilder();
    ShakeBuilder getVanillaShakeBuilder();
    ShakeBuilder getZeroShakeBuilder();
    ShakeBuilder getAppropriateBuilder(ShakeTemplate template);
}
