package assi2;

class BankAccount implements BankingOperations, CustomerOperations {

    private int accNo;
    private String name;
    private double balance;

    BankAccount(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amt) {
        balance += amt;
        System.out.println("Amount Deposited: " + amt);
    }

    public void withdraw(double amt) throws Exception {
        if (amt > balance)
            throw new Exception("Insufficient Balance");
        balance -= amt;
        System.out.println("Amount Withdrawn: " + amt);
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void showCustomerDetails() {
        System.out.println("Account No: " + accNo);
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        try {
            BankAccount b = new BankAccount(101, "Annu", 5000);
            b.showCustomerDetails();
            b.deposit(2000);
            b.withdraw(3000);
            b.checkBalance();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


interface BankingOperations {
    void deposit(double amt);
    void withdraw(double amt) throws Exception;
    void checkBalance();
}

interface CustomerOperations {
    void showCustomerDetails();
}
