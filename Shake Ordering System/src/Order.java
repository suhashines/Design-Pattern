import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Shake> shakes ;
    private boolean isClosed ;

    Order(){
        shakes = new ArrayList<>();
        isClosed = true ;
    }

    public void openOrder(){
        isClosed = false ;
    }

    public boolean isClosed(){
        return isClosed;
    }

    public void addShake(Shake shake){
        shakes.add(shake);
        System.out.println("---------------------------------");
        System.out.println(shake.name+" has been added to order");
        System.out.println("-------------------------------------");
    }

    public void printOrderDetails(){

        double grandTotal = 0 ;

        System.out.println("\n\nPrinting order details");

        int count = 1 ;


        for(Shake shake:shakes){

            double total = 0 ;
            System.out.println("---------------------------------------");
            System.out.println("Item "+count+":  Name: "+shake.name);
            System.out.println("--------------------------");
            System.out.println("Base Ingredient: "+shake.baseIngredient.getName()+"\nBase Price: "+shake.baseIngredient.getPrice());
            System.out.println();
            total += shake.baseIngredient.getPrice();

            if(shake.hasExtraIngredient()){
                System.out.println("\tCustomization price:");

                for(Ingredient i:shake.extraIngredient){
                    System.out.println("\t"+i.getName()+", Extra Price: "+i.getPrice());
                    total += i.getPrice();
                }
            }
            System.out.println("--------------------");
            System.out.println("Total: "+total);
            grandTotal += total ;
            count++ ;
        }

        System.out.println("--------------------------------------");
        System.out.println("Total Shakes: "+shakes.size());
        System.out.println("Grand Total: "+grandTotal);
        System.out.println("---------------------------------------");
    }

    public void closeOrder(){

        if(shakes.size()==0){
            System.out.println("-------------------------------------");
            System.out.println("It is essential to have at least one item in the order\n----------------------------------");
            return ;
        }

        isClosed = true ;
    }
}
