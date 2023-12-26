package PegAdapter;

public class RoundHole {
    private double radius;

    RoundHole(double radius) {
        this.radius = radius;
    }

    boolean fits(RoundPeg peg){
        return radius>=peg.getRadius();
    }
}
