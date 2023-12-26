import java.util.ArrayList;
import java.util.List;

public class Bank {

    private double internalFund ;

    private final double serviceCharge = 500 ; // only applicable for savings and fixed deposit

    private double savingsInterest ;

    private double studentInterest ;

    private double fixedDepositInterest ;

    private double loanInterest ;

    private int  year ;

    private List<Employee> employees;

    private List<Account> accounts ;

    private List<Loan> loanRequests ;

    private int pending ;

    Bank(){

        savingsInterest = 0.1 ;
        studentInterest = 0.05 ;
        fixedDepositInterest = 0.15 ;
        loanInterest = 0.10 ;

        internalFund = 1000000 ;

        pending = 0 ;

        year = 0 ;

        employees = new ArrayList<>();

        accounts = new ArrayList<>() ;

        loanRequests = new ArrayList<>();
    }

    public void addManagingDirector(ManagingDirector md){
        employees.add(md) ;
    }

    public void addOfficer(Officer officer){
        employees.add(officer);
    }


    public void addCashier(Cashier cashier){
        employees.add(cashier);
    }

    public Account isAvailable(String name){

        for(Account account : accounts){

            if(account.getName().equalsIgnoreCase(name))
                return account;
        }

        return null ;
    }

    public Employee findEmployee(String name){

        for(Employee emp : employees){
            if(emp.getName().equalsIgnoreCase(name))
                return emp;
        }

        return null ;

    }

    private double findDepositInterest(Account account){

        if(account instanceof Savings){
            return savingsInterest ;
        }else if(account instanceof Student){
            return studentInterest ;
        }else{
            return fixedDepositInterest ;
        }
    }


    public void addAccount(Account account) {

        account.depositInterest = findDepositInterest(account);

        account.loanInterest = loanInterest ;

        if(account instanceof Student){
            account.serviceCharge = 0 ;
        }else{
            account.serviceCharge = serviceCharge ;
        }

        accounts.add(account);

        internalFund += account.getDeposit();

        System.out.println(account.getClass().getSimpleName() + " account for "+account.getName()+" Created;Initial balance "+account.getBalance()+"$");
    }


    public void depositMoney(Account account,double amount){

        if((account instanceof FixedDeposit) && amount<50000){
            System.out.println("Invalid Transaction. Amount must at least be 50000");
            return ;
        }


        account.addDeposit(amount);

        internalFund += amount ;

        System.out.println(amount+"$ deposited;current balance "+account.getBalance()+"$");
    }


    public void withdraw(Account account,double amount){


        String type = this.getClass().getSimpleName();

        if(amount>account.getBalance() || (account instanceof Student && amount>10000) || (account instanceof Savings && (account.getBalance()-amount)<1000) || (account instanceof FixedDeposit && year<1)){
            System.out.println("Invalid Transaction. Current balance "+account.getBalance()+"$");
            return ;
        }

        account.withdraw(amount);

        internalFund -= amount ;

        System.out.println("Transaction successful.Current balance "+account.getBalance()+"$");

    }

    public void requestLoan(Account account,double loan){


        if((account instanceof Savings && loan>10000) || (account instanceof Student && loan>1000) || (account instanceof FixedDeposit && loan>100000)){
            System.out.println("Invalid Loan Request");
            return ;
        }


        Loan loanRequest = new Loan(account,loan);

        loanRequests.add(loanRequest);

        pending ++ ;

        System.out.println("Loan request successful, sent for approval");
    }

    public boolean hasPendingLoan(){

        return pending != 0;

    }

    public void approveLoan(Employee employee) {

        if(employee instanceof Cashier){
            System.out.println("You don't have permission for this operation");
            return ;
        }

        for(Loan loanReq : loanRequests){

            if(loanReq.getStatus()==0){

                loanReq.setStatus(1);
                pending -- ;


                loanReq.getAccount().grantLoan(loanReq.getLoan());

                internalFund -= loanReq.getLoan();

                System.out.println("Loan for "+loanReq.getAccount().getName()+" approved");
            }
        }
    }

    public void lookup(String name){

        Account account = isAvailable(name);

        if(account==null){
            System.out.println("No such account");
            return ;
        }

        System.out.println(name+"'s current balance "+account.getBalance());
    }


    public void incrementYear(){

         year ++ ;

        for(Account account:accounts){

            updateFundAndAccount(account);
        }

        System.out.println(year +" year passed");
    }

    private void updateFundAndAccount(Account account) {

        internalFund -= account.depositedInterest() ;

        internalFund += account.updateAccount();

    }


    public void showInternalFund(Employee employee) {

        if(employee instanceof ManagingDirector){
            System.out.println("Internal Fund "+internalFund);
        }else{
            System.out.println("You don't have permission for this operation");
        }
    }

    public void changeInterestRate(Employee employee, String type, double depositInterest) {

        if(!(employee instanceof ManagingDirector)){
            System.out.println("You don't have permission for this operation");
            return ;
        }

        if(type.equalsIgnoreCase("Student")) {
            studentInterest = depositInterest / 100 ;
            System.out.println(studentInterest);
        } else if(type.equalsIgnoreCase("Savings"))
            savingsInterest = depositInterest/100 ;
        else
            fixedDepositInterest = depositInterest/100 ;


        System.out.println("Interest rate change for "+type+".New interest rate "+depositInterest);
    }
}


