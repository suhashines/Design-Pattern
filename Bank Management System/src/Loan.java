public class Loan {
    private Account account;
    private int status;

    private double loan ;

    Loan(Account account, double loan) {
        this.account = account;
        this.status = 0;
        this.loan = loan ;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getLoan() {
        return loan;
    }
}
