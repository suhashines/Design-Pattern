package PegAdapter;

public class SquarePegAdapter extends RoundPeg{
    private SquarePeg square;

    SquarePegAdapter(SquarePeg square){
        this.square = square;
    }

    double getRadius(){
        
        double w = square.getWidth();

        return w*0.5*Math.sqrt(2);
    }
}
