package PegAdapter;

public class Client {
    
    public static void main(String[] args) {
        
        RoundHole hole = new RoundHole(5);
        RoundPeg peg = new RoundPeg(6);

        // System.out.println(hole.fits(peg));

        SquarePeg square = new SquarePeg(5);

        SquarePegAdapter adapter = new SquarePegAdapter(square);


        System.out.println(hole.fits(adapter));
    }
}
