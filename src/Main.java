import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Name, password & minimum balance to create an account: ");

        // create user
        String name = sc.nextLine();
        String password = sc.nextLine();
        double balance = sc.nextDouble();

        // user object
        SBIUser sbiUser = new SBIUser(name, password, balance);

        // add money
        String message = sbiUser.addMoney(500);
        System.out.println(message);

        // account no
        System.out.println("Your account no. is: " + sbiUser.yourAccountNo());

        //  withdraw money
        System.out.println("Enter how much money you want to withdraw: ");
        int moneyWithdraw = sc.nextInt();

        System.out.println("Enter your password: ");
        String pass = sc.next();

        System.out.println(sbiUser.withDrawMoney(moneyWithdraw, pass));

    }
}