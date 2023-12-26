import java.util.Scanner;

public class Main {

    public static Bank initializeBank(){

        Bank bank = new Bank();

        System.out.print("\nBank Created;");

        ManagingDirector md = new ManagingDirector("MD");

        System.out.print("MD,");

        bank.addManagingDirector(md);

        Officer officer1 = new Officer("S1");

        bank.addOfficer(officer1);

        Officer officer2 = new Officer("S2");

        bank.addOfficer(officer2);

        System.out.print("S1,S2");

        for (int i = 1; i <= 5; i++) {
            String name = "C" + i;
            Cashier cashier = new Cashier(name);

            bank.addCashier(cashier);
            System.out.print(","+name);
        }

        System.out.println(" Created");

        return bank;

    }

    public static void main(String[] args) {

        Bank bank = initializeBank();

        String command;

        String start ;

        Scanner scn = new Scanner(System.in);



        while (true) {

            Account accountSession = null;
            Employee employeeSession = null ;

            do {

                command = scn.next();


                if (command.equalsIgnoreCase("Create") && accountSession==null && employeeSession==null) {

                    String name = scn.next();

                    Account account = bank.isAvailable(name);

                    if (account == null){

                        String type = scn.next();

                        double deposit = scn.nextDouble();

                        if(type.equalsIgnoreCase("savings")){

                            account = new Savings(name,deposit);


                        }else if(type.equalsIgnoreCase("student")){
                            account = new Student(name,deposit) ;
                        }else{

                            if(deposit<100000){
                                System.out.println("Amount should at least be 100000");
                                break;
                            }else{
                                account = new FixedDeposit(name,deposit);
                            }

                        }

                        bank.addAccount(account);

                        accountSession = account ;

                    }else{
                        System.out.println("Account already exists.");
                    }


                }else if(command.equalsIgnoreCase("deposit") && accountSession!=null){

                    double deposit = scn.nextDouble();

                    bank.depositMoney(accountSession,deposit);

                }else if(command.equalsIgnoreCase("close")){
                     if(accountSession!=null)
                        System.out.println("Transaction Closed for "+accountSession.getName());
                    else if(employeeSession!=null)
                         System.out.println("Operations for "+employeeSession.getName()+" closed");

                }else if(command.equalsIgnoreCase("query") && accountSession!=null){
                    accountSession.query();
                }else if(command.equalsIgnoreCase("withdraw") && accountSession!=null){

                    double amount = scn.nextDouble();

                    bank.withdraw(accountSession,amount);

                }else if(command.equalsIgnoreCase("Request") && accountSession!=null){

                    double loan = scn.nextDouble();

                    bank.requestLoan(accountSession,loan);

                }else if(command.equalsIgnoreCase("open") && accountSession==null && employeeSession==null){

                    String name = scn.next();

                    accountSession = bank.isAvailable(name);
                    employeeSession = bank.findEmployee(name);

                    if(accountSession!=null){

                        System.out.println("Welcome Back "+accountSession.getName());

                    }else if(employeeSession!=null){

                        System.out.print(employeeSession.getName()+" active");

                        if(bank.hasPendingLoan())
                            System.out.println(", there are loan approvals pending");
                        else
                            System.out.println();
                    }


                }else if(command.equalsIgnoreCase("Approve") && employeeSession!=null){
                    bank.approveLoan(employeeSession) ;
                }else if(command.equalsIgnoreCase("Lookup") && employeeSession!=null){
                    String name = scn.next();

                    bank.lookup(name);
                }else if(command.equalsIgnoreCase("Inc") && employeeSession==null && accountSession==null){
                    bank.incrementYear();
                }else if(command.equalsIgnoreCase("See") && employeeSession!=null){
                    bank.showInternalFund(employeeSession);
                }else if(command.equalsIgnoreCase("Change") && employeeSession!=null){
                    String type = scn.next();
                    double depositInterest = scn.nextDouble();

                    bank.changeInterestRate(employeeSession,type,depositInterest);
                }


            } while (!command.equalsIgnoreCase("close"));
        }
    }
}
