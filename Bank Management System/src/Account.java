public class Account {
    private String name ;
    private double deposit ;

    private double loan ;


    public double serviceCharge ;

    public double loanInterest ;

    public double depositInterest ;

    Account(String name,double deposit){
        this.name = name ;
        this.deposit = deposit;
        loan = 0 ;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return deposit ;
    }

    public void addDeposit(double amount){

        deposit += amount ;
    }

    public double getDeposit(){return deposit ;}

    public double getLoan(){return loan ;}



    public void query(){

        System.out.print("Current Balance "+deposit+"$");

        if(loan!=0)
            System.out.println(",loan "+loan+"$");
        else
            System.out.println();
    }

    public void withdraw(double amount){
        deposit -= amount ;
    }

    public void grantLoan(double amount){

        loan += amount ;
        deposit += amount ;
    }


    public double loanableInterest(){
        return loan*loanInterest;
    }


    public double updateAccount(){

        double newDeposit = deposit + deposit*depositInterest ;

        double billToPay = serviceCharge + loan*loanInterest ;

        if(newDeposit>billToPay){
            deposit = newDeposit - billToPay ;
            return billToPay ;
        }else{
            loan = billToPay - newDeposit ;
            deposit = 0 ;
            return newDeposit ;
        }

    }


    public double depositedInterest() {
        return deposit*depositInterest;
    }
}

class Savings extends Account{
    Savings(String name,double deposit){
        super(name,deposit);
    }
}

class Student extends Account{
    Student(String name,double deposit){
        super(name,deposit);
    }
}

class FixedDeposit extends Account{
    FixedDeposit(String name,double deposit){
        super(name,deposit);
    }
}
