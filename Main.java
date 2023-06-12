class BankAccount {
String accountNumber;
String accountHolderName;
double balance;

    public BankAccount(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
    }


    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of Rs" + amount + " successful.");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of Rs" + amount + " successful.");
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: Rs" + balance);
    }

    
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class SavingsAccount extends BankAccount {
double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, double interestRate) {
        super(accountNumber, accountHolderName);
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    public void updateBalanceWithInterest() {
        double interest = calculateInterest();
        deposit(interest);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}






public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("3232311131", "Jatin Agrawal");
        
	bankAccount.deposit(1000);
        bankAccount.displayAccountDetails();
       
	bankAccount.withdraw(500);
        bankAccount.displayAccountDetails();

        SavingsAccount savingsAccount = new SavingsAccount("9688547321", "Shiv Agrawal", 7);
        savingsAccount.deposit(20000);
        savingsAccount.displayAccountDetails();

        savingsAccount.updateBalanceWithInterest();
        savingsAccount.displayAccountDetails();
    }
}
