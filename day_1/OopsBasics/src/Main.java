

class BankAccount{
    private String accName;
    private int accNumber;
    private float accBalance;

    public BankAccount(String name, int accNumber, float balance) {
        this.accName = name;
        this.accNumber = accNumber;
        this.accBalance = balance;
    }

    public void deposit(float amount) {
        if(amount <= 0) {
            throw new ArithmeticException("Amount should be greater than 0.");
        }

        this.accBalance += amount;
        System.out.println(amount + " deposited.");
    }

    public void withdraw(float amount) {
        if(amount <= 0) {
            throw new ArithmeticException("Amount should be greater than zero.");
        }

        if(amount > this.accBalance) {
            System.out.println("Unable to withdraw " + amount + ". \ncurrent balance: " + this.accBalance);
        } else {
            this.accBalance -= amount;
            System.out.println(amount + " withdrawn.");
        }
    }

    public void accountDetails(){
        System.out.println("========================");
        System.out.println("Account Details");
        System.out.println("========================");
        System.out.println("A/C Holder Name: " + this.accName);
        System.out.println("Account Number: " + this.accNumber);
        System.out.println("Account Balance: " + this.accBalance);
    }
}

public class Main {

    public static void main(String[] args) {
        String name = "Himanshu Kandpal";
        int accountNumber = 15071999;
        float balance = 11000.00f;

        BankAccount bankAcc = new BankAccount(name, accountNumber, balance);
        bankAcc.deposit(1500.00f);
        bankAcc.withdraw(5500.67f);
        bankAcc.accountDetails();
    }
}