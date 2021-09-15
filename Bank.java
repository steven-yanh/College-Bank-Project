import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class Bank 
{
    private static int capacity = 100000;
    public static BankAccount[] accounts;
    public static int numAccounts;
    public Bank()
    {
        accounts = new BankAccount[capacity];
        numAccounts = 0;
    }
    public Bank(String fileName) throws IOException
    {
        this();
        int i = 0;
        int num;
        Name n;
        MonetaryValue b;
        MonetaryValue over;
        File myfile = new File(fileName);
        Scanner file = new Scanner(myfile);
        //ChekingAccount cAccount;
        //SavingsAccount sAccount;
        
        while(file.hasNext())
        {
            String type = file.next();
            if(type.equals("s"))
            {   
                num = file.nextInt();
                n = new Name(file.next(), file.next());
                b = new MonetaryValue(file.nextDouble());
                accounts[i] = new SavingsAccount(num, n, b);
                numAccounts++;
                i++;
                
            }
            else if(type.equals("c"))
            {
                num = file.nextInt();
                n = new Name(file.next(), file.next());
                b = new MonetaryValue(file.nextDouble());
                over = new MonetaryValue(file.nextDouble());
                accounts[i] = new ChekingAccount(num, n, b, over);
                numAccounts++;
                i++;
               

            }
        }
        file.close();
    }
    @Override
    public String toString()
    {
        String print = "";
        for(int i = 0; i < numAccounts;i++)
            print += accounts[i].toString();
        return print;
    }
    private static int indexOf(int num) 
    {
        int index=0;
        boolean found = false;
        for(int i = 0; i < numAccounts;i++)
        {
            if(accounts[i].getAccountNumber() == num)
            {
                index = i;
                found = true;
            }
        }
        if(found)
            return index;
        else 
            return -1;
    }
    public static boolean contains(int num)
    {
        boolean found = false;
        for(int i = 0; i < numAccounts;i++)
        {
            if(accounts[i].getAccountNumber() == num)
                found = true;
        }
        return found;
    }
    public static boolean isFull()
    {
        if(numAccounts == capacity)
            return true;
        else
            return false;
    }
    public static MonetaryValue getBalance(int num)
    {
        MonetaryValue b;
        if(Bank.contains(num))
            b = new MonetaryValue(accounts[indexOf(num)].balance);
        else
            return null;
        return b;
    }
    public static String getAccountInfo(int num)
    {
        String info = "";
        if(Bank.contains(num))
        {
            if(accounts[indexOf(num)] instanceof ChekingAccount)
                info += accounts[indexOf(num)].toString()
                +"\nMonthly interest: $0.00\n ";
            else 
                info += accounts[indexOf(num)].toString();
        }
        else 
            return null;
        return info;
    }
    public static boolean deposit(int num, MonetaryValue amount)
    {
        if(Bank.contains(num) && !amount.isNegative())
        {
            accounts[indexOf(num)].deposit(amount);
            return true;
        }
        else 
            return false;
    }
    public static boolean withdraw(int num, MonetaryValue amount)
    {
        if(Bank.contains(num) && !amount.isNegative())
        {
            if(accounts[indexOf(num)].withdraw(amount))
                return true;
            else 
                return false;
        }
        else 
            return false;
    }
    public static boolean add (int num)
    {
        if (Bank.contains(num))
            return false;
        else 
        {
            Scanner sc = new Scanner (System.in);
            System.out.print("Enter first name: ");
            String first = sc.next();
            System.out.print("Enter last name: ");
            String last = sc.next();
            Name n = new Name(first, last);
            MonetaryValue b = new MonetaryValue(0);
            String type = "";
            System.out.println("Account type?\nSavingsAccount) Enter S   Cheking Acount) Enter C");
            type = sc.next().toUpperCase();
            if(type.equals("S"))
                accounts[numAccounts] = new SavingsAccount(num, n, b);
            else   
            {
                MonetaryValue over = new MonetaryValue(100);
                accounts[numAccounts] = new ChekingAccount(num, n, b, over);
            }
            numAccounts++;
            return true;
        }
    }
    public static boolean remove (int num)
    {
        if(Bank.contains(num))
        {
            for (int i = indexOf(num);i < numAccounts;i++)
            {
                accounts[i] = accounts[i+1];
            }
            numAccounts--;
            return true;
        }
        else 
            return false;
    }
}
