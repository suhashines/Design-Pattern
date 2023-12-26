import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to Shake Ordering System\n");

        Scanner scn = new Scanner(System.in);

        Order currentOrder = null ;

        while (true) {

            if(currentOrder==null || currentOrder.isClosed())
                    System.out.println("->Proceed to order(o) ");
            else
                System.out.println("->Continue order(o)");

            System.out.println("->Order details(d)");
            System.out.println("->Exit(e)\n");

            char cmd ;

            System.out.print("Enter your choice: ");

            cmd = scn.next().charAt(0);

            if(cmd=='o'){

                if(currentOrder==null || currentOrder.isClosed()){

                    currentOrder = new Order();

                    currentOrder.openOrder();

                    System.out.println("New Order opened");
                }else{
                    System.out.println("Order is already opened");
                }


                printMenu();

                char choice = scn.next().charAt(0);

                ShakeFactory factory = new ShakeFactory();

                Shake shake = null;


                if (choice == '1') {

                    shake = factory.getShake(ShakeType.CHOCOLATE);

                } else if (choice == '2') {

                    shake = factory.getShake(ShakeType.COFFEE);

                } else if (choice == '3') {

                    shake = factory.getShake(ShakeType.STRAWBERRY);

                } else if (choice == '4') {
                    shake = factory.getShake(ShakeType.VANILLA);

                } else if (choice == '5') {

                    shake = factory.getShake(ShakeType.ZERO);

                }


                if(shake!=null){

                    System.out.println("1. Customize your shake");
                    System.out.println("2. Do not customize");
                    char custom = scn.next().charAt(0);


                    if(custom=='1'){

                        char customOption ;

                        System.out.println("Press 1 to add, 0 to skip");

                        System.out.print("Make Lactose free: ");

                        customOption = scn.next().charAt(0);

                        if(customOption=='1'){
                            shake.makeLactoseFree();
                        }

                        System.out.print("Add Candy on top: ");

                        customOption = scn.next().charAt(0);

                        if(customOption=='1'){
                            shake.addCandy();
                        }

                        System.out.print("Add Cookie on top: ");

                        customOption = scn.next().charAt(0);

                        if(customOption=='1'){
                            shake.addCookie();
                        }
                    }

                    System.out.print("Place order? 1 to confirm 0 to skip: ");

                    char confirmation = scn.next().charAt(0);

                    if(confirmation=='1'){
                        currentOrder.addShake(shake);
                    }


                }



            }else if(cmd=='e'){

                if(currentOrder==null){
                    System.out.println("No order was opened");
                }else{
                    currentOrder.closeOrder();
                }
            } else if (cmd=='d') {

                if(currentOrder==null){
                    System.out.println("No order was done");
                }else{

                    currentOrder.printOrderDetails();
                }

            }


        }

    }

    public static void printMenu(){
        String[] shakes ={"Chocolate","Coffee","Strawberry","Vanilla","Zero"};

        System.out.println("What would you like to have?");


       for(int i=0;i<shakes.length;i++){

           System.out.println("\t"+(i+1)+". "+shakes[i]+" Shake");
       }

        System.out.println("\t6. Back to Main menu");

        System.out.print("Enter your choice: ");
    }
}
