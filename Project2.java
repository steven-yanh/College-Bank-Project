
import java.io.IOException;
import java.util.Scanner;
public class Project2 
{
    public static void main(String[] args) throws IOException
    {
        if(args.length != 1)
        {
            System.out.println("Please provide usage data");
            System.exit(0);
        }
        Scanner sc = new Scanner(System.in);
        SavingsAccount.setInterestRate(1.5);
        Bank bank = new Bank("data.txt");
        System.out.println(Bank.numAccounts); 
        
        boolean notend = true;
        char choice;
        int num = 0;
        MonetaryValue amount;
        do
        {
            choice = menu(sc);
            switch(choice)
            {
                case 'l':
                case 'L':
                System.out.print("Enter Account number: ");
                num = sc.nextInt();
                if(Bank.contains(num))
                    System.out.println((Bank.getBalance(num)).toString());
                else
                    System.out.println("Account doesn't exist\n");
                break;
                case 'p':
                case 'P':
                System.out.print("Enter Account number: ");
                num = sc.nextInt();
                if(Bank.contains(num))
                    System.out.println((Bank.getAccountInfo(num)));
                else
                    System.out.println("Account doesn't exist\n");
                break;
                case 'd':
                case 'D':
                System.out.print("Enter Account number: ");
                num = sc.nextInt();
                if(Bank.contains(num))
                {
                    System.out.print("Enter deposit amount: $");
                    double deposit = sc.nextDouble();
                    amount = new MonetaryValue(deposit);
                    if(Bank.deposit(num, amount))
                    {
                        System.out.println("Sucessfully deposited amount: " + amount.toString());
                        System.out.println("New Balance:" + Bank.getBalance(num).toString());
                    }
                    else 
                        System.out.println("Error: Please enter correct amount");
                }
                else
                    System.out.println("Account doesn't exist\n");
                break;
                case 'w':
                case 'W':
                System.out.print("Enter Account number: ");
                num = sc.nextInt();
                if(Bank.contains(num))
                {
                    System.out.print("Enter withdraw amount: $");
                    double withdraw = sc.nextDouble();
                    amount = new MonetaryValue(withdraw);
                    if(Bank.withdraw(num, amount))
                    {
                        System.out.println("Sucessfully withdraw amount: " + amount.toString());
                        System.out.println("New Balance:" + Bank.getBalance(num).toString());
                    }
                    else 
                        System.out.println("Error: Please enter correct amount or insufficient fund");
                }
                else
                    System.out.println("Account doesn't exist\n");
                break;
                case 'a':
                case 'A':
                System.out.print("Enter Account number: ");
                num = sc.nextInt();
                if(Bank.contains(num))
                    System.out.println("Account already exist");
                else
                {
                    Bank.add(num);
                    System.out.println("Sucessfully add an Account");
                    System.out.println(Bank.getAccountInfo(num));
                }
                break;
                case 'r':
                case 'R':
                System.out.print("Enter Account number: ");
                num = sc.nextInt();
                if(Bank.remove(num))
                    System.out.println("Sucessfully removed");
                else
                    System.out.println("Error: Account doesn't exist");
                break;
                case 'q':
                case 'Q':
                System.out.println("Thank you!");
                notend = false;   
                break;
                default:
                    System.out.println("Selection doesn't exist try again");
                    break;
                

            }
        }while(notend);
    }
    public static char menu(Scanner sc)
    {
        char choice;
        System.out.println("Please select the type of transaction following\n"
                + "L) Lookup balance\n"
                + "P) Print information about the account\n"
                + "D) Deposit\n"
                + "W) Withdraw\n"
                + "A) Add new Account\n" 
                + "R) Remove account\n"
                + "Q) Quit\n");
        choice = sc.next().charAt(0);
        return choice;
    }
}