import java.util.Objects;
import java.util.UUID;

public class SBIUser implements BankInterface {

    // attributes
    private String name;
    private String accountNo;
    private String password;
    private double balance;
    private static double rateOfInterest;

    public SBIUser(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;

        // bank itself initilize
        this.rateOfInterest = 6.5;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }

    // getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getRateOfInterest() {
        return rateOfInterest;
    }

    public static void setRateOfInterest(double rateOfInterest) {
        SBIUser.rateOfInterest = rateOfInterest;
    }



    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int amount) {
        balance = balance + amount;
        return "Your new balance is: " + balance;
    }

    @Override
    public String withDrawMoney(int amount, String enteredPassword) {
        // jodi passward and entered password same hoi taholei transition hobe otherwise hobe na.
        if(Objects.equals(enteredPassword, password)){
            if(balance <= amount){
                return "You have insufficient money";
            } else {
                balance = balance - amount;
                return "You successfully withdraw your money. \nYour current balance is: " + balance;
            }
        } else{
            return "You entered wrong password!";
        }
    }

    @Override
    public double calculateInterest(int years) {
       return (balance*years*rateOfInterest)/100;
    }

    @Override
    public double afterWithDrawMoney() {
        return 0;
    }

    @Override
    public String yourAccountNo() {
        return accountNo;
    }
}
